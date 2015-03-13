package be.telenet.spring4.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by frederik on 11/11/14.
 */
@Entity
@Table(name="customer_property")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CustomerProperty implements Serializable{

    @EmbeddedId CustomerPropertyKey id;

    @Column(insertable = false, updatable = false)
    private Long customerNumber;

    @Column(insertable = false, updatable = false)
    private String property;

    @Column
    private String value;

    public CustomerProperty(){};

    public CustomerProperty(Long customerNumber, String property, String value) {
        this.customerNumber = customerNumber;
        this.property = property;
        this.value = value;
    }

    public CustomerPropertyKey getId() {
        return id;
    }

    public void setId(CustomerPropertyKey id) {
        this.id = id;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
