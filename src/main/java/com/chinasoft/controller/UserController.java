package com.chinasoft.controller;

import com.chinasoft.pojo.User;
import com.chinasoft.service.UserMapperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserMapperService service;

    @RequestMapping("/test")
    public void test(){
        System.out.println("test");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(String username, String password, String phone, String address){
        User user = new User(0, username, password, phone,address,null, 3);
        service.addUser(user);
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public ModelAndView selectAll(){
        List<User> list = service.selectAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("hello");
        return mav;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public void deleteUser(int id){
        service.deleteUser(id);
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public void updateUser(int id, String username){
        service.updateUser(id, username);
    }
}
