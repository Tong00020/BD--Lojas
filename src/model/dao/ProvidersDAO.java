/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Providers;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class ProvidersDAO {

    public void create(Providers p) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO providers (name,cnpj,cell_phone,fixed_phone,"
                    + "cep,address,address_number,complement,city,state,url_site) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getCell_phone());
            stmt.setString(4, p.getFixed_phone());
            stmt.setString(5, p.getCep());
            stmt.setString(6, p.getAddress());
            stmt.setInt(7, p.getAddress_number());
            stmt.setString(8, p.getComplement());
            stmt.setString(9, p.getCity());
            stmt.setString(10, p.getState());
            stmt.setString(11, p.getUrl_site());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void alter(Providers p) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE providers SET name=?,cnpj=?,cell_phone=?,"
                    + "fixed_phone=?,cep=?,address=?,address_number=?,"
                    + "complement=?,city=?,state=?,url_site=? WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getCell_phone());
            stmt.setString(4, p.getFixed_phone());
            stmt.setString(5, p.getCep());
            stmt.setString(6, p.getAddress());
            stmt.setInt(7, p.getAddress_number());
            stmt.setString(8, p.getComplement());
            stmt.setString(9, p.getCity());
            stmt.setString(10, p.getState());
            stmt.setString(11, p.getUrl_site());
            stmt.setInt(12, p.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Providers p) {

        Connection con = ConnectionFactory.getConnection();

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

    public List<Providers> list() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Providers> providers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM providers";
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Providers p = new Providers();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCnpj(rs.getString("cnpj"));
                p.setCell_phone(rs.getString("cell_phone"));
                p.setFixed_phone(rs.getString("fixed_phone"));
                p.setCep(rs.getString("cep"));
                p.setAddress(rs.getString("address"));
                p.setAddress_number(rs.getInt("address_number"));
                p.setComplement(rs.getString("complement"));
                p.setCity(rs.getString("city"));
                p.setState(rs.getString("state"));
                p.setUrl_site(rs.getString("url_site"));
                providers.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvidersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return providers;
    }

    public List<Providers> loadByName(String name) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Providers> providers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM providers WHERE name LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Providers p = new Providers();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCnpj(rs.getString("cnpj"));
                p.setCell_phone(rs.getString("cell_phone"));
                p.setFixed_phone(rs.getString("fixed_phone"));
                p.setCep(rs.getString("cep"));
                p.setAddress(rs.getString("address"));
                p.setAddress_number(rs.getInt("address_number"));
                p.setComplement(rs.getString("complement"));
                p.setCity(rs.getString("city"));
                p.setState(rs.getString("state"));
                p.setUrl_site(rs.getString("url_site"));
                providers.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvidersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return providers;
    }
    /*  public List<Providers> read()  {

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
                produto.setCell_phone(rs.getString("cell_phone"));
                produto.setCnpj(rs.getString("cnpj"));
                produto.setCep(rs.getString("cep"));
                produto.setAddress_number(rs.getInt("address_number"));
                produto.setState(rs.getString("state"));
                produto.setComplement(rs.getString("complement"));
                produto.setAddress(rs.getString("address"));
                produto.setUrl_site(rs.getString("url_site"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(FProviders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        return produtos;

    }
     
    public List<Providers> readForDesc(String desc)  {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Providers> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM providers WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Providers produto = new Providers();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setCell_phone(rs.getString("cell_phone"));
                produto.setCnpj(rs.getString("cnpj"));
                produto.setCep(rs.getString("cep"));
                produto.setAddress_number(rs.getInt("address_number"));
                produto.setState(rs.getString("state"));
                produto.setComplement(rs.getString("complement"));
                produto.setAddress(rs.getString("address"));
                produto.setUrl_site(rs.getString("url_site"));
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
