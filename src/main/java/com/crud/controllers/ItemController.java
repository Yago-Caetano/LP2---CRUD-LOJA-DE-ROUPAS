package com.crud.controllers;

import com.crud.dao.ItemDAO;
import com.crud.models.ItemModel;

import javax.print.attribute.standard.DateTimeAtProcessing;
import java.io.IOException;
import java.util.ArrayList;

public class ItemController {


    /**
     * O metodo espera um dado do tipo item
     * para realizar a inserção
     * @param Item
     */
    public void inserirItem(ItemModel Item)
    {
        ValidaDados(Item);
        ItemDAO item = new ItemDAO();
        if(Item != null){
            item.insertItem(Item);
            }
        else {
                System.out.println("Não é possível salvar o item, pois ele não foi fornecido");
            }

    }

    /**
     *
     * @param Item
     */
    public void editarItem(ItemModel Item)
    {

        String err = "";
        try {
            ItemDAO item = new ItemDAO();
            if(item.selectItem(Item.getCodigoItem()) != null){
                item.updateItem(Item);
            } else {
              err = "O código fornecido não corresponde a nenhum item.";
              throw new Exception(err);
            }
        } catch (Exception e){
            e.printStackTrace() ;
        }
    }

    /**
     *
     * @param Item
     */
    public void deletarItem(ItemModel Item)
    {
        String err = "";
        try{
            ItemDAO item = new ItemDAO();
            if(item.selectItem(Item.getCodigoItem()) != null){
                item.deleteItem(Item.getCodigoItem());
            } else {
                err = "O item não existe ou não foi informado!";
                throw new Exception(err);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public ItemModel getItem(int Id)
    {
        String err = "";
        ItemDAO item = new ItemDAO();

        return item.selectItem(Id);
    }

    public ArrayList<ItemModel> getAllItens()
    {
        ItemDAO item = new ItemDAO();
        return item.selectAll();
    }

    protected void ValidaDados(ItemModel Item){

        if(Item.getLocalCompra() == null){
            throw new IllegalArgumentException("O local de compra deve ser fornecido!");
        }
        if(Item.getTipo() == null){
            throw new IllegalArgumentException("O tipo do item é obrigatório");
        }
        if(Item.getMarca() == null){
            throw new IllegalArgumentException("A marca do item é obrigatória");
        }
        if(Item.getCaracteristicas() == null){
            throw new IllegalArgumentException("A marca do item é obrigatória");
        }
        if(Item.getTamanho() == null){
            throw new IllegalArgumentException("A data do item é obrigatória");
        }
        if(Item.getCor() == null){
            throw new IllegalArgumentException("A cor do item é obrigatória");
        }

    }
}
