/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
import model.dao.VehiclesDAO;
import java.util.ArrayList;
/**
 *
 * @author Tong
 */
public class Vehicles {
    private int id;
    private int year;
    private String color;
    private int km_current;
    private String model;
    private String plate;
    private int clients_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKm_current() {
        return km_current;
    }

    public void setKm_current(int km_current) {
        this.km_current = km_current;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getClients_id() {
        return clients_id;
    }

    public void setClients_id(int clients_id) {
        this.clients_id = clients_id;
    }
    
    public void create() throws Exception {
        VehiclesDAO vDAO = new VehiclesDAO();
        vDAO.create(this);
    }

    public void alter() throws Exception {
        VehiclesDAO vDAO = new VehiclesDAO();
        vDAO.alter(this);
    }

    public void delete() throws Exception {
        VehiclesDAO vDAO = new VehiclesDAO();
        vDAO.delete(this.id);
    }

    public ArrayList<Vehicles> list() throws Exception {
        VehiclesDAO vDAO = new VehiclesDAO();
        return vDAO.list();
    }

    public void load() throws Exception {
        VehiclesDAO vDAO = new VehiclesDAO();
        this.id = vDAO.loadID(this.id).getId();
        this.year = vDAO.loadID(this.id).getYear();
        this.color = vDAO.loadID(this.id).getColor();
        this.km_current = vDAO.loadID(this.id).getKm_current();
        this.model = vDAO.loadID(this.id).getModel();
        this.plate = vDAO.loadID(this.id).getPlate();
        this.clients_id = vDAO.loadID(this.id).getClients_id();
    }
    
}
