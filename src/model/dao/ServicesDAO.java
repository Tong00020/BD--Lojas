/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Services;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class ServicesDAO {

    public void create(Services s) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO services (name,description) VALUES (?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getDescription());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Services s) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE services SET name=?,description=? WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getDescription());
            stmt.setInt(3, s.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Services p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM services WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Services> list() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Services> services = new ArrayList<>();
        try {
            String sql = "SELECT * FROM services";
            stmt = con.prepareStatement(sql);
            /*
            ResultSet é uma interface utilizada pra guardar dados vindos 
            de um banco de dados.
            
            Basicamente, ela guarda o resultado de uma pesquisa numa estrutura 
            de dados que pode ser percorrida, de forma que você possa ler os 
            dados do banco.
             */
            rs = stmt.executeQuery();
            while (rs.next()) {
                Services s = new Services();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDescription(rs.getString("description"));
                services.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return services;
    }

    public List<Services> loadById(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Services> services = new ArrayList<>();

        try {
            String sql = "SELECT * FROM services WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Services s = new Services();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDescription(rs.getString("description"));
                services.add(s);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return services;
    }

    /*     public List<Services> read()  {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Services> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM services");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Services produto = new Services();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setDescription(rs.getString("description"));
                produtos.add(produto);
                
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return produtos;

    }
    
    public List<Services> readForDesc(String desc)  {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Services> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM services WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Services produto = new Services();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setDescription(rs.getString("description"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;

    } */
}
