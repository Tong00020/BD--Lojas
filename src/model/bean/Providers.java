/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
import model.dao.ProvidersDAO;
import java.util.ArrayList;
/**
 *
 * @author Tong
 */
public class Providers {
    private int id;
    private String name;
    private int cell_phone;
    private int cnpj;
    private int cep;
    private int address_number;
    private String state;
    private String city;
    private String complement;
    private String address;
    private String url_site;

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

    public int getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(int cell_phone) {
        this.cell_phone = cell_phone;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getAddress_number() {
        return address_number;
    }

    public void setAddress_number(int address_number) {
        this.address_number = address_number;
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

    public String getUrl_site() {
        return url_site;
    }

    public void setUrl_site(String url_site) {
        this.url_site = url_site;
    }
            
        public void create() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        pDAO.delete(this.id);
    }

    public ArrayList<Providers> list() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        return pDAO.list();
    }

    public void load() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        this.id = pDAO.loadID(this.id).getId();
        this.name = pDAO.loadID(this.id).getName();
        this.cell_phone = pDAO.loadID(this.id).getCell_phone();
        this.cnpj = pDAO.loadID(this.id).getCnpj();
        this.cep = pDAO.loadID(this.id).getCep();
        this.address_number = pDAO.loadID(this.id).getAddress_number();
        this.state = pDAO.loadID(this.id).getState();
        this.city = pDAO.loadID(this.id).getCity();
        this.complement = pDAO.loadID(this.id).getComplement();
        this.address = pDAO.loadID(this.id).getAddress();
        this.url_site = pDAO.loadID(this.id).getUrl_site();
    }
}
