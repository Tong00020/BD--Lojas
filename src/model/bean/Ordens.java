/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import model.dao.OrdensDAO;

/**
 *
 * @author Tong
 */
public class Ordens {
    private int id;
    private int total;
    private int total_itens;
    private String observation;
    private double price_services;
    private String situation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_itens() {
        return total_itens;
    }

    public void setTotal_itens(int total_itens) {
        this.total_itens = total_itens;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getPrice_services() {
        return price_services;
    }

    public void setPrice_services(double price_services) {
        this.price_services = price_services;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
    
    public void create() throws Exception {
        OrdensDAO pDAO = new OrdensDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        OrdensDAO pDAO = new OrdensDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        OrdensDAO pDAO = new OrdensDAO();
        pDAO.delete(this.id);
    }

    public ArrayList<Ordens> list() throws Exception {
        OrdensDAO pDAO = new OrdensDAO();
        return pDAO.list();
    }
    
    public void load() throws Exception {
        OrdensDAO pDAO = new OrdensDAO();
        this.id = pDAO.loadID(this.id).getId();
        this.total = pDAO.loadID(this.id).getTotal();
        this.total_itens = pDAO.loadID(this.id).getTotal_itens();
        this.observation = pDAO.loadID(this.id).getObservation();
        this.price_services = pDAO.loadID(this.id).getPrice_services();
        this.situation = pDAO.loadID(this.id).getSituation();
    } 
}
