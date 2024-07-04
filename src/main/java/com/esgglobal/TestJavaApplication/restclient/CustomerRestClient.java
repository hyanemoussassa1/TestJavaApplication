package com.esgglobal.TestJavaApplication.restclient;

import com.esgglobal.TestJavaApplication.controller.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CustomerRestClient {
    @Autowired
    RestClient.Builder builder;

    public ResponseEntity<Void> saveCustomer(Customer customer){
        return builder.build()
            .post()
            .uri("http://localhost:8080/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .body(customer)
            .retrieve()
            .toBodilessEntity();
    }
}
