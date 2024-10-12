package com.example.service;


import com.example.exception.CategoryNotFoundException;
import com.example.exception.CouponNotFoundException;
import com.example.model.Category;
import com.example.model.Coupon;
import com.example.model.Customer;
import com.example.model.RentalOrder;
import com.example.repo.CategoryRepository;
import com.example.repo.CouponRepository;
import com.example.repo.CustomerRepository;
import com.example.request.CouponResquestToAdd;
import com.example.service.servicesInterface.CouponServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService implements CouponServiceInterface {
    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Object> addCoupon(CouponResquestToAdd coupon){
        Optional<Coupon> isCouponPresent=couponRepository.findByName(coupon.getCouponName());
        if(isCouponPresent.isPresent()){
            return  new ResponseEntity<>("Sorry! Coupon with name:"+coupon.getCouponName()+" already present!!",HttpStatus.NOT_FOUND);
        }
        Coupon addedCoupon=new Coupon();
        addedCoupon.setName(coupon.getCouponName());
        addedCoupon.setDiscountValue(coupon.getDiscountAmount());
        couponRepository.save(addedCoupon);
        return new ResponseEntity<>(addedCoupon,HttpStatus.OK);
    }

    public Iterable<Coupon> allCoupon(){
        return couponRepository.findAll();
    }

    public String deleteById(Long id){
        if(couponRepository.existsById(id)) {
            couponRepository.deleteById(id);
            return "Deleted SuccessFully!!";
        };
        return "Delete Fail. No Such id found!!";
    }

    public ResponseEntity<Coupon> updateById(Long id, CouponResquestToAdd coupon) {
        Optional<Coupon> updateCoupon = couponRepository.findById(id);
        if (updateCoupon.isPresent()) {
            updateCoupon.get().setName(coupon.getCouponName());
            updateCoupon.get().setDiscountValue(coupon.getDiscountAmount());
            Coupon updatedCat = couponRepository.save(updateCoupon.get());
            return new ResponseEntity<Coupon>(updatedCat, HttpStatus.OK);
        } else {
            throw new CouponNotFoundException();
        }
    }

    public ResponseEntity<List<Object>> findCouponForCustomer(Long id, int days ){
        List<Object> coupons = new ArrayList<>();
        if(days>30) {
            coupons.add("NO Coupon Available for more than 30days....");
            return new ResponseEntity<>(coupons,HttpStatus.NOT_FOUND);
        }
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            Coupon co=new Coupon();
            co.setName("FIRSTTIME");
            co.setId(1L);
            co.setDiscountValue(50D);
            coupons.add(co);
        }
        System.out.println(id+ " "+days+" weqew");
        if (days>=20){
            Coupon co=new Coupon();
            co.setName("Coupon30");
            co.setDiscountValue(30D);
            coupons.add(co);
        }else if (days>=10){
            Coupon co=new Coupon();
            co.setName("Coupon20");
            co.setId(5L);
            co.setDiscountValue(20D);
            coupons.add(co);
        }else {
            Coupon co=new Coupon();
            co.setName("Coupon10");
            co.setId(4L);
            co.setDiscountValue(10D);
            coupons.add(co);
        }
        System.out.println(coupons);
        return new ResponseEntity<>(coupons, HttpStatus.OK);
    }
}
