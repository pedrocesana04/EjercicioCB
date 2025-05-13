package org.ejercicio;

import org.ejercicio.service.ProductoService;

public class Main {
    public static void main(String[] args) {
        ProductoService logica = ProductoService.getInstance();
        logica.obtenerNombreProductoYNombreCategoria();
    }
}