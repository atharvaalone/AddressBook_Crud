package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.entity.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBook> getAllEntries() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getEntryById(Long id) {
        return addressBookRepository.findById(id).orElse(null);
    }

    @Override
    public AddressBook createEntry(AddressBookDTO addressBookDTO) {
        AddressBook entry = new AddressBook(
                addressBookDTO.getFirstName(),
                addressBookDTO.getLastName(),
                addressBookDTO.getStreet(),
                addressBookDTO.getCity(),
                addressBookDTO.getCountry(),
                addressBookDTO.getPincode()
        );
        return addressBookRepository.save(entry);
    }

    @Override
    public AddressBook updateEntry(Long id, AddressBookDTO addressBookDTO) {
        AddressBook entry = addressBookRepository.findById(id).orElse(null);
        if (entry != null) {
            entry.setFirstName(addressBookDTO.getFirstName());
            entry.setLastName(addressBookDTO.getLastName());
            entry.setStreet(addressBookDTO.getStreet());
            entry.setCity(addressBookDTO.getCity());
            entry.setCountry(addressBookDTO.getCountry());
            entry.setPincode(addressBookDTO.getPincode());
            return addressBookRepository.save(entry);
        }
        return null;
    }

    @Override
    public void deleteEntry(Long id) {
        addressBookRepository.deleteById(id);
    }
}
