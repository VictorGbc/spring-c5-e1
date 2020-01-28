package com.endava.springc5e1.controllers;

import com.endava.springc5e1.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
//@RequestMapping("/products")
public class DemoController {

//    @RequestMapping(path = "/hello", method = RequestMethod.GET)

    @GetMapping("/hello/{name1}")
    public String hello(@PathVariable("name1") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/goodbye")
    public String goodbye(@RequestHeader String name) {
        return "Goodbye " + name + " !";
    }

    @GetMapping("/headers")
    public Map<String, String> headers(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/product")
    public Product product(@RequestBody Product p, HttpServletResponse response) {
        response.setHeader("myCustomHeader", "myValue");
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return p;
    }

    @GetMapping("/query")
    public String queryParam(@RequestParam(name = "firstName") String name, double age) {
        return name + " : " + age;
    }

    @GetMapping("/queryAll")
    public Map<String, String> queryParam(@RequestParam Map<String, String> queryParams) {
        return queryParams;
    }

    @GetMapping(value = "/file", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getFile() {
        byte[] data = {1, 0, 0, 1, 1};
        return data;
    }
}
