package com.example.service;

import com.example.exception.CarNotFoundException;
import com.example.exception.CategoryNotFoundException;
import com.example.model.Car;
import com.example.model.Category;
import com.example.repo.CarRepository;
import com.example.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public Iterable<Car> allcars(){
        return carRepository.findAll();
    }

    public String deleteById(Long id){
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return "Deleted SuccessFully!!";
        };
        return "Delete Fail. No Such id found!!";
    }

    public ResponseEntity<Car> updateById(Long id, Car carDetails) {
        Optional<Car> optionalCategory = carRepository.findById(id);
        if (optionalCategory.isPresent()) {
//            Car car = optionalCategory.get();
//            car=carDetails;
////            car.setName(carDetails.getName());
////            car.setCategoryId(carDetails.getCategoryId());
////            car.setPricePerDay(carDetails.getPricePerDay());
////            Car.
            Car updatedCat = carRepository.save(carDetails);
            return new ResponseEntity<Car>(updatedCat, HttpStatus.OK);
        } else {
            throw new CarNotFoundException();
        }
    }

    public Iterable<Car> allCarsByCategory( String categoryName){
        List<Category> c = (List<Category>) categoryRepository.findByCategoryName(categoryName);
        return carRepository.findByCategoryName(c.get(0).getId());
    }


    public Optional<Car> searchByCarName( String carName){
        return (Optional<Car>) carRepository.findByName(carName);
    }


}
