package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.entity.AddressBook;

import java.util.List;

public interface IAddressBookService {
    List<AddressBook> getAllEntries();
    AddressBook getEntryById(Long id);
    AddressBook createEntry(AddressBookDTO addressBookDTO);
    AddressBook updateEntry(Long id, AddressBookDTO addressBookDTO);
    void deleteEntry(Long id);
}
