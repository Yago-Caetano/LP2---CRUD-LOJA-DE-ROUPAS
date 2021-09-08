package com.crud.views;

import com.crud.dao.ItemDAO;
import com.crud.enums.EnumCor;
import com.crud.enums.EnumTamanho;
import com.crud.enums.EnumTipoItem;
import com.crud.models.ItemModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.lang.Integer.parseInt;

public class TelaCadastroView extends  PadraoView{

    public TelaCadastroView()
    {
        setId(1);
    }
    private ItemModel Item;
    private byte menu;

    private byte CADASTRAR_DATA_ENTRADA=0;
    private byte CADASTRAR_LOCALCOMPRA=1;
    private byte CADASTRAR_ENUM_TIPO=2;
    private byte CADASTRAR_MARCA=3;
    private byte CADASTRAR_CARACTERISTICAS=4;
    private byte CADASTRAR_ENUM_TAMANHO=5;
    private byte CADASTRAR_ENUM_COR=6;
    private byte CADASTRAR_VALOR_PAGO_MARGEM=7;
    private byte CADASTRAR_PRECO_SUGERIDO=8;

    EnumTipoItem[] EnumsTipoArray;
    EnumCor[] EnumsCorArray;
    EnumTamanho[] EnumsTamanhoArray;

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
                GetDataEntrada(Input);

            else if (menu==CADASTRAR_LOCALCOMPRA)
                GetLocalCompra(Input);
            else if (menu==CADASTRAR_ENUM_TIPO)
                GetEnumTipo(Input);
            else if (menu==CADASTRAR_MARCA)
                GetMarca(Input);
            else if (menu==CADASTRAR_CARACTERISTICAS)
                GetCaracateristicas(Input);
            else if (menu==CADASTRAR_ENUM_TAMANHO)
                GetEnumTamanho(Input);
            else if (menu==CADASTRAR_ENUM_COR)
                GetEnumCor(Input);
            else if (menu==CADASTRAR_VALOR_PAGO_MARGEM)
                GetValorPago(Input);
            else if (menu==CADASTRAR_PRECO_SUGERIDO)
                GetPrecoSugerido(Input);

        }

    }
    void GetDataEntrada(String Input)
    {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            Item.setDataEntrada(sdfDate.parse(Input));
            menu=CADASTRAR_LOCALCOMPRA;
            exibeNoConsole("Digite local da compra e pressione 'ENTER'");
        }
        catch (ParseException ex)
        {
            exibeNoConsole("Data inválida!");
            exibeNoConsole("Digite a data de entrada no formato dd/MM/yyyy e pressione 'ENTER'");
            menu=CADASTRAR_DATA_ENTRADA;
        }

    }
    void GetLocalCompra(String Input)
    {
        Item.setLocalCompra(Input);
        exibeNoConsole("Escolha o tipo de item:");
        ExibeTipoIem();
        menu=CADASTRAR_ENUM_TIPO;
    }
    void GetEnumTipo(String Input)
    {
        int indice ;
        try
        {
            indice= parseInt(Input);
            if(indice-1<EnumsTipoArray.length && indice >0)
            {
                Item.setTipo(EnumsTipoArray[indice-1]);
                exibeNoConsole("Digite a marca e pressione 'ENTER'");
                menu=CADASTRAR_MARCA;
            }
            else
            {
                exibeNoConsole("Opção inválida!");
                ExibeTipoIem();
            }
        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole("Opção inválida!");
            ExibeTipoIem();
        }


    }
    void GetMarca(String Input)
    {
        Item.setMarca(Input);
        exibeNoConsole("Digite a característica do item e pressione 'ENTER'");
        menu=CADASTRAR_CARACTERISTICAS;
    }
    void GetCaracateristicas(String Input)
    {
        Item.setCaracteristicas(Input);
        exibeNoConsole("Escolha o tamanho de item:");
        ExibeTamanho();
        menu=CADASTRAR_ENUM_TAMANHO;
    }
    void GetEnumTamanho(String Input)
    {
        int indice ;
        try
        {
            indice= parseInt(Input);
            if(indice-1<EnumsTamanhoArray.length && indice >0)
            {
                Item.setTamanho(EnumsTamanhoArray[indice-1]);
                exibeNoConsole("Escolha a cor do item:");
                ExibeCor();
                menu=CADASTRAR_ENUM_COR;
            }
            else
            {
                exibeNoConsole("Opção inválida!");
                ExibeTamanho();
            }
        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole("Opção inválida!");
            ExibeTamanho();
        }


    }
    void GetEnumCor(String Input)
    {
        int indice ;
        try
        {
            indice= parseInt(Input);
            if(indice-1<EnumsCorArray.length && indice >0)
            {
                Item.setCor(EnumsCorArray[indice-1]);
                exibeNoConsole("Digite o valor pago e pressione 'ENTER'");
                menu=CADASTRAR_VALOR_PAGO_MARGEM;
            }
            else
            {
                exibeNoConsole("Opção inválida!");
                ExibeCor();
            }
        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole("Opção inválida!");
            ExibeCor();
        }


    }
    void GetValorPago(String Input)
    {
        double valor ;
        try
        {
            valor= Double.parseDouble(Input);
            Item.setValorPago(valor);
            exibeNoConsole("Digite o preço sugerido e pressione 'ENTER'");
            menu=CADASTRAR_PRECO_SUGERIDO;

        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole("Valor inválido! digite novamente!");
            ExibeTipoIem();
        }

    }
    void GetPrecoSugerido(String Input)
    {
        double valor ;
        try
        {
            valor= Double.parseDouble(Input);
            Item.setPrecoSugerido(valor);
            finalizacao();

        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole("Valor inválido! digite novamente!");
            ExibeTipoIem();
        }
    }
    void finalizacao()
    {

        Item.setCodigoItem(Callback.SolicitarID());
        exibeNoConsole(Item.PrintItem());
        Callback.trocarTela(0);

    }
    void ExibeTipoIem()
    {
        int counter=1;
        for(EnumTipoItem value: EnumTipoItem.values()){
            System.out.println("Digite "+ counter++ +" -> " + value.name());
        }
    }
    void ExibeTamanho()
    {
        int counter=1;
        for(EnumTamanho value: EnumTamanho.values()){
            System.out.println("Digite "+ counter++ +" -> " + value.name());
        }
    }
    void ExibeCor()
    {
        int counter=1;
        for(EnumCor value: EnumCor.values()){
            System.out.println("Digite "+ counter++ +" -> " + value.name());
        }
    }


}