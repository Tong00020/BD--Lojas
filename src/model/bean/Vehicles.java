/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Tong
 */
public class Vehicles {

    private int id;
    private String model;
    private String brand;
    private String plate;
    private int year;
    private Double km_current;
    private String color;
    private String type_fuel;
    private Clients client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getKm_current() {
        return km_current;
    }

    public void setKm_current(Double km_current) {
        this.km_current = km_current;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType_fuel() {
        return type_fuel;
    }

    public void setType_fuel(String type_fuel) {
        this.type_fuel = type_fuel;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public int getClientId() {
        return client.getId();
    }

    public void setClientId(int id) {
        this.client.setId(id);
    }

    @Override
    public String toString() {
        return getPlate();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vehicles && this.id == ((Vehicles) obj).getId();
    }

}
