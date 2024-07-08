package com.esgglobal.customersapp.customer;

import com.esgglobal.customersapp.customer.dto.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository repository;

    @InjectMocks
    CustomerService service;

    @Captor
    ArgumentCaptor<com.esgglobal.customersapp.customer.dao.Customer> daoCatcher;

    @Test
    void testThatCreateCallsRepositorySave(){
        Customer customer = CustomerProducer.customerDto(UUID.randomUUID());
        service.saveCustomer(customer);
        verify(repository).save(daoCatcher.capture());
        assertEquals(daoCatcher.getValue(), daoCatcher.getValue());
    }

    @Test
    void testThatGetCustomerReturnsCustomerFoundByCustomerRef(){
        UUID uuid = UUID.randomUUID();
        when(repository.findByCustomerRef("REF_001"))
                .thenReturn(Optional.of(CustomerProducer.customerRecord(uuid)));
        Customer customer = service.getCustomer("REF_001");
        verify(repository).findByCustomerRef("REF_001");
        assertEquals(CustomerProducer.customerDto(uuid), customer);
    }

    @Test
    void testThatGetCustomerReturnsCustomerNotFound(){
        when(repository.findByCustomerRef("REF_001")).thenReturn(Optional.empty());
        CustomerNotFoundException cnfe = assertThrows(
                CustomerNotFoundException.class,
                () -> service.getCustomer("REF_001"),
                "Customer not found should be thrown"
        );
        verify(repository).findByCustomerRef("REF_001");
        assertThat(cnfe).extracting(CustomerNotFoundException::getMessage)
                        .isEqualTo("Customer not found of id REF_001");
    }

}
