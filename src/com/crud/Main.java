package com.crud;

import Views.PadraoView;
import Views.TelaCadastroView;
import Views.TelaCallback;
import Views.TelaPrincipalView;
import com.crud.dao.ItemDAO;
import com.crud.models.EstoqueModel;
import com.crud.models.ItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int TELA_INICIAL = 0;
    public static final int TELA_CADASTRO_COMPROMISSO = 1;
    public static final int TELA_EDICAO_COMPROMISSO = 2;
    public static final int TELA_SELECIONAR_COMPROMISSO = 3;
    public static final int TELA_ALARME = 4;
    public static final int TELA_AGENDA = 5;
    public static final int TELA_DELETAR = 6;


    private static EstoqueModel Estoque;
    private static List<PadraoView> Telas;
    private static int IndiceDeTelaSelecionado;

    /*
        Callback das telas
     */
    static TelaCallback cbTela = new TelaCallback() {
        @Override
        public void trocarTela(int idTela) {
            for(int counter = 0; counter < Telas.size(); counter++)
            {
                if(Telas.get(counter).getId() == idTela)
                {
                    IndiceDeTelaSelecionado = counter;
                    mostraTelaSelecionada();
                }
            }
        }

        @Override
        public boolean InsertItem(ItemModel Item) {
            return Estoque.cadastrarItemModel(Item);
        }

        @Override
        public EstoqueModel GetEstoque() {
            return Estoque;
        }

        @Override
        public int SolicitarID() {
            return Estoque.SolicitarID();
        }

    };

    private static void aguardaInput()
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Telas.get(IndiceDeTelaSelecionado).manipulaInput(input);
    }

    public static void main(String[] args)
    {
        ItemDAO dao = new ItemDAO();

        gerenciarTelas();

        while (true)
        {
            aguardaInput();
        }
    }


    public static void gerenciarTelas()
    {
        IndiceDeTelaSelecionado = 0;
        //Agenda= new AgendaModel();
        Telas = new ArrayList<PadraoView>();

        Telas.add(new TelaPrincipalView());
        Telas.add(new TelaCadastroView());
       // Telas.add(new TelaAgendaView());
        //Telas.add(new TelaEdicaoView());
        //Telas.add(new TelaDeletarView());

        mostraTelaSelecionada();

    }
    private static void mostraTelaSelecionada()
    {
        Telas.get(IndiceDeTelaSelecionado).mostraTela(cbTela);

    }
}
