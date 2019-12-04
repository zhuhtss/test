package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /**
     * http://localhost:8080/hello
     *
     * @return
     */
    @RequestMapping("/hello")
    public String say() {
        return "hello world";
    }
}
