package com.esgglobal.customersapp.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CustomerCsvFileReaderTest {

    @InjectMocks
    CustomerCsvFileReader customerCsvFileReader;

    @Test
    void testThatThrowsFileNotFoundWhenFileDoesNotExist(){
        String directoryPath = "src/test/resources";
        String fileName = "customer.csv";
        FileNotFoundException thrown = Assertions.assertThrows(FileNotFoundException.class,
                () -> customerCsvFileReader.parseFile(directoryPath, fileName),
                "Exception is not thrown");
        assertTrue(thrown.getMessage().contains("No such file or directory"));
    }

    @Test
    void testThatMapperReturnsCorrectCustomer() throws IOException {
        String directoryPath = "src/test/resources";
        String fileName = "customers.csv";
        List<Customer> customers = customerCsvFileReader.parseFile(directoryPath, fileName);
        assertEquals(2, customers.size());
        Customer customerFound = customers.get(0);
        assertEquals("REF_001", customerFound.getCustomerRef());
        assertEquals("Hyane Moussassa", customerFound.getCustomerName());
        assertEquals("23 Henry Building", customerFound.getAddressLine1());
        assertEquals("65 Ellesmere Street", customerFound.getAddressLine2());
        assertEquals("Greater Manchester", customerFound.getCounty());
        assertEquals("Manchester", customerFound.getTown());
        assertEquals("United Kingdom", customerFound.getCountry());
        assertEquals("M7 6HN", customerFound.getPostcode());
    }
}
