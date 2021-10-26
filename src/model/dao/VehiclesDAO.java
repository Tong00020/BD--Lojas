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
import model.bean.Vehicles;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class VehiclesDAO { 
    public void create(Vehicles p) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO vehicles (id,year,color,km_current,model,plate,clients_id)VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setInt(2, p.getYear());
            stmt.setString(3, p.getColor());
            stmt.setInt(4, p.getKm_current());
            stmt.setString(5, p.getModel());
            stmt.setString(6, p.getPlate());
            stmt.setInt(7, p.getClients_id());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

     public List<Vehicles> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Vehicles> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vehicles");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Vehicles produto = new Vehicles();

                produto.setId(rs.getInt("id"));
                produto.setYear(rs.getInt("year"));
                produto.setColor(rs.getString("color"));
                produto.setKm_current(rs.getInt("km_current"));
                produto.setModel(rs.getString("model"));
                produto.setPlate(rs.getString("plate"));
                produto.setClients_id(rs.getInt("clients_id"));
                produtos.add(produto);
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehiclesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;

    }
    
      public List<Vehicles> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Vehicles> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vehicles WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Vehicles produto = new Vehicles();

                produto.setId(rs.getInt("id"));
                produto.setYear(rs.getInt("year"));
                produto.setColor(rs.getString("color"));
                produto.setKm_current(rs.getInt("km_current"));
                produto.setModel(rs.getString("model"));
                produto.setPlate(rs.getString("plate"));
                produto.setClients_id(rs.getInt("clients_id"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehiclesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Vehicles p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vehicles SET km_current = ? WHERE id = ?");
            stmt.setInt(1, p.getKm_current());
            stmt.setInt(2, p.getId());
            
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Vehicles p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM vehicles WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void alter(Vehicles v) throws Exception {
    }

    public void delete(int id) throws Exception {
    }

    public ArrayList<Vehicles> list() throws Exception {
        //TODO: especificar retorno
        return null;
    }

    public Vehicles loadID(int id) throws Exception {
        //TODO: especificar retorno
        return null;
    }
}