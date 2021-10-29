/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.sql.Date;
import java.util.ArrayList;
import model.dao.BudgetsDAO;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class Budgets {

    private int id;
    private Date date;
    private double price_services;
    private double total_items;
    private double total;
    private Vehicles vehicle;
    private Clients client;
    private Services service;

    public int getVehiclesId() {
        return vehicle.getId();
    }

    public void setVehiclesId(int id) {
        this.vehicle.setId(id);
    }

    public int getClientsId() {
        return client.getId();
    }

    public void setClientsId(int id) {
        this.client.setId(id);
    }

    public int getServicesId() {
        return service.getId();
    }

    public void setServicesId(int id) {
        this.service.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice_services() {
        return price_services;
    }

    public void setPrice_services(double price_services) {
        this.price_services = price_services;
    }

    public double getTotal_items() {
        return total_items;
    }

    public void setTotal_items(double total_items) {
        this.total_items = total_items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

}
