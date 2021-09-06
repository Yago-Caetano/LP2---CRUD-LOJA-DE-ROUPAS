package com.crud.models;

import java.util.ArrayList;
import java.util.List;

public class EstoqueModel {
    List<ItemModel> Estoque;

    private int MaiorID;

    public EstoqueModel() {
        MaiorID=-1;
        Estoque = new ArrayList<>();
        FetchData();
    }

    public int SolicitarID()
    {
        return MaiorID+1;
    }

    public ItemModel GetItemById(int id)
    {
        for(int counter = 0; counter < Estoque.size(); counter++)
        {
            if(Estoque.get(counter).getCodigoItem() == id)
            {
                return Estoque.get(counter);
            }
        }
        return null;
    }
    public boolean cadastrarItemModel(ItemModel Item)
    {
        Estoque.add(Item);
        MaiorID=Item.getCodigoItem();
        //Salva dados utilizando ItemDAO
        return true;
    }
    public boolean editarItemModel(ItemModel Item)
    {
        return true;
    }
    public boolean deletarItemModel(ItemModel Item)
    {
        return true;
    }


}
