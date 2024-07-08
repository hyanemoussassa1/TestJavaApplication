package com.esgglobal.customersapp.customer;

import com.esgglobal.customersapp.customer.dao.Customer;
import com.esgglobal.customersapp.customer.dao.CustomerRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Optional<CustomerRecord> findByCustomerRef(String customerRef);
}
