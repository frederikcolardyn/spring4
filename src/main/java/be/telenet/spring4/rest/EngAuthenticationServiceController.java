package be.telenet.spring4.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by frederik on 25/02/15.
 */
@RestController
@RequestMapping("/services")
public class EngAuthenticationServiceController {

    private String mijntelenet = "http://localhost:8080/mijntelenet/";
//    private String mijntelenet = "http://10.0.2.2:8080/mijntelenet/";

    public static void main (String[] args){
        System.out.println("{\"access_token\":\"c224b532-a0e5-4b80-9ebf-a97388f784c0\",\"token_type\":\"bearer\",\"refresh_token\":\"9e0e22a0-8c03-4499-aad0-96c5206d8fa2\",\"expires_in\":259199,\"scope\":\"tvott\",\"is_telenet_login\":true,\"customer_number\":\"12095694\",\"username\":\"yelo.kijken\",\"is_sub_login\":false,\"client_id\":\"sports_web\"}");
    }

    @RequestMapping("/authentication")
    @ResponseBody
    public String all(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("engineering service req " + request.getRequestURI() + " ? " + request.getQueryString());
        return "";
    }

}
