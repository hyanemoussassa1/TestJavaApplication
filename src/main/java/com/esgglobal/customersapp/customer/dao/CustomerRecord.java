package com.esgglobal.customersapp.customer.dao;

import java.util.UUID;

public record CustomerRecord(UUID id,
                             String customerRef,
                             String customerName,
                             String addressLine1,
                             String addressLine2,
                             String town,
                             String county,
                             String country,
                             String postcode) { }
