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
import java.util.List;
import model.bean.Budgets;
import model.bean.Employees;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class OrdersDAO {

    public void create(Orders o) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO orders (date,discount,observation,payment,"
                    + "situation,id_employees,id_budget) "
                    + "VALUES (now(),?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, o.getDiscount());
            stmt.setString(2, o.getObservation());
            stmt.setString(3, o.getPayment());
            stmt.setString(4, o.getSituation());
            stmt.setInt(5, o.getEmployees().getId());
            stmt.setInt(6, o.getBudget().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Orders o) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE orders SET date = now(),discount = ?,"
                    + "observation = ?,payment = ?,situation = ?,"
                    + "id_employees = ?,id_budget = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, o.getDiscount());
            stmt.setString(2, o.getObservation());
            stmt.setString(3, o.getPayment());
            stmt.setString(4, o.getSituation());
            stmt.setInt(5, o.getEmployees().getId());
            stmt.setInt(6, o.getBudget().getId());
            stmt.setInt(7, o.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Orders p) {

        Connection con = ConnectionFactory.getConnection();

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

    public List<Orders> list() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Orders> orders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM loja.orders inner join employees on orders.employees_id = employees.id inner join budget on orders.budget_id = budget.id";
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
                Orders o = new Orders();
                o.setId(rs.getInt("id"));
                o.setDate(rs.getDate("date"));
                o.setDiscount(rs.getDouble("discount"));
                o.setObservation(rs.getString("observation"));
                o.setPayment(rs.getString("payment"));
                o.setSituation(rs.getString("situation"));

                Employees e = new Employees();
                e.setId(rs.getInt("id_employees"));
                e.setName(rs.getString("employees.name"));
                o.setEmployees(e);

                Budgets b = new Budgets();
                b.setId(rs.getInt("id_budget"));
                b.setDate(rs.getDate("budget.date"));
                o.setBudget(b);

                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return orders;
    }

    public List<Orders> loadById(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Orders> orders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM loja.orders inner join employees on orders.employees_id = employees.id inner join budget on orders.budget_id = budget.id WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setId(rs.getInt("id"));
                o.setDate(rs.getDate("date"));
                o.setDiscount(rs.getDouble("discount"));
                o.setObservation(rs.getString("observation"));
                o.setPayment(rs.getString("payment"));
                o.setSituation(rs.getString("situation"));

                Employees e = new Employees();
                e.setId(rs.getInt("id_employees"));
                e.setName(rs.getString("employees.name"));
                o.setEmployees(e);

                Budgets b = new Budgets();
                b.setId(rs.getInt("id_budget"));
                b.setDate(rs.getDate("budget.date"));
                o.setBudget(b);

                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return orders;
    }

    /*      public List<Orders> read()  {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Orders> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ordens");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Orders o = new Orders();

                o.setId(rs.getInt("id"));
                o.setDate(rs.getDate("date"));
                o.setDiscount(rs.getDouble("discount"));
                o.setObservation(rs.getString("observation"));
                o.setPayment(rs.getString("payment"));
                o.setSituation(rs.getString("situation"));
                o.setEmployeesId(rs.getInt("id_employees"));
                o.setBudgetsId(rs.getInt("id_budget"));
                produtos.add(o);
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }
     
     public List<Orders> readForDesc(String desc)  {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Orders> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ordens WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Orders o = new Orders();

                o.setId(rs.getInt("id"));
                o.setDate(rs.getDate("date"));
                o.setDiscount(rs.getDouble("discount"));
                o.setObservation(rs.getString("observation"));
                o.setPayment(rs.getString("payment"));
                o.setSituation(rs.getString("situation"));
                o.setEmployeesId(rs.getInt("id_employees"));
                o.setBudgetsId(rs.getInt("id_budget"));
                produtos.add(o);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;

    } */
}
