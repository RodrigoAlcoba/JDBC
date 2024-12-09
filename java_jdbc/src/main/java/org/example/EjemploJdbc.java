package org.example;

import org.example.conection.ConexionBaseDatos;
import org.example.modelos.Categoria;
import org.example.modelos.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection con = ConexionBaseDatos.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============ listar productos ============");

            repositorio.buscarTodos().forEach(System.out::println);

            System.out.println("============ obtener por id ============");
            System.out.println(repositorio.buscarPorId(2L));

            System.out.println("============ insertar nuevo producto ============");
            Producto producto = new Producto();
            producto.setNombre("Prueba De Hora 2");
            producto.setPrecio(20);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.buscarTodos().forEach(System.out::println);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
}

