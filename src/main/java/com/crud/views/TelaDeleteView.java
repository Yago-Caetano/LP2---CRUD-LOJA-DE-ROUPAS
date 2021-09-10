package com.crud.views;

import com.crud.models.ItemModel;
import jdk.nashorn.internal.codegen.CompilerConstants;

public class TelaDeleteView extends  PadraoView{

    public TelaDeleteView()
    {
        setId(6);
    }

    final static byte GET_ID = 0;
    final static byte CONFIRMA_DELETE = 1;
    @Override
    public void mostraTela(TelaCallback callback) {
        Callback = callback;
        setCabecalho("DELETAR ROUPAS");
        Item= new ItemModel();
        montaCabecalho();
        ExibeMenu();
        menu=GET_ID;

    }

    private void GetID(String input)
    {
        int Del_ID;
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
                exibeNoConsole("Digite 's' para deletar este item");
                menu= CONFIRMA_DELETE;
            }

        }
        catch (NumberFormatException ex){
            MsgDesistir_Continuar();

        }

    }

    @Override
    public void manipulaInput(String Input) {
        switch (menu)
        {
            case GET_ID:
                GetID(Input);
                break;
            case CONFIRMA_DELETE:
                Confirmar_Delete(Input);
                break;
        }

    }
    private void ExibeMenu() {

        exibeNoConsole("Digite o ID do item que deseja deletar");
        exibeNoConsole("exit para sair deste menu");
    }
    private void MsgDesistir_Continuar()
    {
        exibeNoConsole("ID digitado não é valido!");
        ExibeMenu();
    }
    private void Confirmar_Delete(String input)
    {
        switch(input)
        {
            case "s":
                Callback.ExcluirItem(Item);
                Callback.trocarTela(0);
                break;
        }
        ExibeMenu();

    }
}
