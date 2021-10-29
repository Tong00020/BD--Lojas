/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Employees;
import connection.ConnectionFactory;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import model.bean.Privileges;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class EmployeesDAO {

    public void create(Employees e) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO employees (name,photo,email,cpf,"
                    + "cell_phone,fixed_phone,cep,address,address_number,"
                    + "complement,city,state,status,login,password,job_title,"
                    + "reports_to,privileges_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getPhoto());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getCpf());
            stmt.setString(5, e.getCell_phone());
            stmt.setString(6, e.getFixed_phone());
            stmt.setString(7, e.getCep());
            stmt.setString(8, e.getAddress());
            stmt.setInt(9, e.getAddress_number());
            stmt.setString(10, e.getComplement());
            stmt.setString(11, e.getCity());
            stmt.setString(12, e.getState());
            stmt.setString(13, e.getStatus());
            stmt.setString(14, e.getLogin());
            stmt.setString(15, e.getPassword());
            stmt.setString(16, e.getJob_title());
            stmt.setInt(17, e.getReports_to().getId());
            stmt.setInt(18, e.getPrivilege().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Employees e) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE employees SET name = ?,photo = ?,email = ?,"
                    + "cpf = ?,cell_phone = ?,fixed_phone = ?,cep = ?,address = ?,"
                    + "address_number = ?,complement = ?,city = ?,state = ?,"
                    + "status = ?,login = ?,password = ?,job_title = ?,"
                    + "reports_to = ?,privileges_id = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getPhoto());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getCpf());
            stmt.setString(5, e.getCell_phone());
            stmt.setString(6, e.getFixed_phone());
            stmt.setString(7, e.getCep());
            stmt.setString(8, e.getAddress());
            stmt.setInt(9, e.getAddress_number());
            stmt.setString(10, e.getComplement());
            stmt.setString(11, e.getCity());
            stmt.setString(12, e.getState());
            stmt.setString(13, e.getStatus());
            stmt.setString(14, e.getLogin());
            stmt.setString(15, e.getPassword());
            stmt.setString(16, e.getJob_title());
            stmt.setInt(17, e.getReports_to().getId());
            stmt.setInt(18, e.getPrivilege().getId());
            stmt.setInt(19, e.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Employees p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM employees WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Employees> list() {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employees> employees = new ArrayList<>();
        try {
            String sql = "SELECT * FROM employees";
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

                Employees employee = new Employees();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPhoto(rs.getString("photo"));
                employee.setEmail(rs.getString("email"));
                employee.setCpf(rs.getString("cpf"));
                employee.setCell_phone(rs.getString("cell_phone"));
                employee.setFixed_phone(rs.getString("fixed_phone"));
                employee.setCep(rs.getString("cep"));
                employee.setAddress(rs.getString("address"));
                employee.setAddress_number(rs.getInt("address_number"));
                employee.setComplement(rs.getString("complement"));
                employee.setCity(rs.getString("city"));
                employee.setState(rs.getString("state"));
                employee.setStatus(rs.getString("status"));
                employee.setLogin(rs.getString("login"));
                employee.setPassword(rs.getString("password"));
                employee.setJob_title(rs.getString("job_title"));

                Employees em = new Employees();
                em.setId(rs.getInt("reports_to"));
                em.setName(rs.getString("name"));
                employee.setReports_to(em);

                Privileges p = new Privileges();
                p.setId(rs.getInt("privileges_id"));
                p.setName(rs.getString("name"));
                employee.setPrivilege(p);

                employees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return employees;
    }

    public List<Employees> loadById(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employees> employees = new ArrayList<>();

        try {
            String sql = "SELECT * FROM employees WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Employees employee = new Employees();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPhoto(rs.getString("photo"));
                employee.setEmail(rs.getString("email"));
                employee.setCpf(rs.getString("cpf"));
                employee.setCell_phone(rs.getString("cell_phone"));
                employee.setFixed_phone(rs.getString("fixed_phone"));
                employee.setCep(rs.getString("cep"));
                employee.setAddress(rs.getString("address"));
                employee.setAddress_number(rs.getInt("address_number"));
                employee.setComplement(rs.getString("complement"));
                employee.setCity(rs.getString("city"));
                employee.setState(rs.getString("state"));
                employee.setStatus(rs.getString("status"));
                employee.setLogin(rs.getString("login"));
                employee.setPassword(rs.getString("password"));
                employee.setJob_title(rs.getString("job_title"));

                Employees em = new Employees();
                em.setId(rs.getInt("reports_to"));
                em.setName(rs.getString("name"));
                employee.setReports_to(em);

                Privileges p = new Privileges();
                p.setId(rs.getInt("privileges_id"));
                p.setName(rs.getString("name"));
                employee.setPrivilege(p);

                employees.add(employee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return employees;
    }

//    public List<Employees> read() {
//
//        Connection con = ConnectionFactory.getConnection();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<Employees> produtos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM employees");
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Employees e = new Employees();
//
//                e.setId(rs.getInt("id"));
//                e.setName(rs.getString("name"));
//                e.setPhoto(rs.getString("photo"));
//                e.setEmail(rs.getString("email"));
//                e.setCpf(rs.getString("cpf"));
//                e.setCell_phone(rs.getString("cell_phone"));
//                e.setFixed_phone(rs.getString("fixed_phone"));
//                e.setCep(rs.getString("cep"));
//                e.setAddress(rs.getString("address"));
//                e.setAddress_number(rs.getInt("address_number"));
//                e.setComplement(rs.getString("complement"));
//                e.setCity(rs.getString("city"));
//                e.setState(rs.getString("state"));
//                e.setStatus(rs.getString("status"));
//                e.setLogin(rs.getString("login"));
//                e.setPassword(rs.getString("password"));
//                e.setJob_title(rs.getString("job_title"));
//                e.setReports_to(rs.getInt("reports_to"));
//                e.setPrivilege(rs.getInt("privileges_id"));
//                produtos.add(e);
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
//    public List<Employees> readForDesc(String desc) {
//
//        Connection con = ConnectionFactory.getConnection();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<Employees> produtos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM employees WHERE id LIKE ?");
//            stmt.setString(1, "%" + desc + "%");
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                Employees e = new Employees();
//
//                e.setId(rs.getInt("id"));
//                e.setName(rs.getString("name"));
//                e.setPhoto(rs.getString("photo"));
//                e.setEmail(rs.getString("email"));
//                e.setCpf(rs.getString("cpf"));
//                e.setCell_phone(rs.getString("cell_phone"));
//                e.setFixed_phone(rs.getString("fixed_phone"));
//                e.setCep(rs.getString("cep"));
//                e.setAddress(rs.getString("address"));
//                e.setAddress_number(rs.getInt("address_number"));
//                e.setComplement(rs.getString("complement"));
//                e.setCity(rs.getString("city"));
//                e.setState(rs.getString("state"));
//                e.setStatus(rs.getString("status"));
//                e.setLogin(rs.getString("login"));
//                e.setPassword(rs.getString("password"));
//                e.setJob_title(rs.getString("job_title"));
//                e.setEmployeesId(rs.getInt("reports_to"));
//                e.setPrivilegesId(rs.getInt("privileges_id"));
//                produtos.add(e);
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
    public boolean checkLogin(String login, String password) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM employees WHERE login = ? and password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
}
