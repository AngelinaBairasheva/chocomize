package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Address;
import com.springapp.mvc.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void addAddress(Address address) {
        addressRepository.addAddress(address);
    }
}
