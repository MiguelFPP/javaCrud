package org.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.java.jdbc.modelo.Producto;
import org.java.jdbc.util.ConexionBaseDatos;

import repositorio.ProductoRepositorio;
import repositorio.repositorio;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstacnce();) {
            repositorio<Producto> repositorio = new ProductoRepositorio();

            System.out.println("---Actualizar producto---");
            Producto nuevoProducto = new Producto();
            nuevoProducto.setId(2L);
            nuevoProducto.setNombre("Nuevo producto2");
            nuevoProducto.setPrecio(1000);
            repositorio.guardar(nuevoProducto);
            System.out.println("Producto actualizado: " + nuevoProducto);

            System.out.println("---Listado de productos---");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
