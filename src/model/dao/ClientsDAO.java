/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Clients;

/**
 *
 * @author Tong
 */
public class ClientsDAO {
     public void create(Clients p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO clients (CPF,name,address,complement,state,city,cep,fixed_phone,cell_phone,email)VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getCpf());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getAddress());
            stmt.setString(4, p.getComplement());
            stmt.setString(5, p.getState());
            stmt.setString(6, p.getCity());
            stmt.setInt(7, p.getCep());
            stmt.setInt(8, p.getFixed_phone());
            stmt.setInt(9, p.getCell_phone());
            stmt.setString(10, p.getEmail());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Clients c) throws Exception {
    }

    public void delete(int cpf) throws Exception {
    }

    public ArrayList<Clients> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

    public Clients loadCPF(int cpf) throws Exception {
        //TODO: especificar retorno
        return null;
    }
    
}
