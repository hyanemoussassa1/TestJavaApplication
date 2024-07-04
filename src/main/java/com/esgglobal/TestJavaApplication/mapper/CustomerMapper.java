package com.esgglobal.TestJavaApplication.mapper;

import com.esgglobal.TestJavaApplication.dao.Customer;

public class CustomerMapper {
    public static Customer convertToEntity(
            com.esgglobal.TestJavaApplication.controller.Customer customer) {
        Customer customerEntity = new Customer();
        customerEntity.setCustomerRef(customer.customerRef());
        customerEntity.setCustomerName(customer.customerName());
        customerEntity.setAddressLine1(customer.addressLine1());
        customerEntity.setAddressLine2(customer.addressLine2());
        customerEntity.setTown(customer.town());
        customerEntity.setCounty(customer.county());
        customerEntity.setCountry(customer.country());
        return customerEntity;
    }

    public static com.esgglobal.TestJavaApplication.controller.Customer map(com.esgglobal.TestJavaApplication.model.Customer input) {
        return new com.esgglobal.TestJavaApplication.controller.Customer(
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

    public static com.esgglobal.TestJavaApplication.controller.Customer map(Customer input) {
        return new com.esgglobal.TestJavaApplication.controller.Customer(
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
}
