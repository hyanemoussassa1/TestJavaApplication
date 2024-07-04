package com.esgglobal.TestJavaApplication.repository;

import com.esgglobal.TestJavaApplication.dao.Customer;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private CustomerRepository customers;

    @Test
    public void testFindByCustomerRef(){
        Customer customer = getCustomer();
        entityManager.persist(customer);

        Customer findByCustomerRef =
                customers.findByCustomerRef(customer.getCustomerRef());

        assertThat(findByCustomerRef).extracting(Customer::getCustomerName)
                .isEqualTo(customer.getCustomerName());
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustomerRef("REF_001");
        customer.setCustomerName("name");
        customer.setAddressLine1("addr1");
        customer.setAddressLine2("addr2");
        return customer;
    }

}
