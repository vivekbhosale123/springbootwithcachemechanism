package com.vdb.service;

import com.vdb.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Customer save(Customer customer);

    Optional<Customer> findById(int custId);

    List<Customer> findAll();

    Customer update(Customer customer);

    void delete(int custId);


}
