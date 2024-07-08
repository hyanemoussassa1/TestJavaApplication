package com.esgglobal.customersapp.customer;

import com.esgglobal.customersapp.customer.dao.Customer;
import com.esgglobal.customersapp.customer.dao.CustomerRecord;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private CustomerRepository customers;

    @Test
    public void testFindByCustomerRef(){
        Customer customer = CustomerProducer.customerDao();
        entityManager.persist(customer);

        Optional<CustomerRecord> findByCustomerRef =
                customers.findByCustomerRef(customer.getCustomerRef());

        assertThat(findByCustomerRef.get()).extracting(CustomerRecord::customerName)
                .isEqualTo(customer.getCustomerName());
    }

}
