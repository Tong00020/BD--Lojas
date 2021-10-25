/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import model.dao.BudgetDAO;
/**
 *
 * @author Tong
 */
public class Budget {
    private int id;
    private float price;
    private int amount;
    private double subtotal;
    private double budgcol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    

    public double getBudgcol() {
        return budgcol;
    }

    public void setBudgcol(double budgcol) {
        this.budgcol = budgcol;
    }
    
    public void create() throws Exception {
        BudgetDAO pDAO = new BudgetDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        BudgetDAO pDAO = new BudgetDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        BudgetDAO pDAO = new BudgetDAO();
        pDAO.delete(this.id);
    }

    public ArrayList<Budget> list() throws Exception {
        BudgetDAO pDAO = new BudgetDAO();
        return pDAO.list();
    }

    public void load() throws Exception {
        BudgetDAO pDAO = new BudgetDAO();
        this.id = pDAO.loadID(this.id).getId();
        this.price = pDAO.loadID(this.id).getPrice();
        this.amount = pDAO.loadID(this.id).getAmount();
        this.subtotal = pDAO.loadID(this.id).getSubtotal();
        this.budgcol = pDAO.loadID(this.id).getBudgcol();
    }
}
