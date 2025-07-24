package com.msmartbuy.dao;

import com.msmartbuy.modelo.Producto;
import com.msmartbuy.util.ConexionDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO producto (nombre, marca, cantidad, descripcion, sku, peso, precio_unitario, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getMarca());
            pstmt.setString(3, producto.getCantidad());
            pstmt.setString(4, producto.getDescripcion());
            pstmt.setString(5, producto.getSku());
            pstmt.setString(6, producto.getPeso());
            pstmt.setDouble(7, producto.getPrecioUnitario());
            pstmt.setString(8, producto.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getLong("ID"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setCantidad(rs.getString("cantidad"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setSku(rs.getString("sku"));
                producto.setPeso(rs.getString("peso"));
                producto.setPrecioUnitario(rs.getDouble("precio_unitario"));
                producto.setEstado(rs.getString("estado"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, marca = ?, cantidad = ?, descripcion = ?, precio_unitario = ?, estado = ? WHERE ID = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getMarca());
            pstmt.setString(3, producto.getCantidad());
            pstmt.setString(4, producto.getDescripcion());
            pstmt.setDouble(5, producto.getPrecioUnitario());
            pstmt.setString(6, producto.getEstado());
            pstmt.setLong(7, producto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(long id) {
        String sql = "DELETE FROM producto WHERE ID = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
