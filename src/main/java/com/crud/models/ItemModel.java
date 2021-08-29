package com.crud.models;

import com.crud.enums.EnumCor;
import com.crud.enums.EnumTamanho;
import com.crud.enums.EnumTipoItem;

import java.math.BigInteger;
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

    private BigInteger ValorPago;

    private BigInteger ValorMargem;

    private BigInteger PrecoSugerido;

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

    public BigInteger getValorPago() {
        return ValorPago;
    }

    public void setValorPago(BigInteger valorPago) {
        ValorPago = valorPago;
    }

    public BigInteger getValorMargem() {
        return ValorMargem;
    }

    public void setValorMargem(BigInteger valorMargem) {
        ValorMargem = valorMargem;
    }

    public BigInteger getPrecoSugerido() {
        return PrecoSugerido;
    }

    public void setPrecoSugerido(BigInteger precoSugerido) {
        PrecoSugerido = precoSugerido;
    }
}
