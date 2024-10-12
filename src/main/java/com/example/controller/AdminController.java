package com.example.controller;

import com.example.model.Car;
import com.example.model.Category;
import com.example.model.Coupon;
import com.example.model.Customer;
import com.example.request.CarRequest;
import com.example.request.CategoryRequest;
import com.example.request.CouponResquestToAdd;
import com.example.service.CarService;
import com.example.service.CategoryService;
import com.example.service.CouponService;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private CarService carService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerService customerService;


//    For Category
    @PostMapping("/addcategory")
    public ResponseEntity<Object> addCategory(@RequestBody CategoryRequest request){
        return categoryService.addCategory(request);
    }
    @GetMapping("/allcategory")
    public ResponseEntity<Iterable<Category>> allCategory(){
        Iterable<Category> categories=categoryService.allCategory();
        return ResponseEntity.ok(categories);
    }
    @DeleteMapping ("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        String responseStr=categoryService.deleteById(id);
        return ResponseEntity.ok(responseStr);
    }
    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category){
        return categoryService.updateById(id,category);
    }



//    For Car
    @PostMapping("/addcar")
    public ResponseEntity<Object> addCar(@RequestBody CarRequest car){
        return carService.addCar(car);
    }

    @PostMapping("/increasecarcount/{id}/{byNum}")
    public ResponseEntity<Object> increseCountOfCarWithCategory(@PathVariable Long id,@PathVariable int byNum){
        return carService.increseCountOfCar(id,byNum);
    }

    @PostMapping("/increasecarcount/{name}/{byNum}")
    public ResponseEntity<Object> increseCountOfCarWithName(@PathVariable String name,@PathVariable int byNum){
        return carService.increseCountOfCarByName(name,byNum);
    }

    @GetMapping("/allcars")
    public ResponseEntity<Iterable<Car>> allCar(){
        Iterable<Car> cars=carService.allcars();
            return ResponseEntity.ok(cars);
    }

    @DeleteMapping ("/deletecar/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        String responseStr=categoryService.deleteById(id);
        return ResponseEntity.ok(responseStr);
    }
    @PutMapping("/updatecar/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable Long id,@RequestBody CarRequest car){
        return carService.updateById(id,car);
    }

   // Coupon RestApi

    @PostMapping("/addcoupon")
    public ResponseEntity<Object> addCoupon(@RequestBody CouponResquestToAdd coupon){
        ResponseEntity<Object> newCategory=couponService.addCoupon(coupon);
        return ResponseEntity.ok(newCategory);
    }

    @GetMapping("/allcoupon")
    public ResponseEntity<Iterable<Coupon>> allCoupon(){
        Iterable<Coupon> coupon=couponService.allCoupon();
        return ResponseEntity.ok(coupon);
    }

    @DeleteMapping ("/deletecoupon/{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable Long id){
        String responseStr=couponService.deleteById(id);
        return ResponseEntity.ok(responseStr);
    }
    @PutMapping("/updatecoupon/{id}")
    public ResponseEntity<Coupon> updateCar(@PathVariable Long id,@RequestBody CouponResquestToAdd coupon){
        return couponService.updateById(id,coupon);
    }


//    CustomerAPI
    @GetMapping("/allcustomer")
    public ResponseEntity<Iterable<Customer>> allcustomer(){
        Iterable<Customer> customers=customerService.allCustomer();
        return ResponseEntity.ok(customers);
    }
}
