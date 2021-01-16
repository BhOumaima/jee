package org.sid.billingservice.model;

import lombok.Data;

@Data
public class Product {
    private String name;
    private Long id;
    private double quantity;
    private double price;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity( double quantity ) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }
}

