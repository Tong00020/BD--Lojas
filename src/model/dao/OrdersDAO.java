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
import model.bean.Orders;
import java.sql.ResultSet;
import model.bean.Budgets;
import model.bean.Employees;
import model.bean.Payments;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class OrdersDAO {

    public void create(Orders o) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO orders (date,discount,id_employees,"
                    + "id_budget,id_payment) VALUES (now(),?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, o.getDiscount());
            stmt.setInt(2, o.getEmployees().getId());
            stmt.setInt(3, o.getBudget().getId());
            stmt.setInt(4, o.getPayment().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Orders o) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE orders SET date = now(),discount = ?,"
                    + "id_employees = ?,id_budget = ?,id_payment = ? "
                    + "WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, o.getDiscount());
            stmt.setInt(2, o.getEmployees().getId());
            stmt.setInt(3, o.getBudget().getId());
            stmt.setInt(4, o.getPayment().getId());
            stmt.setInt(5, o.getId());
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
            String sql = "DELETE FROM orders WHERE id=?";
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

    public ArrayList<Orders> list() throws Exception {
        ArrayList<Orders> lista = new ArrayList<Orders>();

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM orders";
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
                Orders o = new Orders();
                o.setId(rs.getInt("id"));
                o.setDate(rs.getDate("date"));
                o.setDiscount(rs.getDouble("discount"));

                Employees e = new Employees();
                e.setId(rs.getInt("id_employees"));
                e.load();
                o.setEmployees(e);

                Budgets b = new Budgets();
                b.setId(rs.getInt("id_budget"));
                b.load();
                o.setBudget(b);

                Payments p = new Payments();
                p.setId(rs.getInt("id_payment"));
                p.load();
                o.setPayment(p);

                lista.add(o);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public Orders loadById(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        Orders o = new Orders();

        try {
            String sql = "SELECT * FROM orders WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                o.setId(rs.getInt("id"));
                o.setDate(rs.getDate("date"));
                o.setDiscount(rs.getDouble("discount"));

                Employees e = new Employees();
                e.setId(rs.getInt("id_employees"));
                e.load();
                o.setEmployees(e);

                Budgets b = new Budgets();
                b.setId(rs.getInt("id_budget"));
                b.load();
                o.setBudget(b);

                Payments p = new Payments();
                p.setId(rs.getInt("id_payment"));
                p.load();
                o.setPayment(p);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return o;
    }
}
