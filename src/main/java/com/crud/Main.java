package com.crud;

import com.crud.dao.ItemDAO;
import com.crud.enums.EnumCor;
import com.crud.enums.EnumTamanho;
import com.crud.enums.EnumTipoItem;
import com.crud.models.ItemModel;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
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
    }
}
