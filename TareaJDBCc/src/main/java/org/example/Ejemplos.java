package org.example;

import oracle.net.nt.TcpNTAdapter;
import org.example.modelo.Usuario;
import org.example.modelo.UsuarioDao;

import java.sql.Connection;

public class Ejemplos {

    public static void main(String[] args) {

        UsuarioDao usuarioDao = new UsuarioDao();


        System.out.println(usuarioDao.listar());

        usuarioDao.borrar(3L);
        usuarioDao.borrar(4L);
        usuarioDao.borrar(5L);
        usuarioDao.borrar(6L);
        usuarioDao.borrar(7L);
        usuarioDao.borrar(8L);
        usuarioDao.borrar(9L);
        usuarioDao.borrar(10L);

        System.out.println(usuarioDao.listar());


    }
}
