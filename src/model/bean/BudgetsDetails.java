/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.ArrayList;
import model.dao.BudgetsDetailsDAO;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class BudgetsDetails {

    private int id;
    private double price;
    private double amount;
    private double subtotal;
    private Budgets budget;
    private Products product;

    public int getBudgetsId() {
        return budget.getId();
    }

    public void setBudgetsId(int id) {
        this.budget.setId(id);
    }

    public int getProductsId() {
        return product.getId();
    }

    public void setProductsId(int id) {
        this.product.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Budgets getBudget() {
        return budget;
    }

    public void setBudget(Budgets budget) {
        this.budget = budget;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
