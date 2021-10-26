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
import model.bean.Employees;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class EmployeesDAO {
    public void create(Employees p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
      
        try {
            stmt = con.prepareStatement("INSERT INTO employees (cpf,name,address_number,fixed_phone,cell_phone,email,cep,state,city,complement,address,status,job_title)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getCpf());
            stmt.setString(2, p.getName());
            stmt.setInt(3, p.getAddress_number());
            stmt.setInt(4, p.getFixed_phone());
            stmt.setInt(5, p.getCell_phone());
            stmt.setString(6, p.getEmail());
            stmt.setInt(7, p.getCep());
            stmt.setString(8, p.getState());
            stmt.setString(9, p.getCity());
            stmt.setString(10, p.getComplement());
            stmt.setString(11, p.getAddress());
            stmt.setString(12, p.getStatus());
            stmt.setString(13, p.getJob_title());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<Employees> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Employees> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM employees");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Employees produto = new Employees();

                produto.setCpf(rs.getInt("cpf"));
                produto.setName(rs.getString("name"));
                produto.setAddress_number(rs.getInt("address_number"));
                produto.setFixed_phone(rs.getInt("fixed_phone"));
                produto.setCell_phone(rs.getInt("cell_phone"));
                produto.setEmail(rs.getString("email"));
                produto.setCep(rs.getInt("cep"));
                produto.setState(rs.getString("state"));
                produto.setCity(rs.getString("city"));
                produto.setComplement(rs.getString("complement"));
                produto.setAddress(rs.getString("address"));
                produto.setStatus(rs.getString("status"));
                produto.setJob_title(rs.getString("job_title"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;

    }
    
    public List<Employees> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Employees> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM employees WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Employees produto = new Employees();

                produto.setCpf(rs.getInt("cpf"));
                produto.setName(rs.getString("name"));
                produto.setAddress_number(rs.getInt("address_number"));
                produto.setFixed_phone(rs.getInt("fixed_phone"));
                produto.setCell_phone(rs.getInt("cell_phone"));
                produto.setEmail(rs.getString("email"));
                produto.setCep(rs.getInt("cep"));
                produto.setState(rs.getString("state"));
                produto.setCity(rs.getString("city"));
                produto.setComplement(rs.getString("complement"));
                produto.setAddress(rs.getString("address"));
                produto.setStatus(rs.getString("status"));
                produto.setJob_title(rs.getString("job_title"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Employees p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE employees SET cep = ? ,city = ?,state = ?,complement = ?,address = ? WHERE cpf = ?");
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
    public void delete(Employees p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM employees WHERE cpf = ?");
            stmt.setInt(1, p.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void alter(Employees e) throws Exception {
    }

    public void delete(int cpf) throws Exception {
    }

    public ArrayList<Employees> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

    public Employees loadCPF(int cpf) throws Exception {
        //TODO: especificar retorno
        return null;
    }
}