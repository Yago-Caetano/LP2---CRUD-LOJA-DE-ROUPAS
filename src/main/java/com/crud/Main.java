package com.crud;

import com.crud.controllers.ItemController;
import com.crud.dao.ItemDAO;
import com.crud.models.ItemModel;
import com.crud.views.*;

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


    static ItemDAO Estoque;
    static ItemController controller;
    static boolean FlagSair=false;

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
            controller.inserirItem(Item);
            return true;
        }

        @Override
        public ItemModel GetItem(int id) {
            return controller.getItem(id);
        }

        @Override
        public void EditarItem(ItemModel item) {
            controller.editarItem(item);
        }

        @Override
        public void ExcluirItem(ItemModel Item) {
            controller.deletarItem(Item);
        }

        @Override
        public ArrayList<ItemModel> GetEstoque() {
            return controller.getAllItens();
        }

        @Override
        public void ExitProgram() {
            FlagSair=true;
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

        gerenciarTelas();

        while (!FlagSair)
        {
            aguardaInput();
        }
    }


    public static void gerenciarTelas()
    {
        IndiceDeTelaSelecionado = 0;
        Estoque= new ItemDAO();
        controller= new ItemController();
        Estoque.lerItens();
        //Agenda= new AgendaModel();
        Telas = new ArrayList<PadraoView>();

        Telas.add(new TelaPrincipalView());
        Telas.add(new TelaCadastroView());
        Telas.add(new TelaEdicaoView());
        Telas.add(new TelaDeleteView());
        // Telas.add(new TelaAgendaView());

        //Telas.add(new TelaDeletarView());

        mostraTelaSelecionada();

    }
    private static void mostraTelaSelecionada()
    {
        Telas.get(IndiceDeTelaSelecionado).mostraTela(cbTela);

    }




    /*public static void main(String[] args)
    {
        ItemDAO dao = new ItemDAO();
        System.out.println("Rodou");

        //Testes
        ArrayList<ItemModel> lista = new ArrayList<ItemModel>();

        ItemModel item = new ItemModel();
        item.setCor(EnumCor.Vermelho);
        item.setCodigoItem(1);
        item.setCaracteristicas("teste");
        item.setMarca("Avon");
        Date data = new Date();
        data.setTime(25/02/2001);
        item.setDataEntrada(data);
        item.setLocalCompra("Coop");
        item.setTamanho(EnumTamanho.Medio);
        item.setTipo(EnumTipoItem.Camisa);
        item.setPrecoSugerido(BigInteger.valueOf(20));
        item.setValorMargem(BigInteger.valueOf(22));
        item.setValorPago(BigInteger.valueOf(18));

        ItemModel item2 = new ItemModel();
        item2.setCor(EnumCor.Azul);
        item2.setCodigoItem(2);
        item2.setCaracteristicas("teste");
        item2.setMarca("Avon");
        item2.setDataEntrada(data);
        item2.setLocalCompra("Coop");
        item2.setTamanho(EnumTamanho.Grande);
        item2.setTipo(EnumTipoItem.Jeans);
        item2.setPrecoSugerido(BigInteger.valueOf(20));
        item2.setValorMargem(BigInteger.valueOf(22));
        item2.setValorPago(BigInteger.valueOf(18));

        lista.add(item);
        lista.add(item2);
        Gson gson = new Gson();
        String json = gson.toJson(lista);

        try {
            FileWriter writer = new FileWriter("Compras.json");
            writer.write(json);
            System.out.println(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ItemDAO Dao = new ItemDAO();
        Dao.lerItens();
        Dao.deleteItem(2);
        Dao.insertItem(item2);
        item.setTipo(EnumTipoItem.Saia);
        Dao.updateItem(item);

        ArrayList<ItemModel> listaTeste = Dao.selectAll();
        for (ItemModel a: listaTeste
             ) {
            System.out.println(a.getTipo() + " - " + a.getValorPago());
        }

        ItemModel teste = Dao.selectItem(2);
        System.out.println(teste.getTipo() + " - " + teste.getLocalCompra());

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um texto:");
        sc.next();
    }*/
}
