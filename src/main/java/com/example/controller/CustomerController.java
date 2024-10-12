package com.example.controller;

import com.example.model.*;
import com.example.request.CustomerResquestToRegister;
import com.example.request.RequsetRentalOrder;
import com.example.service.CarService;
import com.example.service.CustomerService;
import com.example.service.RentalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentalOrderService rentalOrderService;

    @Autowired
    private CarService carService;


//    For customer

    @PostMapping("/registercustomer")
    public ResponseEntity<Object> addCoupon(@RequestBody CustomerResquestToRegister customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("/allcustomer")
    public ResponseEntity<Iterable<Customer>> allcustomer(){
        Iterable<Customer> customers=customerService.allCustomer();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping ("/deletecustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        String responseStr=customerService.deleteById(id);
        return ResponseEntity.ok(responseStr);
    }
    @PutMapping("/updatecustomer/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable Long id,@RequestBody CustomerResquestToRegister customer){
        return customerService.updateById(id,customer);
    }


//    For RentralOrder;

    @PostMapping("/placeOrder")
    public ResponseEntity<Object> placeOrder(@RequestBody RequsetRentalOrder requsetRentalOrder){
        return rentalOrderService.placeRentalOrder(requsetRentalOrder);
    }

    @GetMapping("/allrentalorder")
    public ResponseEntity<Iterable<RentalOrder>> allRentalOrder(){
        Iterable<RentalOrder> rentalOrders=rentalOrderService.allRentralOrder();
        return ResponseEntity.ok(rentalOrders);
    }

    @DeleteMapping ("/deleterentalorder/{id}")
    public ResponseEntity<String> deleteRentalOrder(@PathVariable Long id){
        String responseStr=rentalOrderService.deleteById(id);
        return ResponseEntity.ok(responseStr);
    }

    @PutMapping("/updaterentalorder/{id}")
    public ResponseEntity<RentalOrder> updateRentalOrder(@PathVariable Long id,@RequestBody RentalOrder rentalOrder){
        return rentalOrderService.updateById(id,rentalOrder);
    }

//    View All cars
    @GetMapping("/allCars")
    public ResponseEntity<Iterable<Car>> allCar(){
        Iterable<Car> cars=carService.allcars();
        return ResponseEntity.ok(cars);
    }
}
