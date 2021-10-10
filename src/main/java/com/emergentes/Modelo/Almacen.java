
package com.emergentes.Modelo;


public class Almacen {
    private int id;
    private String descripciones;
    private int cantidades;
    private int precios;

    public Almacen() {
        this.id=0;
        this.descripciones="";
        this.precios=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(String descripciones) {
        this.descripciones = descripciones;
    }

    public int getCantidades() {
        return cantidades;
    }

    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }

    public int getPrecios() {
        return precios;
    }

    public void setPrecios(int precios) {
        this.precios = precios;
    }
   
}
