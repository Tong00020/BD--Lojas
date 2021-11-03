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
import java.util.List;
import model.bean.Budgets;
import model.bean.Clients;
import model.bean.Services;
import model.bean.Vehicles;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class BudgetsDAO {

    public void create(Budgets b) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO budget (date,price_services,total_items,total,vehicles_id,"
                    + "services_id,clients_id) VALUES (now(),?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, b.getPrice_services());
            stmt.setDouble(2, b.getTotal_items());
            stmt.setDouble(3, b.getTotal());
            stmt.setInt(4, b.getVehicle().getId());
            stmt.setInt(5, b.getService().getId());
            stmt.setInt(6, b.getClient().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Budgets b) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE budget SET date = now(),price_services = ?,"
                    + "total_items = ?,total = ?,vehicles_id = ?,services_id = ?,"
                    + "clients_id = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, b.getPrice_services());
            stmt.setDouble(2, b.getTotal_items());
            stmt.setDouble(3, b.getTotal());
            stmt.setInt(4, b.getVehicle().getId());
            stmt.setInt(5, b.getService().getId());
            stmt.setInt(6, b.getClient().getId());
            stmt.setInt(7, b.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Budgets p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM budget WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Budgets> list() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Budgets> budgets = new ArrayList<>();

        try {
            String sql = "SELECT * FROM budget inner join vehicles on "
                    + "budget.vehicles_id = vehicles.id inner join services "
                    + "on budget.services_id = services.id inner join clients "
                    + "on budget.clients_id = clients.id";
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

                Budgets b = new Budgets();
                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));

                Vehicles v = new Vehicles();
                v.setId(rs.getInt("vehicles_id"));
                v.setPlate(rs.getString("plate"));
                v.setBrand(rs.getString("brand"));
                b.setVehicle(v);

                Services s = new Services();
                s.setId(rs.getInt("services_id"));
                s.setName(rs.getString("name"));
                b.setService(s);

                Clients c = new Clients();
                c.setId(rs.getInt("clients_id"));
                c.setName(rs.getString("clients.name"));
                c.setCpf(rs.getString("cpf"));
                b.setClient(c);

                budgets.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BudgetsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return budgets;
    }

    public List<Budgets> loadByDate(String date) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Budgets> budgets = new ArrayList<>();

        try {
            String sql = "SELECT * FROM budget inner join vehicles on "
                    + "budget.vehicles_id = vehicles.id inner join "
                    + "services on budget.services_id = services.id "
                    + "inner join clients on budget.clients_id = clients.id "
                    + "WHERE budget.date LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + date + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Budgets b = new Budgets();
                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));

                Vehicles v = new Vehicles();
                v.setId(rs.getInt("vehicles_id"));
                v.setPlate(rs.getString("plate"));
                v.setBrand(rs.getString("brand"));
                b.setVehicle(v);

                Services s = new Services();
                s.setId(rs.getInt("services_id"));
                s.setName(rs.getString("name"));
                b.setService(s);

                Clients c = new Clients();
                c.setId(rs.getInt("clients_id"));
                c.setName(rs.getString("clients.name"));
                c.setCpf(rs.getString("cpf"));
                b.setClient(c);

                budgets.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BudgetsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return budgets;
    }

    /*  public List<Budgets> read()  {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Budgets> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budget");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Budgets b = new Budgets();

                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));
                b.setVehiclesId(rs.getInt("vehicles_id"));
                b.setClientsId(rs.getInt("clients_id"));
                b.setServicesId(rs.getInt("services_id"));
                produtos.add(b);
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }
    
    public List<Budgets> readForDesc(String desc)  {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Budgets> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budget WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Budgets b = new Budgets();

                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));
                b.setVehiclesId(rs.getInt("vehicles_id"));
                b.setClientsId(rs.getInt("clients_id"));
                b.setServicesId(rs.getInt("services_id"));
                produtos.add(b);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;

    } */
}
