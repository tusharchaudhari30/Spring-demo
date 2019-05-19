package com.helloworld.demoworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class DemoController
{
    @RequestMapping("/")
    public String homepage()
    {
        return "index.jsp";
    }

}