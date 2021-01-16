package org.sid.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.model.Customer;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private Long customerID;
    @Transient
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate( Date billingDate ) {
        this.billingDate = billingDate;
    }

    public Collection<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems( Collection<ProductItem> productItems ) {
        this.productItems = productItems;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID( Long customerID ) {
        this.customerID = customerID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer( Customer customer ) {
        this.customer = customer;
    }
}
