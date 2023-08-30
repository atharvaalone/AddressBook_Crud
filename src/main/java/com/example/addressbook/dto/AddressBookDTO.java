package com.example.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String country;
    private String pincode;
}
