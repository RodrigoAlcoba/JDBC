package org.example.modelo;

import java.util.List;

public interface IDaoMethods <T>{

    void guardar(T t);


    void borrar(Long id);

    List<T> listar();

    T buscarPorId(int id);

    T buscarPorNombre(String nombre);

    T buscarPorEmail(String email);
}
