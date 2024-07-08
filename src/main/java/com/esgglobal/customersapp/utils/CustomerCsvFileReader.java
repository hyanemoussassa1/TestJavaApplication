package com.esgglobal.customersapp.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class CustomerCsvFileReader {
    private static final Logger LOG = Logger.getLogger(CustomerCsvFileReader.class.getName());
    CsvMapper csvMapper = CsvMapper.builder().build();
    public List<Customer> parseFile(String directoryPath, String fileName) throws IOException {
        List<Customer> customers = new ArrayList<>();
        CsvSchema customerSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Customer> customerLines = csvMapper.readerFor(Customer.class)
                .with(customerSchema)
                .readValues(new File(directoryPath, fileName));
        while(customerLines.hasNext()){
            LOG.info("Found a customer line");
            customers.add(customerLines.nextValue());
        }
        return customers;
    }
}
