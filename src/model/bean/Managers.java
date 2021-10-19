/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
import model.dao.ManagersDAO;
import java.util.ArrayList;
/**
 *
 * @author Tong
 */
public class Managers {
    private int cpf;
    private String name;
    private int address_number;
    private int fixed_phone;
    private int cell_phone;
    private String email;
    private String state;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddress_number() {
        return address_number;
    }

    public void setAddress_number(int address_number) {
        this.address_number = address_number;
    }

    public int getFixed_phone() {
        return fixed_phone;
    }

    public void setFixed_phone(int fixed_phone) {
        this.fixed_phone = fixed_phone;
    }

    public int getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(int cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

   public void create() throws Exception {
        ManagersDAO mDAO = new ManagersDAO();
        mDAO.create(this);
    }

    public void alter() throws Exception {
        ManagersDAO mDAO = new ManagersDAO();
        mDAO.alter(this);
    }

    public void delete() throws Exception {
        ManagersDAO mDAO = new ManagersDAO();
        mDAO.delete(this.cpf);
    }

    public ArrayList<Managers> list() throws Exception {
        ManagersDAO mDAO = new ManagersDAO();
        return mDAO.list();
    }

    public void load() throws Exception {
        ManagersDAO mDAO = new ManagersDAO();
        this.cpf = mDAO.loadCPF(this.cpf).getCpf();
        this.name = mDAO.loadCPF(this.cpf).getName();
        this.address_number = mDAO.loadCPF(this.cpf).getAddress_number();
        this.fixed_phone = mDAO.loadCPF(this.cpf).getFixed_phone();
        this.cell_phone = mDAO.loadCPF(this.cpf).getCell_phone();
        this.email = mDAO.loadCPF(this.cpf).getEmail();
        this.state = mDAO.loadCPF(this.cpf).getState();
    }
    
}
