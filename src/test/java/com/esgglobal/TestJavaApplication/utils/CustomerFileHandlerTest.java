package com.esgglobal.TestJavaApplication.utils;

import com.esgglobal.TestJavaApplication.model.Customer;
import com.esgglobal.TestJavaApplication.restclient.CustomerRestClient;
import com.esgglobal.TestJavaApplication.utils.CustomerCsvFileReader;
import com.esgglobal.TestJavaApplication.utils.CustomerFileHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerFileHandlerTest {

    @Mock
    CustomerCsvFileReader fileReader;
    @Mock
    CustomerRestClient saveCustomerToDatabaseFunction;

    @Test
    void testThatCustomerFileContentsAreSentToAPI() throws IOException {
        String directoryPath = "";
        String fileName = "";
        CustomerFileHandler customerFileHandler = new CustomerFileHandler();
        Customer customer = Customer.builder()
                .customerRef("REF_001")
                .customerName("name")
                .build();
        when(fileReader.parseFile(any(), any()))
                .thenReturn(List.of(customer));

        verify(fileReader.parseFile(any(), any()));

        verify(saveCustomerToDatabaseFunction).equals(any());
        customerFileHandler.handle(directoryPath, fileName);
    }
}
