package com.example.addressbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "address_books")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String country;
    private String pincode;

    public AddressBook(String firstName, String lastName, String street, String city, String country, String pincode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
    }
}
