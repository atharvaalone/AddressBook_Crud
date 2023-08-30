package com.example.addressbook.controllers;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.entity.AddressBook;
import com.example.addressbook.service.IAddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("/entries")
    public ResponseEntity<ResponseDTO> getAllEntries() {
        List<AddressBook> entries = addressBookService.getAllEntries();
        ResponseDTO responseDTO = new ResponseDTO("Get all entries successful", entries);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<ResponseDTO> getEntryById(@PathVariable Long id) {
        AddressBook entry = addressBookService.getEntryById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get entry by ID successful", entry);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/entries")
    public ResponseEntity<ResponseDTO> createEntry(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook createdEntry = addressBookService.createEntry(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Entry created successfully", createdEntry);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/entries/{id}")
    public ResponseEntity<ResponseDTO> updateEntry(@PathVariable Long id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook updatedEntry = addressBookService.updateEntry(id, addressBookDTO);
        if (updatedEntry != null) {
            ResponseDTO responseDTO = new ResponseDTO("Entry updated successfully", updatedEntry);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/entries/{id}")
    public ResponseEntity<ResponseDTO> deleteEntry(@PathVariable Long id) {
        addressBookService.deleteEntry(id);
        ResponseDTO responseDTO = new ResponseDTO("Entry deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
