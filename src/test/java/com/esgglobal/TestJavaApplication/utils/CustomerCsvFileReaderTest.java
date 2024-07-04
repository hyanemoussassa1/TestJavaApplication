package com.esgglobal.TestJavaApplication.utils;

import com.esgglobal.TestJavaApplication.model.Customer;
import com.esgglobal.TestJavaApplication.utils.CustomerCsvFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerCsvFileReaderTest {

    @Test
    void testThatThrowsFileNotFoundWhenFileDoesNotExist(){
        CustomerCsvFileReader customerCsvFileReader = new CustomerCsvFileReader();
        String directoryPath = "src/test/resources";
        String fileName = "customer.csv";
        FileNotFoundException thrown = Assertions.assertThrows(FileNotFoundException.class,
                () -> customerCsvFileReader.parseFile(directoryPath, fileName),
                "Exception is not thrown");
        assertTrue(thrown.getMessage().contains("No such file or directory"));
    }

    @Test
    void testThatMapperReturnsCorrectCustomer() throws IOException {
        CustomerCsvFileReader customerCsvFileReader = new CustomerCsvFileReader();
        String directoryPath = "src/test/resources";
        String fileName = "customers.csv";
        List<Customer> customers = customerCsvFileReader.parseFile(directoryPath, fileName);
        assertEquals(1, customers.size());
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
