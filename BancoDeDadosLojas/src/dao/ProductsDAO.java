/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Products;

/**
 *
 * @author Tong
 */
public class ProductsDAO {
     public void create(Products p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (id,name,description,category,price,barcode,photo)VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getDescription());
            stmt.setString(4, p.getCategory());
            stmt.setDouble(5, p.getPrice());
            stmt.setInt(6, p.getBarcode());
            stmt.setString(7, p.getPhoto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    
}
