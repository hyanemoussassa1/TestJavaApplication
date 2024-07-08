package com.esgglobal.customersapp.utils;

import com.esgglobal.customersapp.restclient.CustomerRestClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerFileHandlerTests {

    @Mock
    CustomerRestClient customerRestClient;
    @Mock
    CustomerCsvFileReader customerCsvFileReader;
    @InjectMocks
    CustomerFileHandler fileHandler;
    @Test
    void testHandleCallsApiTwice() throws IOException {
        String fileName = "customers.csv";
        String directoryPath = "src/test/resources";
        when(customerCsvFileReader.parseFile(directoryPath, fileName))
                .thenReturn(List.of(CsvRowCustomerProducer.row("REF_001"),
                        CsvRowCustomerProducer.row("REF_002")));
        fileHandler.handle(directoryPath, fileName);
        verify(customerRestClient, times(2))
                .saveCustomer(any());
    }
}
