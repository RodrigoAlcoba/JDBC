package org.example;

import org.example.conection.ConexionBaseDatos;
import org.example.modelos.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try (Connection con = ConexionBaseDatos.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============ listar productos ============");

            repositorio.buscarTodos().forEach(System.out::println);

            System.out.println("============ obtener por id ============");
            System.out.println(repositorio.buscarPorId(2L));

            System.out.println("============ editar producto ============");
            Producto producto = new Producto();
            producto.setId(4L);
            producto.setNombre("Teclado mecanico");
            producto.setPrecio(700);
            repositorio.guardar(producto);
            System.out.println("Producto editado con exito");
            repositorio.buscarTodos().forEach(System.out::println);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
}

