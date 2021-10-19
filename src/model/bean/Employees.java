/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
import model.dao.EmployeesDAO;
import java.util.ArrayList;
/**
 *
 * @author Tong
 */
public class Employees {
    private int cpf;
    private String name;
    private int address_number;
    private int fixed_phone;
    private int cell_phone;
    private String email;
    private int cep;
    private String state;
    private String city;
    private String complement;
    private String address;
    private String status;
    private String job_title;

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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
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

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
    
    public void create() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        eDAO.create(this);
    }

    public void alter() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        eDAO.alter(this);
    }

    public void delete() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        eDAO.delete(this.cpf);
    }

    public ArrayList<Employees> list() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        return eDAO.list();
    }

    public void load() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        this.cpf = eDAO.loadCPF(this.cpf).getCpf();
        this.name = eDAO.loadCPF(this.cpf).getName();
        this.address_number = eDAO.loadCPF(this.cpf).getAddress_number();
        this.fixed_phone = eDAO.loadCPF(this.cpf).getFixed_phone();
        this.cell_phone = eDAO.loadCPF(this.cpf).getCell_phone();
        this.email = eDAO.loadCPF(this.cpf).getEmail();
        this.cep = eDAO.loadCPF(this.cpf).getCep();
        this.state = eDAO.loadCPF(this.cpf).getState();
        this.city = eDAO.loadCPF(this.cpf).getCity();
        this.complement = eDAO.loadCPF(this.cpf).getComplement();
        this.address = eDAO.loadCPF(this.cpf).getAddress();
        this.status = eDAO.loadCPF(this.cpf).getStatus();
        this.job_title = eDAO.loadCPF(this.cpf).getJob_title();
    }
    
}
