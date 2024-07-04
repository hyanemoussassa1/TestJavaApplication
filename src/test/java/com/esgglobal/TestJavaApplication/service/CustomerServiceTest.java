package com.esgglobal.TestJavaApplication.service;

import com.esgglobal.TestJavaApplication.controller.Customer;
import com.esgglobal.TestJavaApplication.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    CustomerRepository repository;

    @InjectMocks
    CustomerService service;

    @Test
    void testThatCreateCallsRepositorySave(){
        Customer customer = createCustomer();
        service.saveCustomer(customer);
        Mockito.verify(repository).save(
                isA(com.esgglobal.TestJavaApplication.dao.Customer.class));
    }

    private Customer createCustomer() {
        return new Customer(
                "REF_001",
                "name",
                "line 1",
                "",
                "manchester",
                "GM",
                "UK",
                "postcode"
        );
    }

}
