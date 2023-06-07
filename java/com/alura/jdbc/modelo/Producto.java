package com.alura.jdbc.modelo;

public class Producto {

    private Integer id;
    private String nombre;
    private String Descripcion;
    private Integer cantidad;

    public Producto( String nombre, String descripcion, Integer cantidad) {
        this.nombre = nombre;
        Descripcion = descripcion;
        this.cantidad = cantidad;
    }
}
