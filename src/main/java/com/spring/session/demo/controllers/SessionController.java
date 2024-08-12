package com.spring.session.demo.controllers;

import com.spring.session.demo.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SessionController {


    @RequestMapping(path = "/session", produces = "application/xml")
    public List<User> getSession(HttpSession session) {
//        System.out.println(session);
//        session.setMaxInactiveInterval(10);
        List<User> users = new ArrayList<User>();
        users.add(new User("1", "John Doe", "john.doe@example.com"));
        users.add(new User("2", "Jane Doe", "jane.doe@example.com"));
        return users;
    }
}
