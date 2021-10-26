/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import model.bean.Budgets;
import model.bean.Clients;
import model.bean.Products;
import model.bean.Vehicles;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class BudgetsDAO {

    public void create(Budgets b) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO budgets (date,description,id_vehicle,"
                    + "id_product,id_client) VALUES (now(),?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, b.getDescription());
            stmt.setInt(2, b.getVehicle().getId());
            stmt.setInt(3, b.getProduct().getId());
            stmt.setInt(4, b.getClient().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Budgets b) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE budgets SET date = now(),description = ?,"
                    + "id_vehicle = ?,id_product = ?,id_client = ? "
                    + "WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, b.getDescription());
            stmt.setInt(2, b.getVehicle().getId());
            stmt.setInt(3, b.getProduct().getId());
            stmt.setInt(4, b.getClient().getId());
            stmt.setInt(5, b.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM budgets WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Budgets> list() throws Exception {
        ArrayList<Budgets> lista = new ArrayList<Budgets>();

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM budgets";
            stmt = con.prepareStatement(sql);
            /*
            ResultSet é uma interface utilizada pra guardar dados vindos 
            de um banco de dados.
            
            Basicamente, ela guarda o resultado de uma pesquisa numa estrutura 
            de dados que pode ser percorrida, de forma que você possa ler os 
            dados do banco.
             */
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Budgets b = new Budgets();
                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setDescription(rs.getString("description"));

                Vehicles v = new Vehicles();
                v.setId(rs.getInt("id_vehicle"));
                v.load();
                b.setVehicle(v);

                Products p = new Products();
                p.setId(rs.getInt("id_product"));
                p.load();
                b.setProduct(p);

                Clients c = new Clients();
                c.setId(rs.getInt("id_client"));
                c.load();
                b.setClient(c);

                lista.add(b);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public Budgets loadById(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        Budgets b = new Budgets();

        try {
            String sql = "SELECT * FROM orders WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setDescription(rs.getString("description"));

                Vehicles v = new Vehicles();
                v.setId(rs.getInt("id_vehicle"));
                v.load();
                b.setVehicle(v);

                Products p = new Products();
                p.setId(rs.getInt("id_product"));
                p.load();
                b.setProduct(p);

                Clients c = new Clients();
                c.setId(rs.getInt("id_client"));
                c.load();
                b.setClient(c);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return b;
    }
}
