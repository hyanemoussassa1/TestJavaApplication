package com.esgglobal.customersapp.utils;

import com.esgglobal.customersapp.customer.CustomerMapper;
import com.esgglobal.customersapp.restclient.CustomerRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class CustomerFileHandler {

    private static final Logger LOG = Logger.getLogger(CustomerFileHandler.class.getName());

    private final CustomerCsvFileReader customerCsvFileReader;

    private final CustomerRestClient restClient;

    public void handle(String directoryPath, String fileName) throws IOException {
        List<Customer> customers = customerCsvFileReader.parseFile(directoryPath, fileName);
        if (!customers.isEmpty()){
            customers.stream()
                    .parallel()
                    .forEach(customer -> {
                        LOG.info("Calling REST Client for customer " + customer.getCustomerRef());
                        restClient.saveCustomer(CustomerMapper.map(customer));
                    });
        } else {
            LOG.info("File does not contain any customer records");
        }
    }
}
