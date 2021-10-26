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
import model.bean.Clients;

/**
 *
 * @author Tong
 */
public class ClientsDAO {
     public void create(Clients p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO clients (cpf,name,address,complement,state,city,cep,fixed_phone,cell_phone,email)VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getCpf());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getAddress());
            stmt.setString(4, p.getComplement());
            stmt.setString(5, p.getState());
            stmt.setString(6, p.getCity());
            stmt.setInt(7, p.getCep());
            stmt.setInt(8, p.getFixed_phone());
            stmt.setInt(9, p.getCell_phone());
            stmt.setString(10, p.getEmail());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

      public List<Clients> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Clients> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clients");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Clients produto = new Clients();

                produto.setCpf(rs.getInt("cpf"));
                produto.setName(rs.getString("name"));
                produto.setAddress(rs.getString("address"));
                produto.setComplement(rs.getString("complement"));
                produto.setState(rs.getString("state"));
                produto.setCity(rs.getString("city"));
                produto.setCep(rs.getInt("cep"));
                produto.setFixed_phone(rs.getInt("fixed_phone"));
                produto.setCell_phone(rs.getInt("cell_phone"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;

    }
     
      public List<Clients> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Clients> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clients WHERE state LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Clients produto = new Clients();

                produto.setCpf(rs.getInt("cpf"));
                produto.setName(rs.getString("name"));
                produto.setAddress(rs.getString("address"));
                produto.setComplement(rs.getString("complement"));
                produto.setState(rs.getString("state"));
                produto.setCity(rs.getString("city"));
                produto.setCep(rs.getInt("cep"));
                produto.setFixed_phone(rs.getInt("fixed_phone"));
                produto.setCell_phone(rs.getInt("cell_phone"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
      
      
      public void update(Clients p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE clients SET cep = ? ,city = ?,state = ?,complement = ?,address = ? WHERE cpf = ?");
            stmt.setInt(1, p.getCep());
            stmt.setString(2, p.getCity());
            stmt.setString(3, p.getState());
            stmt.setString(4, p.getComplement());
            stmt.setString(5, p.getAddress());
            stmt.setInt(6, p.getCpf());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Clients p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clients WHERE cpf = ?");
            stmt.setInt(1, p.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void alter(Clients c) throws Exception {
    }

    public void delete(int cpf) throws Exception {
    }

    public ArrayList<Clients> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

    public Clients loadCPF(int cpf) throws Exception {
        //TODO: especificar retorno
        return null;
    }
    
}
