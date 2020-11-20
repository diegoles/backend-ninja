package com.udemy.model;

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
    private String firstName;
    private String lastName;
    private String telephone;
    private String city;

    @Override
    public String toString() {
        return "ContactModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone + ", city=" + city + "]";
    }

}
