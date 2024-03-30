package com.example.springcrud;

import jakarta.persistence.*;

//Entity class for data managing
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//changed
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    // Constructors, getters and setters, and other methods...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //no argument constructor
    public Product() {
    }

    //parameterized constructor
    public Product( String name, double price, int quantity) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
