package com.esgglobal.TestJavaApplication.utils;

import com.esgglobal.TestJavaApplication.mapper.CustomerMapper;
import com.esgglobal.TestJavaApplication.model.Customer;
import com.esgglobal.TestJavaApplication.restclient.CustomerRestClient;
import com.esgglobal.TestJavaApplication.utils.CustomerCsvFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public class CustomerFileHandler {

    CustomerCsvFileReader customerCsvFileReader = new CustomerCsvFileReader();

    CustomerRestClient restClient = new CustomerRestClient();

    public void handle(String directoryPath, String fileName) throws IOException {
        List<Customer> customers = customerCsvFileReader.parseFile(directoryPath, fileName);
        if (!customers.isEmpty()){
            customers.stream()
                    .parallel()
                    .forEach(customer -> {
                        restClient.saveCustomer(CustomerMapper.map(customer));
                    });
        }
    }
}
