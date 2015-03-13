package be.telenet.spring4.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by frederik on 10/11/14.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ApiResponse implements Serializable{
    protected String code;
    protected String message;

    public ApiResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
