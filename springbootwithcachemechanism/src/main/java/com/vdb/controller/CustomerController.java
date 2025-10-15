package com.vdb.controller;

import com.vdb.exception.RecordNotFoundException;
import com.vdb.model.Customer;
import com.vdb.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer)
    {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{custId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId)
    {
        return new ResponseEntity<>(customerService.findById(custId),HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> findAll()
    {
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable int custId,@Valid @RequestBody Customer customer)
    {
        Customer customer1=customerService.findById(custId).orElseThrow(()->new RecordNotFoundException("Customer not exists"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());

        return new ResponseEntity<>(customerService.update(customer1),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{custId}")
    public ResponseEntity<String> delete(@PathVariable int custId)
    {
        Customer customer1=customerService.findById(custId).orElseThrow(()->new RecordNotFoundException("Customer not exists"));

        customerService.delete(custId);

        return new ResponseEntity<>("customer deleted successfully",HttpStatus.OK);
    }
}
