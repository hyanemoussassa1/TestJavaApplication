package com.esgglobal.TestJavaApplication.restclient;

import com.esgglobal.TestJavaApplication.controller.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

public class CustomerRestClient {
    RestClient client = RestClient.create();

    //TODO: Don't forget error handling
    public ResponseEntity<Void> saveCustomer(Customer customer){
        return client
            .post()
            .uri("http://localhost:8080/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .body(customer)
            .retrieve()
            .toBodilessEntity();
    }
}
