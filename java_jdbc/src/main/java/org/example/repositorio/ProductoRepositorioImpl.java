package org.example.repositorio;

import org.example.conection.ConexionBaseDatos;
import org.example.modelos.Categoria;
import org.example.modelos.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> buscarTodos() {
        List<Producto> productos = new ArrayList<>();

        try (
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT p.*, c.nombre AS categoria FROM productos AS p " +
                    "INNER JOIN categorias AS c ON p.categoria_id = c.id")){
            while (resultSet.next()) {
                Producto p = crearProducto(resultSet);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto buscarPorId(Long id) {
        Producto producto = null;
        try(PreparedStatement statement = getConnection().
                prepareStatement("SELECT p.*, c.nombre AS categoria FROM productos AS p " +
                        "INNER JOIN categorias AS c ON p.categoria_id = c.id WHERE p.id = ?")){

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public  void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId() > 0){
            sql = "UPDATE productos SET nombre = ?, precio = ? , categoria_id = ? where id = ?";
        }else {
            sql = "INSERT INTO productos (nombre, precio, categoria_id, fecha_registro ) VALUES (?, ?, ?, ?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0){
                stmt.setLong(4, producto.getId());
            }else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void borrar(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM productos WHERE id = ?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_Registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
