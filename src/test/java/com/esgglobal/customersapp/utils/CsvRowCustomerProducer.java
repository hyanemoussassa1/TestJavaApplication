package com.esgglobal.customersapp.utils;

public class CsvRowCustomerProducer {

    static Customer row(String refId){
        return new Customer(
                refId,
                "name",
                "line 1",
                "",
                "manchester",
                "GM",
                "UK",
                "postcode"
        );
    }
}
