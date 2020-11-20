package com.udemy.model;

import java.math.BigInteger;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ContactModel {

    private int id;
    @NotNull
    private BigInteger ci;
    @Size(min = 2, max = 6)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 6)
    private String lastName;
    @Min(18)
    private Integer age;
    private String bloodType;
    private String telephone;
    private String cellphone;

    private String city;
    private String address;

}
