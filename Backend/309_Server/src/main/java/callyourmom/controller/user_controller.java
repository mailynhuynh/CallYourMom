package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import callyourmom.user.user;
import callyourmom.repository.user_repository;

@Controller
@RequestMapping(path = "/userAccount")
public class user_controller {
//
//    @Autowired
//    user_repository userRepository;
//
//    /*
//     * Mapping url exmaple:
//     * http://localhost:8080/userAccount/add?userName=Jerry&password=888888&email=
//     * jerry@dev2qa.com
//     * http://localhost:8080/userAccount/add?userName=Richard&password=888888&email=
//     * richard@google.com
//     */
//    @GetMapping(path = "/add")
//    @ResponseBody
//    public String addUser(@RequestParam int ID, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String userName, @RequestParam int password) {
//
//        user newUser = new user();
//        
//        newUser.setId(ID);
//        newUser.setFirstName(firstName);
//        newUser.setLastName(lastName);
//        newUser.setUserName(userName);
//        newUser.setPassword(password);
//
//        userRepository.save(newUser);
//
//        String ret = "User account for call my mom has been added, user name = " + userName + ", password = " + password ;
//
//        return ret;
//    }

    
}