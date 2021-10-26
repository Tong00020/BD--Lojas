/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.sql.Date;
import java.util.ArrayList;
import model.dao.OrdersDAO;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class Orders {

    private int id;
    private Date date;
    private double discount;
    private Employees employees;
    private Budgets budget;
    private Payments payment;

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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Budgets getBudget() {
        return budget;
    }

    public void setBudget(Budgets budget) {
        this.budget = budget;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    public void create() throws Exception {
        OrdersDAO oDAO = new OrdersDAO();
        oDAO.create(this);
    }

    public void alter() throws Exception {
        OrdersDAO oDAO = new OrdersDAO();
        oDAO.alter(this);
    }

    public void delete() throws Exception {
        OrdersDAO oDAO = new OrdersDAO();
        oDAO.delete(this.id);
    }

    public ArrayList<Orders> list() throws Exception {
        OrdersDAO oDAO = new OrdersDAO();
        return oDAO.list();
    }

    public void load() throws Exception {
        OrdersDAO oDAO = new OrdersDAO();
        this.id = oDAO.loadById(this.id).getId();
        this.date = oDAO.loadById(this.id).getDate();
        this.discount = oDAO.loadById(this.id).getDiscount();
        this.employees = oDAO.loadById(this.id).getEmployees();
        this.budget = oDAO.loadById(this.id).getBudget();
        this.payment = oDAO.loadById(this.id).getPayment();
    }

}
