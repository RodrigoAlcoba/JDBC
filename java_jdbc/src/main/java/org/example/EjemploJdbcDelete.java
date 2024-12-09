package org.example;

import org.example.conection.ConexionBaseDatos;
import org.example.modelos.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        try (Connection con = ConexionBaseDatos.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============ listar productos ============");

            repositorio.buscarTodos().forEach(System.out::println);

            System.out.println("============ obtener por id ============");
            System.out.println(repositorio.buscarPorId(2L));

            System.out.println("============ eliminar producto ============");
            repositorio.borrar(3L);
            System.out.println("Producto eliminado con exito");
            repositorio.buscarTodos().forEach(System.out::println);
            repositorio.borrar(4L);
            repositorio.borrar(5L);
            repositorio.borrar(6L);
            repositorio.borrar(7L);
            repositorio.borrar(8L);
            repositorio.borrar(9L);




        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
}

