package com.crud.models;

import com.crud.enums.EnumCor;
import com.crud.enums.EnumTamanho;
import com.crud.enums.EnumTipoItem;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ItemModel {

    private int CodigoItem;

    private Date DataEntrada;

    private String LocalCompra;

    private EnumTipoItem Tipo;

    private String Marca;

    private String Caracteristicas;

    private EnumTamanho Tamanho;

    private EnumCor Cor;

    private double ValorPago;

    private double ValorMargem;

    private double PrecoSugerido;

    public ItemModel() {
    }


    public int getCodigoItem() {
        return CodigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        CodigoItem = codigoItem;
    }

    public Date getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        DataEntrada = dataEntrada;
    }

    public String getLocalCompra() {
        return LocalCompra;
    }

    public void setLocalCompra(String localCompra) {
        LocalCompra = localCompra;
    }

    public EnumTipoItem getTipo() {
        return Tipo;
    }

    public void setTipo(EnumTipoItem tipo) {
        Tipo = tipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        Caracteristicas = caracteristicas;
    }

    public EnumTamanho getTamanho() {
        return Tamanho;
    }

    public void setTamanho(EnumTamanho tamanho) {
        Tamanho = tamanho;
    }

    public EnumCor getCor() {
        return Cor;
    }

    public void setCor(EnumCor cor) {
        Cor = cor;
    }

    public double getValorPago() {
        return ValorPago;
    }

    // Seta o valor pago e já calcula o valor de margem
    public void setValorPago(double valorPago) {
        ValorPago = valorPago;
        setValorMargem();
    }

    public double getValorMargem() {
        return ValorMargem;
    }

    public void setValorMargem() {
        ValorMargem = ValorPago*2;
    }

    public double getPrecoSugerido() {
        return PrecoSugerido;
    }

    public void setPrecoSugerido(double precoSugerido) {
        PrecoSugerido = precoSugerido;
    }

    public static EnumTipoItem[] getEnumsTipo() {
        return Arrays.stream(EnumTipoItem.values()).toArray(EnumTipoItem[]::new);

    }
    public static EnumCor[] getEnumsCor() {
        return Arrays.stream(EnumCor.values()).toArray(EnumCor[]::new);

    }
    public static EnumTamanho[] getEnumsTamanho() {
        return Arrays.stream(EnumTamanho.values()).toArray(EnumTamanho[]::new);

    }
    public String PrintItem()
    {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String result="";
        result="Id: " + String.valueOf(CodigoItem) + "\n";
        result= result + "Data de entrada: " + sdf.format(DataEntrada.getTime()) + "\n";
        result= result + "Local de compra: " +  LocalCompra+ "\n";
        result= result + "Tipo: " +  Tipo.name()+ "\n";
        result= result + "Marca: " +  Marca+ "\n";
        result= result + "Carcaterísticas: " +  Caracteristicas+ "\n";
        result= result + "Tamanho: " +  Tamanho.name()+ "\n";
        result= result + "Cor: " +  Cor.name()+ "\n";
        result= result + "Valor Pago: " +  String.valueOf(ValorPago)+ "\n";
        result= result + "Valor de Margem: " +  String.valueOf(ValorMargem)+ "\n";
        result= result + "Preço Sugerido: " +  String.valueOf(PrecoSugerido)+ "\n";

        return result;
    }
}
