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
    private String description;
    private Date date;
    private Vehicles vehicle;
    private Products product;
    private Clients client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public void create() throws Exception {
        BudgetsDAO bDAO = new BudgetsDAO();
        bDAO.create(this);
    }

    public void alter() throws Exception {
        BudgetsDAO bDAO = new BudgetsDAO();
        bDAO.alter(this);
    }

    public void delete() throws Exception {
        BudgetsDAO bDAO = new BudgetsDAO();
        bDAO.delete(this.id);
    }

    public ArrayList<Budgets> list() throws Exception {
        BudgetsDAO bDAO = new BudgetsDAO();
        return bDAO.list();
    }

    public void load() throws Exception {
        BudgetsDAO bDAO = new BudgetsDAO();
        this.id = bDAO.loadById(this.id).getId();
        this.description = bDAO.loadById(this.id).getDescription();
        this.date = bDAO.loadById(this.id).getDate();
        this.vehicle = bDAO.loadById(this.id).getVehicle();
        this.product = bDAO.loadById(this.id).getProduct();
        this.client = bDAO.loadById(this.id).getClient();
    }

}
