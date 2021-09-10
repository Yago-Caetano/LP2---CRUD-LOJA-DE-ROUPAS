package com.crud.views;

import com.crud.enums.EnumCor;
import com.crud.enums.EnumTamanho;
import com.crud.enums.EnumTipoItem;
import com.crud.models.ItemModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.lang.Integer.parseInt;

public abstract class PadraoView {

    private String Cabecalho;
    private int Id;
    protected TelaCallback Callback;

    protected ItemModel Item;
    protected byte menu;

    protected EnumTipoItem[] EnumsTipoArray;
    protected EnumCor[] EnumsCorArray;
    protected EnumTamanho[] EnumsTamanhoArray;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setCabecalho(String cabecalho) {
        Cabecalho = cabecalho;
    }

    public void montaCabecalho()
    {
        System.out.println(String.format("######################## %s ###########################",Cabecalho));
    }

    protected void exibeNoConsole(String texto)
    {
        System.out.println(texto);
    }

    public abstract void mostraTela(TelaCallback callback);

    public abstract void manipulaInput(String Input);

    String ExibeTipoIem()
    {
        String data="";
        int counter=1;
        for(EnumTipoItem value: EnumTipoItem.values()){
            data=data+"Digite "+ counter++ +" -> " + value.name()+"\n";
        }
        return data;
    }
    String ExibeTamanho()
    {
        String data="";
        int counter=1;
        for(EnumTamanho value: EnumTamanho.values()){
            data=data+"Digite "+ counter++ +" -> " + value.name()+"\n";
        }
        return data;
    }
    String ExibeCor()
    {
        String data="";
        int counter=1;
        for(EnumCor value: EnumCor.values()){
            data=data+"Digite "+ counter++ +" -> " + value.name()+"\n";
        }
        return data;
    }
    boolean GetDataEntrada(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            Item.setDataEntrada(sdfDate.parse(Input));
            menu=proximoEstado;
            exibeNoConsole(ProximaMsg);
            return true;
        }
        catch (ParseException ex)
        {
            menu=estadoErro;
            exibeNoConsole(MsgErro);
            return false;
        }

    }
    boolean GetLocalCompra(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        Item.setLocalCompra(Input);
        menu=proximoEstado;
        exibeNoConsole(ProximaMsg);
        return true;
    }
    boolean GetEnumTipo(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        int indice ;
        try
        {
            indice= parseInt(Input);
            if(indice-1<EnumsTipoArray.length && indice >0)
            {
                Item.setTipo(EnumsTipoArray[indice-1]);
                menu=proximoEstado;
                exibeNoConsole(ProximaMsg);
                return true;
            }
            else
            {
                exibeNoConsole(MsgErro);
                return false;
            }


        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole(MsgErro);
            return false;
        }




    }
    boolean GetMarca(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        Item.setMarca(Input);
        menu=proximoEstado;
        exibeNoConsole(ProximaMsg);
        return true;
    }
    boolean GetCaracateristicas(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        Item.setCaracteristicas(Input);
        menu=proximoEstado;
        exibeNoConsole(ProximaMsg);
        return true;
    }
    boolean GetEnumTamanho(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        int indice ;
        try
        {
            indice= parseInt(Input);
            if(indice-1<EnumsTamanhoArray.length && indice >0)
            {
                Item.setTamanho(EnumsTamanhoArray[indice-1]);

                menu=proximoEstado;
                exibeNoConsole(ProximaMsg);
                return true;
            }
            else
            {
                exibeNoConsole(MsgErro);
                return false;
            }
        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole(MsgErro);
           return false;
        }


    }
    boolean GetEnumCor(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        int indice ;
        try
        {
            indice= parseInt(Input);
            if(indice-1<EnumsCorArray.length && indice >0)
            {
                Item.setCor(EnumsCorArray[indice-1]);
                menu=proximoEstado;
                exibeNoConsole(ProximaMsg);
                return true;
            }
            else
            {
                exibeNoConsole(MsgErro);
                return false;
            }
        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole(MsgErro);
            return false;
        }

    }
    boolean GetValorPago(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        double valor ;
        try
        {
            valor= Double.parseDouble(Input);
            Item.setValorPago(valor);
            exibeNoConsole(ProximaMsg);
            menu=proximoEstado;
            return true;

        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole(MsgErro);
            ExibeTipoIem();
            return false;
        }

    }
    boolean GetPrecoSugerido(String Input,byte proximoEstado, byte estadoErro, String ProximaMsg, String MsgErro)
    {
        double valor ;
        try
        {
            valor= Double.parseDouble(Input);
            Item.setPrecoSugerido(valor);
            exibeNoConsole(ProximaMsg);
            return true;

        }
        catch(NumberFormatException ex)
        {
            exibeNoConsole(MsgErro);
            return false;
        }
    }
}
