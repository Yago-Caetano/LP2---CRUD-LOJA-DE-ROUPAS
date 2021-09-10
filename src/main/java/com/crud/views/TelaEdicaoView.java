package com.crud.views;

import com.crud.models.ItemModel;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.Calendar;

public class TelaEdicaoView extends PadraoView {

    private int Del_ID;


    final static byte GET_ID = 0;
    final static byte OPCOES_EDICAO = 1;
    final static byte EDITAR_DATA_ENTRADA = 2;
    final static byte EDITAR_LOCALCOMPRA = 3;
    final static byte EDITAR_TIPO = 4;
    final static byte EDITAR_MARCA = 5;
    final static byte EDITAR_CARACTERISTICAS = 6;
    final static byte EDITAR_TAMANHO = 7;
    final static byte EDITAR_COR = 8;
    final static byte EDITAR_VALOR_PAGO_MARGEM = 9;
    final static byte EDITAR_PRECO_SUGERIDO = 10;
    final static byte CONFIRMA_EDICAO = 11;


    public TelaEdicaoView() {
        setId(2);
    }

    @Override
    public void mostraTela(TelaCallback callback) {
        menu = GET_ID;
        Item= new ItemModel();
        EnumsTipoArray=ItemModel.getEnumsTipo();
        EnumsCorArray=ItemModel.getEnumsCor();
        EnumsTamanhoArray=ItemModel.getEnumsTamanho();
        Callback = callback;
        setCabecalho("EDITAR COMPROMISSOS");
        montaCabecalho();
        ExibeMenu();


    }

    @Override
    public void manipulaInput(String Input) {

        if(Input.equals("exit"))
        {
            Callback.trocarTela(0);
            return;
        }
        switch (menu)
        {
            case GET_ID:
                GetID(Input);
                break;
            case OPCOES_EDICAO:
                InputOpcoesEdicao(Input);
                break;
            case EDITAR_DATA_ENTRADA :
                GetDataEntrada(Input,OPCOES_EDICAO,EDITAR_DATA_ENTRADA,
                        ExibeMenuOpcoesEdicao(), "Data inválida!\nDigite a nova data de entrada no formato> dd/MM/yyyy");
                break;
            case EDITAR_LOCALCOMPRA :
                GetLocalCompra(Input,OPCOES_EDICAO,(byte)0,ExibeMenuOpcoesEdicao(),"");
                break;
            case EDITAR_TIPO :
                GetEnumTipo(Input,OPCOES_EDICAO,(byte)0,
                        ExibeMenuOpcoesEdicao(),"Opção inválida!\n"+ExibeTamanho());
                break;
            case EDITAR_MARCA :
                GetMarca(Input,OPCOES_EDICAO,(byte)0,ExibeMenuOpcoesEdicao(),"");
                break;
            case EDITAR_CARACTERISTICAS :
                GetCaracateristicas(Input,OPCOES_EDICAO,(byte)0,ExibeMenuOpcoesEdicao(),"");
                break;
            case EDITAR_TAMANHO :
                GetEnumTamanho(Input,OPCOES_EDICAO,(byte)0,ExibeMenuOpcoesEdicao(),"Opção Inválida!\n"+ExibeTamanho());
                break;
            case EDITAR_COR :
                GetEnumCor(Input,OPCOES_EDICAO,(byte)0,ExibeMenuOpcoesEdicao(),"Opção Inválida!\n"+ExibeCor());
                break;
            case EDITAR_VALOR_PAGO_MARGEM :
                GetValorPago(Input,OPCOES_EDICAO,(byte)0,ExibeMenuOpcoesEdicao(),"Valor inválido!");
                break;
            case EDITAR_PRECO_SUGERIDO :
                GetPrecoSugerido(Input,OPCOES_EDICAO,(byte)0,ExibeMenuOpcoesEdicao(),"");
                break;
            case CONFIRMA_EDICAO:
                Confirmar_Edicao(Input);
                break;
        }

    }


    private void InputOpcoesEdicao(String input)
    {
        switch(input)
        {
            case "1":
                exibeNoConsole("Digite a nova data de entrada no formato> dd/MM/yyyy");
                menu=EDITAR_DATA_ENTRADA ;
                break;
            case "2":
                exibeNoConsole("Digite o novo local de compra:");
                menu=EDITAR_LOCALCOMPRA ;
                break;
            case "3":
                exibeNoConsole("Escolha o novo tipo:\n"+ExibeTipoIem());
                menu=EDITAR_TIPO;
                break;
            case "4":
                exibeNoConsole("Digite a nova marca:");
                menu=EDITAR_MARCA ;
                break;
            case "5":
                exibeNoConsole("Digite as novas características:");
                menu=EDITAR_CARACTERISTICAS ;
                break;
            case "6":
                exibeNoConsole("Escolha o novo tamanho\n"+ExibeTamanho());
                ExibeTamanho();
                menu=EDITAR_TAMANHO ;
                break;
            case "7":
                exibeNoConsole("Escolha a cor:\n"+ExibeCor());
                menu=EDITAR_COR ;
                break;
            case "8":
                exibeNoConsole("Digite o novo valor pago:");
                menu=EDITAR_VALOR_PAGO_MARGEM ;
                break;
            case "9":
                exibeNoConsole("Digite o novo preço sugerido:");
                menu=EDITAR_PRECO_SUGERIDO ;
                break;
            case "save":
                exibeNoConsole("Deseja salvar essa edicao? digite 's'");
                menu=CONFIRMA_EDICAO;

                break;
        }

    }
    private void Confirmar_Edicao(String input)
    {
        switch(input)
        {
            case "s":
                Callback.EditarItem(Item);
                Callback.trocarTela(0);
                break;
            default:
                ExibeMenuOpcoesEdicao();
                break;
        }

    }
    private void GetID(String input)
    {
        if (input.equals("exit"))
        {
            Callback.trocarTela(0);
            return;
        }
        try
        {
            Del_ID = Integer.parseInt(input);
            Item= Callback.GetItem(Del_ID);
            if(Item==null)
                MsgDesistir_Continuar();
            else
            {
                exibeNoConsole("Item encontrado..");
                exibeNoConsole(Item.PrintItem());
                menu= OPCOES_EDICAO;
                exibeNoConsole(ExibeMenuOpcoesEdicao());
            }

        }
        catch (NumberFormatException ex){
            MsgDesistir_Continuar();

        }

    }

    private String ExibeMenuOpcoesEdicao() {
        String dat="";
        dat="Digite 1 -> Editar Data de Entrada\n";
        dat=dat+"Digite 2 -> Editar Local de compra";
        dat=dat+"Digite 3 -> Editar Tipo do Item\n";
        dat=dat+"Digite 4 -> Editar Marca\n";
        dat=dat+"Digite 5 -> Editar Caracteríticas\n";
        dat=dat+"Digite 6 -> Editar Tamanho\n";
        dat=dat+"Digite 7 -> Editar Cor\n";
        dat=dat+"Digite 8 -> Editar Valor pago\n";
        dat=dat+"Digite 9 -> Editar Preço sugerido\n";

        dat=dat+"Digite 'save' para salvar ou 'exit' para sair deste menu\n";
        return dat;
    }
    private void ExibeMenu() {

        exibeNoConsole("Digite o ID do item que deseja editar");
        exibeNoConsole("exit para sair deste menu");
    }
    private void MsgDesistir_Continuar()
    {
        exibeNoConsole("ID digitado não é valido!");
        ExibeMenu();
    }

}