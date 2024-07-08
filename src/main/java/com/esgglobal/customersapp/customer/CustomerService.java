package com.esgglobal.customersapp.customer;

import com.esgglobal.customersapp.customer.dao.Customer;
import com.esgglobal.customersapp.customer.dao.CustomerRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    public void saveCustomer(
            com.esgglobal.customersapp.customer.dto.Customer customer) {
        Customer entity = CustomerMapper.convertToEntity(customer);
        repository.save(entity);
    }

    public com.esgglobal.customersapp.customer.dto.Customer getCustomer(String id) {
        Optional<CustomerRecord> byCustomerRef = repository.findByCustomerRef(id);
        return byCustomerRef.map(CustomerMapper::map).orElseThrow(() ->
                new CustomerNotFoundException("Customer not found of id " + id));
    }
}
