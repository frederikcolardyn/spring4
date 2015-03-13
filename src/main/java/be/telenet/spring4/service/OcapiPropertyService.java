package be.telenet.spring4.service;

import be.telenet.spring4.model.ApiResponse;
import be.telenet.spring4.model.CustomerProperty;
import be.telenet.spring4.model.CustomerPropertyKey;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by frederik on 04/02/15.
 */
@Service
public class OcapiPropertyService {

    private Log log = LogFactory.getLog(this.getClass());

    @PersistenceContext
    private EntityManager em;

    public Serializable readProperty(String id, String p) {
        try {
            Long customerNumber = NumberUtils.createLong(id);
            return em.find(CustomerProperty.class, new CustomerPropertyKey(customerNumber, p));
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("error: " + e.getMessage(), "error");
        }
    }

    public Serializable writeProperty(String id, String p, String value) {
        try {
            Long customerNumber = NumberUtils.createLong(id);
            CustomerProperty customerProperty = em.find(CustomerProperty.class, new CustomerPropertyKey(customerNumber, p));
            if (customerProperty == null){
                customerProperty = new CustomerProperty(customerNumber, p, value);
            }
            em.merge(customerProperty);
            return customerProperty;
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("error: " + e.getMessage(), "error");
        }
    }

    public ApiResponse order(String id, String t) {
        return new ApiResponse("order " + t +" for " + id + " stored", "success");
    }

    public Serializable deleteProperty(String id, String p) {
        try {
            Long customerNumber = NumberUtils.createLong(id);
            CustomerProperty customerProperty = em.find(CustomerProperty.class, new CustomerPropertyKey(customerNumber, p));
            if (customerProperty != null){
                em.remove(customerProperty);
            }
            return new ApiResponse("delete ok", "success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("error: " + e.getMessage(), "error");
        }
    }
}
