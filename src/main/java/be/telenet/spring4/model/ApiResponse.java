package be.telenet.spring4.model;

/**
 * Created by frederik on 10/11/14.
 */
public class ApiResponse {
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
