package be.telenet.spring4.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by frederik on 04/02/15.
 */
@Embeddable
public class CustomerPropertyKey implements Serializable {
    public CustomerPropertyKey(){};
    public CustomerPropertyKey(Long customerNumber, String property) {
        this.property = property;
        this.customerNumber = customerNumber;
    }

    private Long customerNumber;
    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }
}
