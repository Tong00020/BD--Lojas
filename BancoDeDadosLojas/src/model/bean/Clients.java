/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import dao.ClientsDAO;
import java.util.ArrayList;

/**
 *
 * @author Tong
 */
public class Clients {

    private int cpf;
    private String name;
    private String address;
    private String complement;
    private String state;
    private String city;
    private int cep;
    private int fixed_phone;
    private int cell_phone;
    private String email;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
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

    public void create() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        cDAO.create(this);
    }

    public void alter() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        cDAO.alter(this);
    }

    public void delete() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        cDAO.delete(this.cpf);
    }

    public ArrayList<Clients> list() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        return cDAO.list();
    }

    public void load() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        this.cpf = cDAO.loadCPF(this.cpf).getCpf();
        this.name = cDAO.loadCPF(this.cpf).getName();
        this.address = cDAO.loadCPF(this.cpf).getAddress();
        this.complement = cDAO.loadCPF(this.cpf).getComplement();
        this.state = cDAO.loadCPF(this.cpf).getState();
        this.city = cDAO.loadCPF(this.cpf).getCity();
        this.cep = cDAO.loadCPF(this.cpf).getCep();
        this.fixed_phone = cDAO.loadCPF(this.cpf).getFixed_phone();
        this.cell_phone = cDAO.loadCPF(this.cpf).getCell_phone();
        this.email = cDAO.loadCPF(this.cpf).getEmail();
    }

}
