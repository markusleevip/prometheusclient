package com.markus.demo.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAction {


    @RequestMapping("/")
    public String index(){
        return "Hello 世界";
    }

}
