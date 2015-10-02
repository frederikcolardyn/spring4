package be.telenet.spring4.rest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by frederik on 25/02/15.
 */
@RestController
@RequestMapping("/sso/ext")
public class SsoController {

    private String mijntelenet = "http://localhost:8080/mijntelenet/";

    @RequestMapping("/checkSession.do")
    public void checkSession(@RequestParam(value = "goto", required = false) String goTo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("goTo: " + goTo + " req " + request.getRequestURI() + " ? " + request.getQueryString());

        String domain = StringUtils.substringBefore(goTo, "/mijntelenet");
        System.out.println("domain:  " + domain);

        if (domain!= null){
            response.sendRedirect(domain + "/mijntelenet/session/sso.do?valid=true&event=check&nonce=nonce&goto=" + domain + "/mijntelenet/navigation/navigation.do?family=DEFAULT&identifier=DEFAULT");
        } else {
            response.sendRedirect(mijntelenet + "session/sso.do?valid=true&event=check&nonce=nonce&goto=" + mijntelenet);
        }

    }

    @RequestMapping("/updateSession.do")
    public void updateSession(@RequestParam(value = "goto", required = false) String goTo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("goTo: " + goTo + " req " + request.getRequestURI() + " ? " + request.getQueryString());
        response.sendRedirect(mijntelenet + "session/sso.do?valid=true&event=check&nonce=nonce&goto=" + mijntelenet);
    }

    @RequestMapping({"/logon.do", "signon.do"})
    public void updateSession(HttpServletResponse response) throws IOException {
        response.sendRedirect(mijntelenet + "session/sso.do?valid=true&event=check&nonce=nonce&goto=" + mijntelenet);
    }

    @ResponseBody
    @RequestMapping("/lookupSession.do")
    public String lookupSession(HttpServletRequest request) {
        System.out.println("lookup");
        try {
            String response = IOUtils.toString(new File("src/test/resources/lookupSession.xml").toURI(), "UTF-8");
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/signoff.do")
    public void signoff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getCookies() != null){
            for (Cookie cookie : request.getCookies()) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        response.sendRedirect(mijntelenet +"session/sso.do?valid=true&event=check&nonce=nonce&goto="+mijntelenet);
    }

}
