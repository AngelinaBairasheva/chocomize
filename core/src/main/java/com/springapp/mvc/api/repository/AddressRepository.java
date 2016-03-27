package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addAddress(Address address) {
        sessionFactory.getCurrentSession().save(address);
    }

    public void updateAddress(Address address) {
        sessionFactory.getCurrentSession().update(address);
    }

    public Address getAddressById(Long id) {
        return (Address) sessionFactory.getCurrentSession().load(Address.class, id);
    }

    public void deleteAddress(Address address) {
        sessionFactory.getCurrentSession().delete(address);
    }
}
