/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.bean.Privileges;
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

/**
 *
 * @author Vinícius Vasconcelos
 */
public class PrivilegesDAO {

    public void create(Privileges p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO privileges (name,is_superadmin) VALUES (?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setBoolean(2, p.isIs_superadmin());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Privileges p) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE privileges SET name = ?,is_superadmin = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setBoolean(2, p.isIs_superadmin());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Privileges p) {

        Connection con = ConnectionFactory.getConnection();

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

    public List<Privileges> list() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Privileges> privileges = new ArrayList<>();

        try {
            String sql = "SELECT * FROM privileges";
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

                Privileges p = new Privileges();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setIs_superadmin(rs.getBoolean("is_superadmin"));

                privileges.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return privileges;
    }

    public List<Privileges> loadById(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Privileges> privileges = new ArrayList<>();

        try {
            String sql = "SELECT * FROM privileges WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Privileges p = new Privileges();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setIs_superadmin(rs.getBoolean("is_superadmin"));

                privileges.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return privileges;
    }

    /*     public List<Privileges> read() throws SQLException {

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
                produto.setIs_superadmin(rs.getBoolean("is_superadm"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;
    }
   
     public List<Privileges> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Privileges> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM privileges WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Privileges produto = new Privileges();

                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setIs_superadmin(rs.getBoolean("is_superadm"));
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
