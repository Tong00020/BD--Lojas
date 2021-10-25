/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import model.dao.PrivilegesDAO;

/**
 *
 * @author Tong
 */
public class Privileges {
    private int id;
    private String name;
    private String is_superadm;

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

    public String getIs_superadm() {
        return is_superadm;
    }

    public void setIs_superadm(String is_superadm) {
        this.is_superadm = is_superadm;
    }
    
    public void create() throws Exception {
        PrivilegesDAO pDAO = new PrivilegesDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        PrivilegesDAO pDAO = new PrivilegesDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        PrivilegesDAO pDAO = new PrivilegesDAO();
        pDAO.delete(this.id);
    }

    public ArrayList<Privileges> list() throws Exception {
        PrivilegesDAO pDAO = new PrivilegesDAO();
        return pDAO.list();
    }
    
    public void load() throws Exception {
        PrivilegesDAO pDAO = new PrivilegesDAO();
        this.id = pDAO.loadID(this.id).getId();
        this.name = pDAO.loadID(this.id).getName();
        this.is_superadm = pDAO.loadID(this.id).getIs_superadm();
        
    } 
}
