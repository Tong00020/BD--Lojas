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
import model.bean.BudgetsDetails;
import model.bean.Products;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class BudgetsDetailsDAO {

    public void create(BudgetsDetails bd) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO budget_details (price,amount,subtotal,"
                    + "budget_id,id_product) VALUES (?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, bd.getPrice());
            stmt.setDouble(2, bd.getAmount());
            stmt.setDouble(3, bd.getSubtotal());
            stmt.setInt(4, bd.getBudget().getId());
            stmt.setInt(5, bd.getProduct().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(BudgetsDetails bd) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE budget_details SET price = ?,amount = ?,"
                    + "subtotal = ?,budget_id = ?,id_product = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, bd.getPrice());
            stmt.setDouble(2, bd.getAmount());
            stmt.setDouble(3, bd.getSubtotal());
            stmt.setInt(4, bd.getBudget().getId());
            stmt.setInt(5, bd.getProduct().getId());
            stmt.setInt(6, bd.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(BudgetsDetails p) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM budget_details WHERE id = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<BudgetsDetails> list() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BudgetsDetails> budgetsDetails = new ArrayList<>();

        try {
            String sql = "SELECT * FROM budget_details";
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
                BudgetsDetails bd = new BudgetsDetails();
                bd.setId(rs.getInt("id"));
                bd.setPrice(rs.getDouble("price"));
                bd.setAmount(rs.getDouble("amount"));
                bd.setSubtotal(rs.getDouble("subtotal"));

                Budgets b = new Budgets();
                b.setId(rs.getInt("budget_id"));
                bd.setBudget(b);

                Products p = new Products();
                p.setId(rs.getInt("products_id"));
                bd.setProduct(p);

                budgetsDetails.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BudgetsDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return budgetsDetails;
    }

    public List<BudgetsDetails> loadById(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BudgetsDetails> budgetsDetails = new ArrayList<>();

        try {
            String sql = "SELECT * FROM budget_details WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BudgetsDetails bd = new BudgetsDetails();
                bd.setId(rs.getInt("id"));
                bd.setPrice(rs.getDouble("price"));
                bd.setAmount(rs.getDouble("amount"));
                bd.setSubtotal(rs.getDouble("subtotal"));

                Budgets b = new Budgets();
                b.setId(rs.getInt("budget_id"));
                b.setDate(rs.getDate("date"));
                bd.setBudget(b);

                Products p = new Products();
                p.setId(rs.getInt("products_id"));
                p.setName(rs.getString("name"));
                bd.setProduct(p);

                budgetsDetails.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BudgetsDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return budgetsDetails;
    }

//    public List<BudgetsDetails> read() {
//
//        Connection con = (Connection) ConnectionFactory.getConnection();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<BudgetsDetails> produtos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM budget_details");
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                BudgetsDetails bd = new BudgetsDetails();
//
//                bd.setId(rs.getInt("id"));
//                bd.setPrice(rs.getDouble("price"));
//                bd.setAmount(rs.getDouble("amount"));
//                bd.setSubtotal(rs.getDouble("subtotal"));
//                bd.setBudgetsId(rs.getInt("budget_id"));
//                bd.setProductsId(rs.getInt("id_product"));
//
//                produtos.add(bd);
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//        return produtos;
//
//    }
//
//    public List<BudgetsDetails> readForDesc(String desc) {
//
//        Connection con = (Connection) ConnectionFactory.getConnection();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<BudgetsDetails> produtos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM budget_details WHERE id LIKE ?");
//            stmt.setString(1, "%" + desc + "%");
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                BudgetsDetails bd = new BudgetsDetails();
//
//                bd.setId(rs.getInt("id"));
//                bd.setPrice(rs.getDouble("price"));
//                bd.setAmount(rs.getDouble("amount"));
//                bd.setSubtotal(rs.getDouble("subtotal"));
//                bd.setBudgetsId(rs.getInt("budget_id"));
//                bd.setProductsId(rs.getInt("id_product"));
//                produtos.add(bd);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//
//        return produtos;
//
//    }
}
