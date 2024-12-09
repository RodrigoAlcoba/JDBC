package org.example.repositorio;

import java.util.List;

public interface Repositorio<T> {

    List<T> buscarTodos();

    T buscarPorId(Long id);

    void guardar(T t);

    void borrar(Long id);

}