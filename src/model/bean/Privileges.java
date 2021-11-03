/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.ArrayList;
import model.dao.PrivilegesDAO;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class Privileges {

    private int id;
    private String name;
    private boolean is_superadmin;

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

    public boolean isIs_superadmin() {
        return is_superadmin;
    }

    public void setIs_superadmin(boolean is_superadmin) {
        this.is_superadmin = is_superadmin;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Privileges && this.id == ((Privileges) obj).getId();
    }

}
