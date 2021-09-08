package com.crud.dao;

import com.crud.models.ItemModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ItemDAO {

    public ItemDAO() {

    }

    static ArrayList<ItemModel> listaItens = new ArrayList<ItemModel>();

    public void lerItens(){
            Gson gson = new Gson();

            try {
                Type ItemListType = new TypeToken<ArrayList<ItemModel>>(){}.getType();
               BufferedReader br = new BufferedReader(new FileReader("Compras.json"));

                listaItens = gson.fromJson(br, ItemListType);
                //ItemModel item = gson.fromJson(br, ItemModel.class);

                //listaItens.add(item);

                for (ItemModel item: listaItens
                     ) {
                    System.out.println(item.getCodigoItem() + " - " + item.getTipo());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void salvarItens(){
        Gson gson = new Gson();
        String json = gson.toJson(listaItens);

        try {
           FileWriter writer = new FileWriter("Compras.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertItem(ItemModel item){
        listaItens.add(item);
        salvarItens();
    }

    public void deleteItem(int id){

        //Uso do Iterator para evitar ConcurrentModificationException
        for (Iterator<ItemModel> iterator = listaItens.iterator(); iterator.hasNext();) {
            ItemModel item = iterator.next();
            if(item.getCodigoItem() == id) {
                iterator.remove();
            }
        }
    }

    public void updateItem(ItemModel item){
        boolean removeu = false;
        //Uso do Iterator para evitar ConcurrentModificationException
        for (Iterator<ItemModel> iterator = listaItens.iterator(); iterator.hasNext();) {
            ItemModel itemDaLista = iterator.next();
            if(item.getCodigoItem() == itemDaLista.getCodigoItem()) {
                iterator.remove();
                removeu = true;
            }
        }

        if(removeu){
            listaItens.add(item);
            salvarItens();
        }
    }

    public ItemModel selectItem(int id){
        for(ItemModel item : listaItens) {
            if(item.getCodigoItem() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<ItemModel> selectAll(){
        return listaItens;
    }

}

