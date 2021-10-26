/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.ArrayList;
import model.dao.ServicesDAO;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class Services {

    private int id;
    private String name;
    private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void create() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        sDAO.create(this);
    }

    public void alter() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        sDAO.alter(this);
    }

    public void delete() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        sDAO.delete(this.id);
    }

    public ArrayList<Services> list() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        return sDAO.list();
    }

    public void load() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        this.id = sDAO.loadById(this.id).getId();
        this.name = sDAO.loadById(this.id).getName();
        this.price = sDAO.loadById(this.id).getPrice();
    }
}
