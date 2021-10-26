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
import model.bean.Privileges;

/**
 *
 * @author Tong
 */ 
public class PrivilegesDAO {
    
    public void create(Privileges p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO privileges (id,name,is_superadm)VALUES(?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getIs_superadm());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

     public List<Privileges> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Privileges> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM privileges");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Privileges produto = new Privileges();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setIs_superadm(rs.getString("is_superadm"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrivilegesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
   
     public List<Privileges> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Privileges> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM privileges WHERE name LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Privileges produto = new Privileges();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setIs_superadm(rs.getString("is_superadm"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrivilegesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Privileges p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE privileges SET is_superadm = ? WHERE id = ?");
            stmt.setString(1, p.getIs_superadm());
            stmt.setInt(2, p.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Privileges p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM privileges WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void alter(Privileges e) throws Exception {
    }

    public void delete(int cpf) throws Exception {
    }

    public ArrayList<Privileges> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

     public Privileges loadID(int id) throws Exception {
        //TODO: especificar retorno
        return null;
    }
}
