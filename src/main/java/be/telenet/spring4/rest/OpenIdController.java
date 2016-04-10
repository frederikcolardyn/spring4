package be.telenet.spring4.rest;

import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/openid")
public class OpenIdController {

    private String mijntelenet = "http://localhost:8080/mijntelenet/";
//    private String mijntelenet = "http://10.0.2.2:8080/mijntelenet/";

    public static void main (String[] args){
        System.out.println("{\"access_token\":\"c224b532-a0e5-4b80-9ebf-a97388f784c0\",\"token_type\":\"bearer\",\"refresh_token\":\"9e0e22a0-8c03-4499-aad0-96c5206d8fa2\",\"expires_in\":259199,\"scope\":\"tvott\",\"is_telenet_login\":true,\"customer_number\":\"14348522\",\"username\":\"yelo.kijken\",\"is_sub_login\":false,\"client_id\":\"sports_web\"}");
    }

    @RequestMapping("/**")
    @ResponseBody
    public String all(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String queryString = request.getQueryString();
        String uri = request.getRequestURI();

        System.out.println("openid req " + uri + " ? " + queryString);

        if (queryString != null && !queryString.contains("response_type")){
            return "{\"access_token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Im1pam50ZWxlbmV0XzA0MTQxNi0xMDA0MjAxNiJ9.eyJodHRwOi8vdGVsZW5ldC5iZS9jbGFpbXMvY3VzdG9tZXJfbnVtYmVyIjoiODI0MzE4NzMwIiwic2NvcGUiOiJjdXN0b21lcnNlZ21lbnRzIG9wZW5pZCIsInNhbHQiOiIzNjQxNTVkMy1hZDkzLTQ5MmEtYTU0Ny05MjE5MWUwYWJjZTkiLCJleHAiOjE0NjAyODA3NTJ9.amdvEocuQeD4tzefPdv4BtWAA0kINn8OJ-kcks_NxjJ4NAC1j158sc0jU_e70Ty2xgx8VfeFbjluXKaedv_MwlrD3HJoWZ-zXDIi9_pJCcJclJUay4bDEeoXjlEMSvBMEPDZAjmdDD4AaM05w-uNQ4ayScfFmHmd7PNluOMiaitgSn1DmWSW6LhlxfsmmV1LTgAClPtXwipoVPgwsWvuSBGEqeKgnjXRXIDEbngWL8jzGgiHL3itSCf81fFSE0esknbFJTe1AozY_kX-KmVMxXYZvYDduwzhs98vt4Fzhxg5iic78yfZExKat4R6ydsV3rSHnUsyP9uQ8ooJNOwcLA\",\"token_type\":\"bearer\",\"refresh_token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Im1pam50ZWxlbmV0XzA0MTQxNi0xMDA0MjAxNiJ9.eyJ0IjoiMmQ2ODBiZGItMmJiYS00YmY0LTkxYjgtMzAxMzMzNTZiMjM2IiwiZSI6ImVlNWMzODEyLWU2ODEtNDQ4YS04ODc0LTc3OTY2MjgyNWZlNCJ9.Avtz9Bb6VyYwJ2sMhHBzSvqrbx3c7IjOTmBPuzGwEp8Pz5-5rTj5OxWYDdGdoFUVLrgPAW1C-qlVB3LLBRY227fphFQwekNdCnwggeey6zwBVZ0SEp-6wFfHNscbawpCWbMZ5c12mtk-a7nN8FBAnwl0ufsznHZHp7JsEBLerak9fzssRribPhXjs0Z_OoqlpwxeSbYx0UZ8e4TuCrv6GHfsgI0LE_NDV-igtWGc0vfkLd3tmOQNDhw8I7Bqeid-sYyML38BSjjQhB7O5lR93fCGlRpzGBcA4nPlofhv_92mtOK6bYHgyPcmbM2PIat_1cO8Y4LdNGTHt5oZv2eLOw\",\"expires_in\":1799,\"scope\":\"customersegments openid\",\"id_token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Im1pam50ZWxlbmV0XzA0MTQxNi0xMDA0MjAxNiJ9.eyJpc3MiOiJodHRwczovL2xvZ2luLnByZC50ZWxlbmV0LmJlL29wZW5pZCIsImlhdCI6MTQ2MDI3ODk1MiwiYXVkIjoibWlqbnRlbGVuZXQiLCJzdWIiOiIxZDdjNDJhOS0zNmU2LTQzZjQtOTc0MS05MzA5NmQzOWQwMzYiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZDUxMzE1IiwiaHR0cDovL3RlbGVuZXQuYmUvY2xhaW1zL2N1c3RvbWVyX251bWJlciI6IjgyNDMxODczMCIsImdpdmVuX25hbWUiOiJQUk9EU0FOMzg5IiwiZmFtaWx5X25hbWUiOiJUZXN0IiwiZXhwIjoxNDYwMjgwNzUyLCJhdXRoX3RpbWUiOjE0NjAyNzg5NTIsIm5vbmNlIjoiYzJmZGRhNjItNTdjNS00NjFkLWE2MWQtMzJmODYzYjg4YTk2IiwiaHR0cDovL3RlbGVuZXQuYmUvY2xhaW1zL3JvbGVzIjpbeyJuYW1lIjoiQ3VzdG9tZXJfVXNlciIsInJlZmVyZW5jZXMiOlt7Im5hbWUiOiJDdXN0b21lcl9OdW1iZXIiLCJ2YWx1ZSI6IjgyNDMxODczMCIsImRvbWFpbiI6Ik9BU0lTIiwiZW50aXR5IjoiQ3VzdG9tZXIifV19LHsibmFtZSI6IkludGVybmV0X01hc3RlciIsInJlZmVyZW5jZXMiOlt7Im5hbWUiOiJCdXNpbmVzc19JZGVudGlmaWVyIiwidmFsdWUiOiJhZDUxMzE1IiwiZG9tYWluIjoiT0FTSVMiLCJlbnRpdHkiOiJQcm9kdWN0In1dfV0sImVtYWlsIjoicHJvZHNhbjM4OS50ZXN0QHRlbGVuZXQuYmUifQ.XFKMxZRj5NCB-9PR8H9P1YGFec_BxCPJ81v3WiVlPt44cU5X959S5zcc0OkyidWkqX-jgae7SlNmdZ7DJCwgPee7GZ8nmrGBtixCsTYX4OEMdWeaswOmJscNiPJK7T0BrcimPbqZCU-tgpee4xtV5wiz_XW-c8zcsxQZgzi4FEo2-B-3t9yP-3zFjTY536dh51xKtwxNJ9JFbSKHeTslrdqQVxst2qYDJyI9QsY8cQdxPjXG_ePIPGLv4EtPQDrgbUCBC7027UEMo-ph9CAaVYs_7gNN-L380UDr-dvISu1z55tT1ZCVmLLS3H9HvhXNT2ZrOd-skiOxaNbjM2MJpw\"}";
        } else {
            response.sendRedirect(mijntelenet + "oauth/callback.do?state=foo&code=bar");
            return "ok";
        }
    }

    @ResponseBody
    @RequestMapping("/rest/token/validateToken")
    public String lookupSession(HttpServletRequest request) {
        System.out.println("token oauth2 req " + request.getRequestURI() + " ? " + request.getQueryString());
        return "VALID";
    }

    @ResponseBody
    @RequestMapping("/rest/token/validate/{customer}")
    public String lookupSessionCustomer(HttpServletRequest request, @PathVariable String customer) {
        System.out.println("token validation " + customer);
        return "VALID";
    }

}
