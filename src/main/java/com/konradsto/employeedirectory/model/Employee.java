package com.konradsto.employeedirectory.model;

public class Employee {

    private int id;
    private String name;
    private String lastName;
    private String email;

    public Employee (){
    }

    public Employee(int id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
