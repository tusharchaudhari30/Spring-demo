package com.helloworld.demoworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class DemoController
{
    @RequestMapping("/")
    public String homepage()
    {
        return "index.jsp";
    }
    @RequestMapping("/loginr")
    public String login()
    {
        return"login.jsp";
    }

}