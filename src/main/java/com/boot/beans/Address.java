package com.boot.beans;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Address {

    @Size(min = 2, max = 2, message = "State must be exactly 2 characters long")
    private String state;
}
