package com.esgglobal.TestJavaApplication.controller;

public record Customer (String customerRef,
                        String customerName,
                        String addressLine1,
                        String addressLine2,
                        String town,
                        String county,
                        String country,
                        String postcode){}
