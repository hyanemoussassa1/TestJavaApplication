package com.esgglobal.customersapp.customer;

import com.esgglobal.customersapp.customer.dao.CustomerRecord;

import java.util.UUID;

public class CustomerProducer {
    static CustomerRecord customerRecord(UUID uuid){
        return new CustomerRecord(
                uuid,
                "REF_001",
                "name",
                "line 1",
                "",
                "manchester",
                "GM",
                "UK",
                "postcode");
    }

    static com.esgglobal.customersapp.customer.dto.Customer customerDto(UUID id) {
        return new com.esgglobal.customersapp.customer.dto.Customer(
                id,
                "REF_001",
                "name",
                "line 1",
                "",
                "manchester",
                "GM",
                "UK",
                "postcode"
        );
    }

    static com.esgglobal.customersapp.customer.dao.Customer customerDao(){
        return new com.esgglobal.customersapp.customer.dao.Customer(
                "REF_001",
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
