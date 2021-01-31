package com.udemy.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    
    @Size(min = 10, max = 10)
    private String ci;
    
    private String firstName;
    
    private String lastName;
    
    @Min(0)
    @Max(150)
    private Integer age;
    
    private String bloodType;
    @Size(min = 0, max = 9)
    private String telephone;
    @Size(min = 0, max = 10)
    private String cellphone;
    @Min(0)
    private Integer confinementDays;

    private String city;
    private String address;
    private Double latitude;
    private Double longitude;

}
