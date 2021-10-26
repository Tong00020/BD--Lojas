/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Budget;

/**
 *
 * @author Tong
 */
public class BudgetDAO {
    
    public void create(Budget p) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO budget (id,price,amount,subtotal,budgcol,description)VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setFloat(2, p.getPrice());
            stmt.setInt(3, p.getAmount());
            stmt.setDouble(4, p.getSubtotal());
            stmt.setDouble(6, p.getBudgcol());
            stmt.setString(7, p.getDescription());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
     public List<Budget> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Budget> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budget");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Budget produto = new Budget();

                produto.setId(rs.getInt("id"));
                produto.setPrice(rs.getFloat("price"));
                produto.setAmount(rs.getInt("amount"));
                produto.setSubtotal(rs.getDouble("subtotal"));
                produto.setBudgcol(rs.getDouble("budgcol"));
                produto.setDescription(rs.getString("description"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(BudgetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;

    }
     
     public List<Budget> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Budget> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budget WHERE description LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Budget produto = new Budget();

                produto.setId(rs.getInt("id"));
                produto.setPrice(rs.getFloat("price"));
                produto.setAmount(rs.getInt("amount"));
                produto.setSubtotal(rs.getDouble("subtotal"));
                produto.setBudgcol(rs.getDouble("budgcol"));
                produto.setDescription(rs.getString("description"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BudgetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
     
     public void update(Budget p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE budget SET price = ? ,amount = ?,subtotal = ? WHERE budgcol = ?");
            stmt.setDouble(1, p.getPrice());
            stmt.setInt(2, p.getAmount());
            stmt.setDouble(3, p.getSubtotal());
            stmt.setDouble(4, p.getBudgcol());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
     public void delete(Budget p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM budget WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     
    public void alter(Budget p) throws Exception {
    }

    public void delete(int id) throws Exception {
    }

    public ArrayList<Budget> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

    public Budget loadID(int id) throws Exception {
        //TODO: especificar retorno
        return null;
    }
    
    
}
