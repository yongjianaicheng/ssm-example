package com.example.controller;

import com.example.beans.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
public class TestController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    ApplicationContext ioc;

    @RequestMapping("/hello")
    public String hello() {
        Teacher teacher = teacherService.getTeacher(1);
        System.out.println(teacher);
        return "success";
    }
    @RequestMapping("/hello02")
    public String hello02() {
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        return "success";
    }
    @RequestMapping("/hello03")
    public String hello03() {
        WebApplicationContext context=ContextLoader.getCurrentWebApplicationContext();
        System.out.println(context);
        System.out.println("====================================");
        javax.servlet.ServletContext servletContext = context.getServletContext();
        WebApplicationContext context1 = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        System.out.println(context1);
        return "success";
    }

    @RequestMapping("/hello04")
    public String hello04() {
        System.out.println(ioc);
        ApplicationContext parent = ioc.getParent();
        System.out.println("=========================");
        System.out.println(parent);
        return "success";
    }
}
