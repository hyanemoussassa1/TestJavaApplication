package com.esgglobal.TestJavaApplication.utils;

import com.esgglobal.TestJavaApplication.model.Customer;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerCsvFileReader {

    CsvMapper csvMapper = new CsvMapper();

    public List<Customer> parseFile(String directoryPath, String fileName) throws IOException {
        List<Customer> customers = new ArrayList<>();
        CsvSchema customerSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Customer> customerLines = csvMapper.readerFor(Customer.class)
                .with(customerSchema)
                .readValues(new File(directoryPath, fileName));
        while(customerLines.hasNext()){
            customers.add(customerLines.nextValue());
        }
        return customers;
    }
}
