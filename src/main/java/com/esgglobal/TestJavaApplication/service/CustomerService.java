package com.esgglobal.TestJavaApplication.service;

import com.esgglobal.TestJavaApplication.dao.Customer;
import com.esgglobal.TestJavaApplication.mapper.CustomerMapper;
import com.esgglobal.TestJavaApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public void saveCustomer(
            com.esgglobal.TestJavaApplication.controller.Customer customer) {
        Customer entity = CustomerMapper.convertToEntity(customer);
        repository.save(entity);
    }

    public com.esgglobal.TestJavaApplication.controller.Customer getCustomer(String id) {
        Optional<Customer> byCustomerRef = repository.findByCustomerRef(id);
        if (byCustomerRef.isPresent()){
            return CustomerMapper.map(byCustomerRef.get());
        }
        return null;
    }
}
