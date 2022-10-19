package org.java.jdbc;

import java.sql.*;

import org.java.jdbc.modelo.Producto;
import org.java.jdbc.util.ConexionBaseDatos;

import repositorio.ProductoRepositorio;
import repositorio.repositorio;

public class EjemploJdbc {
    /*
     * public static void main(String[] args) {
     * 
     * try(Connection conn=ConexionBaseDatos.getInstacnce();
     * Statement stmt=conn.createStatement();
     * ResultSet resultado=stmt.executeQuery("SELECT * FROM productos")) {
     * 
     * while (resultado.next()){
     * System.out.print(resultado.getInt("id"));
     * System.out.print(" | ");
     * System.out.print(resultado.getString("nombre"));
     * System.out.print(" | ");
     * System.out.print(resultado.getInt("precio"));
     * System.out.print(" | ");
     * System.out.println(resultado.getDate("fecha_registro"));
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }
     * }
     */

    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstacnce();) {
            repositorio<Producto> repositorio = new ProductoRepositorio();

            System.out.println("---Listado de productos---");
            repositorio.listar().forEach(System.out::println);

            System.out.println("---Producto por id---");
            System.out.println(repositorio.porId(1L));

            System.out.println("---Nuevo producto---");
            Producto nuevoProducto = new Producto();
            nuevoProducto.setNombre("Nuevo producto");
            nuevoProducto.setPrecio(1000);
            nuevoProducto.setFechaRegistro(new java.util.Date());
            repositorio.guardar(nuevoProducto);
            System.out.println("Producto guardado: " + nuevoProducto);

            System.out.println("---Listado de productos---");
            repositorio.listar().forEach(System.out::println);

            System.out.println("---Eliminar producto---");
            repositorio.eliminar(2L);
            
            System.out.println("---Listado de productos---");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
