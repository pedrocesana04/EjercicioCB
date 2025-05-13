package org.ejercicio.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.ejercicio.models.Categoria;
import org.ejercicio.models.Producto;
import org.ejercicio.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductoService {
    private static ProductoService instance;

    private ProductoService() {
    }

    public static ProductoService getInstance() {
        if (instance == null) {
            instance = new ProductoService();
        }
        return instance;
    }


    public void obtenerNombreProductoYNombreCategoria(){
        try (Session session = HibernateUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
            Root<Producto> producto = query.from(Producto.class);
            Join<Producto, Categoria> categoria = producto.join("categoria");

            query.select(cb.array(producto.get("nombre"), categoria.get("nombre")));

            List<Object[]> resultados = session.createQuery(query).getResultList();
            for (Object[] resultado : resultados) {
                System.out.println("Producto: " + resultado[0] + ", Categoría: " + resultado[1]);
            }
        }
    }
}
