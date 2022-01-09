package com.jacle.spboot.httpmodule.validate;

import lombok.Data;

@Data
public class Customer {

    private String firstName;
    private String surname;

    private Address address;
}
