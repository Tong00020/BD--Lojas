/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import model.dao.ServicesDAO;

/**
 *
 * @author Tong
 */
public class Services {
    private int id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void create() throws Exception {
        ServicesDAO pDAO = new ServicesDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        ServicesDAO pDAO = new ServicesDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        ServicesDAO pDAO = new ServicesDAO();
        pDAO.delete(this.id);
    }

    public ArrayList<Services> list() throws Exception {
        ServicesDAO pDAO = new ServicesDAO();
        return pDAO.list();
    }
    
    public void load() throws Exception {
        ServicesDAO pDAO = new ServicesDAO();
        this.id = pDAO.loadID(this.id).getId();
        this.name = pDAO.loadID(this.id).getName();
        this.description = pDAO.loadID(this.id).getDescription();
    } 

}
