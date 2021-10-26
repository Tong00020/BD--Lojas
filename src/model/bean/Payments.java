/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.ArrayList;
import model.dao.PaymentsDAO;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class Payments {

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
        PaymentsDAO pDAO = new PaymentsDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        PaymentsDAO pDAO = new PaymentsDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        PaymentsDAO pDAO = new PaymentsDAO();
        pDAO.delete(this.id);
    }

    public ArrayList<Payments> list() throws Exception {
        PaymentsDAO pDAO = new PaymentsDAO();
        return pDAO.list();
    }

    public void load() throws Exception {
        PaymentsDAO pDAO = new PaymentsDAO();
        this.id = pDAO.loadById(this.id).getId();
        this.name = pDAO.loadById(this.id).getName();
        this.description = pDAO.loadById(this.id).getDescription();
    }
}
