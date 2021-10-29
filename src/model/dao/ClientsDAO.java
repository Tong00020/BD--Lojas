/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Clients;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tong
 */
public class ClientsDAO {

    public void create(Clients c) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO clients (cpf,name,address,address_number,"
                    + "complement,state,city,cep,fixed_phone,cell_phone,email) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getCpf());
            stmt.setString(2, c.getName());
            stmt.setString(3, c.getAddress());
            stmt.setString(4, c.getAddress_number());
            stmt.setString(5, c.getComplement());
            stmt.setString(6, c.getState());
            stmt.setString(7, c.getCity());
            stmt.setString(8, c.getCep());
            stmt.setString(9, c.getFixed_phone());
            stmt.setString(10, c.getCell_phone());
            stmt.setString(11, c.getEmail());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Clients c) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE clients SET cpf=?,name=?,address=?,"
                    + "address_number=?,complement=?,state=?,city=?,cep=?,"
                    + "fixed_phone=?,cell_phone=?,email=? WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getCpf());
            stmt.setString(2, c.getName());
            stmt.setString(3, c.getAddress());
            stmt.setString(4, c.getAddress_number());
            stmt.setString(5, c.getComplement());
            stmt.setString(6, c.getState());
            stmt.setString(7, c.getCity());
            stmt.setString(8, c.getCep());
            stmt.setString(9, c.getFixed_phone());
            stmt.setString(10, c.getCell_phone());
            stmt.setString(11, c.getEmail());
            stmt.setInt(12, c.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Clients p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clients WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Clients> list() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clients> clients = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clients";
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
                Clients c = new Clients();
                c.setId(rs.getInt("id"));
                c.setCpf(rs.getString("cpf"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setAddress_number(rs.getString("address_number"));
                c.setComplement(rs.getString("complement"));
                c.setState(rs.getString("state"));
                c.setCity(rs.getString("city"));
                c.setCep(rs.getString("cep"));
                c.setFixed_phone(rs.getString("fixed_phone"));
                c.setCell_phone(rs.getString("cell_phone"));
                c.setEmail(rs.getString("email"));
                clients.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clients;
    }

    public List<Clients> loadById(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clients> clients = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clients WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Clients c = new Clients();
                c.setId(id);
                c.setCpf(rs.getString("cpf"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setAddress_number(rs.getString("address_number"));
                c.setComplement(rs.getString("complement"));
                c.setState(rs.getString("state"));
                c.setCity(rs.getString("city"));
                c.setCep(rs.getString("cep"));
                c.setFixed_phone(rs.getString("fixed_phone"));
                c.setCell_phone(rs.getString("cell_phone"));
                c.setEmail(rs.getString("email"));
                clients.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clients;
    }

    /*  public List<Clients> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Clients> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clients");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Clients c = new Clients();

                c.setId(rs.getInt("id"));
                c.setCpf(rs.getString("cpf"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setAddress_number(rs.getString("address_number"));
                c.setComplement(rs.getString("complement"));
                c.setState(rs.getString("state"));
                c.setCity(rs.getString("city"));
                c.setCep(rs.getString("cep"));
                c.setFixed_phone(rs.getString("fixed_phone"));
                c.setCell_phone(rs.getString("cell_phone"));
                c.setEmail(rs.getString("email"));
                produtos.add(c);
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }
     
public List<Clients> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Clients> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clients WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Clients c = new Clients();

                c.setId(rs.getInt("id"));
                c.setCpf(rs.getString("cpf"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setAddress_number(rs.getString("address_number"));
                c.setComplement(rs.getString("complement"));
                c.setState(rs.getString("state"));
                c.setCity(rs.getString("city"));
                c.setCep(rs.getString("cep"));
                c.setFixed_phone(rs.getString("fixed_phone"));
                c.setCell_phone(rs.getString("cell_phone"));
                c.setEmail(rs.getString("email"));
                produtos.add(c);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;

    } */
}
