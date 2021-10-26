/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.bean.Providers;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class ProvidersDAO {
   
    public void create(Providers p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO providers (id,name,color,cell_phone,cnpj,address_number,state,city,complement,address,url_site)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getColor());
            stmt.setInt(4, p.getCell_phone());
            stmt.setInt(5, p.getCnpj());
            stmt.setInt(6, p.getCep());
            stmt.setInt(7, p.getAddress_number());
            stmt.setString(8, p.getState());
            stmt.setString(9, p.getCity());
            stmt.setString(10, p.getComplement());
             stmt.setString(11, p.getAddress());
            stmt.setString(12, p.getUrl_site());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     public List<Providers> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Providers> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM providers");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Providers produto = new Providers();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setColor(rs.getString("color"));
                produto.setCell_phone(rs.getInt("cell_phone"));
                produto.setCnpj(rs.getInt("cnpj"));
                produto.setCep(rs.getInt("cep"));
                produto.setAddress_number(rs.getInt("address_number"));
                produto.setState(rs.getString("state"));
                produto.setComplement(rs.getString("complement"));
                produto.setAddress(rs.getString("address"));
                produto.setUrl_site(rs.getString("url_site"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProvidersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;

    }
     
    public List<Providers> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Providers> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM providers WHERE state LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Providers produto = new Providers();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setColor(rs.getString("color"));
                produto.setCell_phone(rs.getInt("cell_phone"));
                produto.setCnpj(rs.getInt("cnpj"));
                produto.setCep(rs.getInt("cep"));
                produto.setAddress_number(rs.getInt("address_number"));
                produto.setState(rs.getString("state"));
                produto.setComplement(rs.getString("complement"));
                produto.setAddress(rs.getString("address"));
                produto.setUrl_site(rs.getString("url_site"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProvidersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Providers p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE providers SET cep = ? ,city = ?,state = ?,complement = ?,address = ? WHERE id = ?");
            stmt.setInt(1, p.getCep());
            stmt.setString(2, p.getCity());
            stmt.setString(3, p.getState());
            stmt.setString(4, p.getComplement());
            stmt.setString(5, p.getAddress());
            stmt.setInt(6, p.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Providers p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM providers WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
   
    public void alter(Providers p) throws Exception {
    }

    public void delete(int id) throws Exception {
    }

    public ArrayList<Providers> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

    public Providers loadID(int id) throws Exception {
        //TODO: especificar retorno
        return null;
    }
}