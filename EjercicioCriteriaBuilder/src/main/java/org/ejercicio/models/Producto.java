package org.ejercicio.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false, length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private long categoria_Id;

    @Column(name = "precio")
    private double precio;

    @Column (name = "stock",nullable = false)
    private int stock;

    @Column (name = "fecha_ingreso",nullable = false)
    private Date fecha_ingreso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCategoria_Id() {
        return categoria_Id;
    }

    public void setCategoria_Id(int categoria_Id) {
        this.categoria_Id = categoria_Id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
}


