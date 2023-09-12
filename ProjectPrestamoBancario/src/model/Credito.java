/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class Credito {

    private String cliente;
    private int identificacion;
    private int codigo;
    private int capitalCredito;
    private int numeroCuota;
    private double tazaInteres;

    public Credito(String cliente, int identificacion, int codigo, int capitalCredito, int numeroCuota, double tazaInteres) {
        this.cliente = cliente;
        this.identificacion = identificacion;
        this.codigo = codigo;
        this.capitalCredito = capitalCredito;
        this.numeroCuota = numeroCuota;
        this.tazaInteres = tazaInteres;
    }

    public Credito() {
        cliente = "";
        identificacion = 0;
        codigo = 0;
        capitalCredito = 0;
        numeroCuota = 0;
        tazaInteres = 0;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapitalCredito() {
        return capitalCredito;
    }

    public void setCapitalCredito(int capitalCredito) {
        this.capitalCredito = capitalCredito;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getTazaInteres() {
        return tazaInteres;
    }

    public void setTazaInteres(double tazaInteres) {
        this.tazaInteres = tazaInteres;
    }

}
