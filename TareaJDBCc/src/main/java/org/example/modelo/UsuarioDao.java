package org.example.modelo;

import org.example.controlador.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IDaoMethods{

    Connection conn;

    private Connection obtenerConexion() throws SQLException {
        return DatabaseConnection.getInstace();
    }

    @Override
    public void guardar(Object o) {
        String sql;

        if (((Usuario) o).getIdUsuario() != null && ((Usuario) o).getIdUsuario() > 0){
            sql = "UPDATE USUARIOS SET USERNAME = ?, PASSWORD = ?, EMAIL = ? " +
                    "WHERE ID = ?";
        }else {
            sql = "INSERT INTO USUARIOS (USERNAME, PASSWORD, EMAIL) VALUES (?,?,?)";
        }

        try(PreparedStatement statement = obtenerConexion().prepareStatement(sql)){
            statement.setString(1, ((Usuario) o).getUsername());
            statement.setString(2, ((Usuario) o).getPassword());
            statement.setString(3,  ((Usuario) o).getEmail());

            if (((Usuario) o).getIdUsuario() != null && ((Usuario) o).getIdUsuario() > 0){
                statement.setLong(4, ((Usuario) o).getIdUsuario());
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void borrar(Long id) {
        String sql = "DELETE FROM USUARIOS WHERE ID = ?";
        try(PreparedStatement statement = obtenerConexion().prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> listar() {

        List<Usuario> usuarios = new ArrayList<>();

        try (Statement statement = obtenerConexion().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIOS ORDER BY ID")){

            while (resultSet.next()){
                usuarios.add(crearUsuario(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public Object buscarPorId(int id) {
        return null;
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public Object buscarPorEmail(String email) {
        return null;
    }

    private static Usuario crearUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getLong("ID"));
        usuario.setUsername(resultSet.getString("USERNAME"));
        usuario.setPassword(resultSet.getString("PASSWORD"));
        usuario.setEmail(resultSet.getString("EMAIL"));

        return usuario;
    }
}
