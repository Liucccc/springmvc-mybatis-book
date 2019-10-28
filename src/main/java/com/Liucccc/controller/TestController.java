package com.Liucccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestController
 *
 * @author liuchao
 * @date 2019-10-28 17:27
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/ hello")
    public String hello(){
        return "hello";
    }
}
