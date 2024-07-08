package com.esgglobal.customersapp.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    @JsonProperty("Customer Ref")
    private String customerRef;
    @JsonProperty("Customer Name")
    private String customerName;
    @JsonProperty("Address Line 1")
    private String addressLine1;
    @JsonProperty("Address Line 2")
    private String addressLine2;
    @JsonProperty("Town")
    private String town;
    @JsonProperty("County")
    private String county;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Postcode")
    private String postcode;

    public Customer() {
    }

    public Customer(String customerRef, String customerName, String addressLine1, String addressLine2, String town, String county, String country, String postcode) {
        this.customerRef = customerRef;
        this.customerName = customerName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
    }


}
