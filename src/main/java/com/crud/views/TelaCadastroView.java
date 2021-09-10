package com.crud.views;


import com.crud.models.ItemModel;


public class TelaCadastroView extends  PadraoView{

    public TelaCadastroView()
    {
        setId(1);
    }


    private byte CADASTRAR_DATA_ENTRADA=0;
    private byte CADASTRAR_LOCALCOMPRA=1;
    private byte CADASTRAR_ENUM_TIPO=2;
    private byte CADASTRAR_MARCA=3;
    private byte CADASTRAR_CARACTERISTICAS=4;
    private byte CADASTRAR_ENUM_TAMANHO=5;
    private byte CADASTRAR_ENUM_COR=6;
    private byte CADASTRAR_VALOR_PAGO_MARGEM=7;
    private byte CADASTRAR_PRECO_SUGERIDO=8;
    private byte CADASTRAR_TERMINADO=9;



    @Override
    public void mostraTela(TelaCallback callback) {
        Callback = callback;
        setCabecalho("CADASTRAR ROUPAS");
        Item= new ItemModel();
        montaCabecalho();
        EnumsTipoArray=ItemModel.getEnumsTipo();
        EnumsCorArray=ItemModel.getEnumsCor();
        EnumsTamanhoArray=ItemModel.getEnumsTamanho();
        exibeNoConsole("Pressione '0' para cancelar");
        exibeNoConsole("Digite a data de entrada no formato dd/MM/yyyy e pressione 'ENTER'");
        menu=CADASTRAR_DATA_ENTRADA;
    }



    @Override
    public void manipulaInput(String Input)  {

        if (Input.equals("0"))
            Callback.trocarTela(0);
        else
        {
            if (menu==CADASTRAR_DATA_ENTRADA)
                GetDataEntrada(Input,CADASTRAR_LOCALCOMPRA,(byte)0, "Digite local da compra e pressione 'ENTER'",
                        "Data inválida!" + "\n"+"Digite a data de entrada no formato dd/MM/yyyy e pressione 'ENTER'");

            else if (menu==CADASTRAR_LOCALCOMPRA)
                GetLocalCompra(Input,CADASTRAR_ENUM_TIPO,(byte)0, "Escolha o tipo de item:\n"+ExibeTipoIem(),"" );


            else if (menu==CADASTRAR_ENUM_TIPO)
                GetEnumTipo(Input,CADASTRAR_MARCA,(byte)0,"Digite a marca e pressione 'ENTER'",
                        "Opção inválida!\n"+ExibeTipoIem());



            else if (menu==CADASTRAR_MARCA)
                GetMarca(Input,CADASTRAR_CARACTERISTICAS,(byte)0,"Digite a característica do item e pressione 'ENTER'","");


            else if (menu==CADASTRAR_CARACTERISTICAS)
                GetCaracateristicas(Input,CADASTRAR_ENUM_TAMANHO,(byte)0,"Escolha o tamanho de item:\n"+ExibeTamanho(),"");

            else if (menu==CADASTRAR_ENUM_TAMANHO)
                GetEnumTamanho(Input,CADASTRAR_ENUM_COR,(byte)0,
                        "Escolha a cor do item:\n"+ExibeCor(),"Opção inválida!\n"+ExibeTamanho());


            else if (menu==CADASTRAR_ENUM_COR)
                GetEnumCor(Input,CADASTRAR_VALOR_PAGO_MARGEM,(byte)0,
                        "Digite o valor pago e pressione 'ENTER'","Opção inválida!\n"+ExibeCor());


            else if (menu==CADASTRAR_VALOR_PAGO_MARGEM)
                GetValorPago(Input,CADASTRAR_PRECO_SUGERIDO,(byte)0,
                        "Digite o preço sugerido e pressione 'ENTER'","Valor inválido! digite novamente!");

            else if (menu==CADASTRAR_PRECO_SUGERIDO)
            {
                if(GetPrecoSugerido(Input,CADASTRAR_TERMINADO,(byte)0,"","Valor inválido! digite novamente!"))
                    finalizacao();
            }



        }

    }


    void finalizacao()
    {
        Callback.InsertItem(Item);
        exibeNoConsole(Item.PrintItem());
        Callback.trocarTela(0);
    }



}