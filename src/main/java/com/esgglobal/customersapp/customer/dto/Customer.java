package com.esgglobal.customersapp.customer.dto;

import java.util.UUID;

public record Customer(
        UUID id,
        String customerRef,
        String customerName,
        String addressLine1,
        String addressLine2,
        String town,
        String county,
        String country,
        String postcode){}
