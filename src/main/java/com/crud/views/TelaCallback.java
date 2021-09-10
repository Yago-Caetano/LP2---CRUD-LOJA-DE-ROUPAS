package com.crud.views;

import com.crud.models.ItemModel;

import java.util.ArrayList;

public interface TelaCallback {

    void trocarTela(int idTela);
    boolean InsertItem (ItemModel Item);
    ItemModel GetItem(int id);
    void EditarItem(ItemModel item);
    void ExcluirItem(ItemModel Item);
    ArrayList<ItemModel>GetEstoque();
    void ExitProgram();


}
