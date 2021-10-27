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
import model.bean.Ordens;

/**
 *
 * @author Tong
 */
public class OrdensDAO {
    
    public void create(Ordens p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ordens (id,total,total_itens,observation,price_services,situation)VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setDouble(2, p.getTotal());
            stmt.setInt(3, p.getTotal_itens());
            stmt.setString(4, p.getObservation());
            stmt.setDouble(5, p.getPrice_services());
            stmt.setString(6, p.getSituation());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

     public List<Ordens> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ordens> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ordens");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ordens produto = new Ordens();

                produto.setId(rs.getInt("id"));
                produto.setTotal(rs.getDouble("total"));
                produto.setTotal_itens(rs.getInt("total_itens"));
                produto.setObservation(rs.getString("observation"));
                produto.setPrice_services(rs.getFloat("price_services"));
                produto.setSituation(rs.getString("situation"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrdensDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;

    }
     
     public List<Ordens> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ordens> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ordens WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ordens produto = new Ordens();

                produto.setId(rs.getInt("id"));
                produto.setTotal(rs.getDouble("total"));
                produto.setTotal_itens(rs.getInt("total_itens"));
                produto.setObservation(rs.getString("observation"));
                produto.setPrice_services(rs.getFloat("price_services"));
                produto.setSituation(rs.getString("situation"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrdensDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Ordens p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE ordens SET total = ? ,total_itens = ? ,observation = ? ,price_services = ? ,situation = ? WHERE id = ?");
            
            stmt.setDouble(1, p.getTotal());
            stmt.setInt(2, p.getTotal_itens());
            stmt.setString(3, p.getObservation());
            stmt.setDouble(4, p.getPrice_services());
            stmt.setString(5, p.getSituation());
            stmt.setInt(1, p.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Ordens p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM ordens WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Ordens e) throws Exception {
    }

    public void delete(int cpf) throws Exception {
    }

    public ArrayList<Ordens> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

     public Ordens loadID(int id) throws Exception {
        //TODO: especificar retorno
        return null;
    }
}
