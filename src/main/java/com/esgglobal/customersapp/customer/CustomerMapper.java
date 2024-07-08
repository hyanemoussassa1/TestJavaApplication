package com.esgglobal.customersapp.customer;

import com.esgglobal.customersapp.customer.dao.Customer;
import com.esgglobal.customersapp.customer.dao.CustomerRecord;

public class CustomerMapper {
    public static Customer convertToEntity(
            com.esgglobal.customersapp.customer.dto.Customer customer) {
        Customer customerEntity = new Customer(customer.customerRef(),
                customer.customerName(),
                customer.addressLine1(),
                customer.addressLine2(),
                customer.town(),
                customer.county(),
                customer.country(),
                customer.postcode()
        );
        return customerEntity;
    }

    public static com.esgglobal.customersapp.customer.dto.Customer map(com.esgglobal.customersapp.utils.Customer input) {
        return new com.esgglobal.customersapp.customer.dto.Customer(
                null,
                input.getCustomerRef(),
                input.getCustomerName(),
                input.getAddressLine1(),
                input.getAddressLine2(),
                input.getTown(),
                input.getCounty(),
                input.getCountry(),
                input.getPostcode()
        );
    }

    public static com.esgglobal.customersapp.customer.dto.Customer map(CustomerRecord input) {
        return new com.esgglobal.customersapp.customer.dto.Customer(
                input.id(),
                input.customerRef(),
                input.customerName(),
                input.addressLine1(),
                input.addressLine2(),
                input.town(),
                input.county(),
                input.country(),
                input.postcode()
        );
    }
}
