package com.spring.session.demo.controllers;

import com.spring.session.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SessionController {


    @RequestMapping(path = "/session", produces = "application/xml")
    public List<User> getSession() {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "John Doe", "john.doe@example.com"));
        users.add(new User("2", "Jane Doe", "jane.doe@example.com"));
        return users;
    }

    @RequestMapping(path = "/hostname")
    public String getHostName() throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostName();
        return host;
    }
}
