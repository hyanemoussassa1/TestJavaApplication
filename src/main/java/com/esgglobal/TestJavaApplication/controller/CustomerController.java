package com.esgglobal.TestJavaApplication.controller;

import com.esgglobal.TestJavaApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer){
        
        service.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public @ResponseBody Customer getCustomer(@PathVariable String id){
        return service.getCustomer(id);
    }

}
