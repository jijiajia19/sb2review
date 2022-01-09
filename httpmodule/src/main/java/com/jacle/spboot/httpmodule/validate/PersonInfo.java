package com.jacle.spboot.httpmodule.validate;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonInfo {

    @NotNull
    @Size(min = 5)
    private String name;
}