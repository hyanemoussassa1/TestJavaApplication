package com.esgglobal.TestJavaApplication.repository;

import com.esgglobal.TestJavaApplication.dao.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByCustomerRef(String customerRef);
}
