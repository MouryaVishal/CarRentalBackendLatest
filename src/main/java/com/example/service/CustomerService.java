package com.example.service;

import com.example.exception.CustomerExceptionController;
import com.example.exception.CustomerNotFoundException;
import com.example.model.Coupon;
import com.example.model.Customer;
import com.example.repo.CustomerRepository;
import com.example.request.CustomerResquestToRegister;
import com.example.service.servicesInterface.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface {
    @Autowired
    private CustomerRepository customerRepository;
    public ResponseEntity<Object> addCustomer(CustomerResquestToRegister customer){
        Optional<Customer> currCustomer=customerRepository.findByName(customer.getName());
        if(currCustomer.isPresent() && Objects.equals(currCustomer.get().getName(), customer.getName())
                && Objects.equals(currCustomer.get().getEmail(), customer.getEmail())){
            return new ResponseEntity<>("Customer with name:"+currCustomer.get().getName()+" and email:-"+customer.getEmail()+" is already Present!!!",HttpStatus.NOT_FOUND);
        }
        Customer newCustomer=new Customer();
        newCustomer.setFistTime(true);
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setName(customer.getName());
        newCustomer.setPhone(customer.getPhone());
        customerRepository.save(newCustomer);
        return new ResponseEntity<>(newCustomer,HttpStatus.OK);
    }

    public Iterable<Customer> allCustomer(){
        return customerRepository.findAll();
    }

    public String deleteById(Long id){
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return "Deleted SuccessFully!!";
        };
        return "Delete Fail. No Such id found!!";
    }

    public ResponseEntity<Object> updateById(Long id, CustomerResquestToRegister customer) {
        Optional<Customer> updateCustomer = customerRepository.findById(id);
        if (updateCustomer.isPresent()) {
            updateCustomer.get().setFistTime(customer.getFistTime());
            updateCustomer.get().setEmail(customer.getEmail());
            updateCustomer.get().setName(customer.getName());
            updateCustomer.get().setPhone(customer.getPhone());
            customerRepository.save(updateCustomer.get());
            return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
        } else {
            throw new CustomerNotFoundException();
        }
    }
}
