package com.example.controller;

import com.example.model.Car;
import com.example.model.Category;
import com.example.model.Coupon;
import com.example.request.CouponResquestToAdd;
import com.example.service.CarService;
import com.example.service.CategoryService;
import com.example.service.CouponService;
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


//    For Category
    @PostMapping("/addcategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCategory=categoryService.addCategory(category);
        return ResponseEntity.ok(newCategory);
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
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car newCategory=carService.addCar(car);
        return ResponseEntity.ok(newCategory);
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
    public ResponseEntity<Car> updateCar(@PathVariable Long id,@RequestBody Car car){
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
}
