package be.telenet.spring4.rest;

import be.telenet.spring4.model.ApiResponse;
import be.telenet.spring4.model.User;
import be.telenet.spring4.service.UptimeService;
import be.telenet.spring4.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by frederik on 10/11/14.
 */
@RestController
public class ApiRestController {

    @Resource
    private UptimeService uptimeService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/uptime")
    public ApiResponse uptime(){
        return uptimeService.uptime();
    }

    @RequestMapping(value = "/user/{id}")
    public User user(@PathVariable Long id){
        return userService.loadUser(id);
    }

    @RequestMapping(value = "/user/{id}/delete")
    public String userDelete(@PathVariable Long id){
        userService.deleteUser(id);
        return "deleted";
    }

    @RequestMapping(value = "/user/all")
    public List<User> users(){
        return userService.loadUsers();
    }

    @RequestMapping(value = "/user/add")
    public String user(@RequestParam String name){
        userService.saveUser(new User(name));
        return "added";
    }

    @RequestMapping(value = "/cache/clear/user")
    public String clearCacheUser(){
        userService.clearCache();
        return "ok";
    }

}
