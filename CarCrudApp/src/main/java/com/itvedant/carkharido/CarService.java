package com.itvedant.carkharido;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;
	public CarDTO addCar(CarDTO car) {
		return carRepository.save(car);
	}
	
	public List<CarDTO> viewCar() {
		List<CarDTO> carlist=carRepository.findAll();
		return carlist;
	}
	
	public CarDTO getcar(Integer id) {
		CarDTO car = carRepository.findById(id).orElse(null);
		return car;
	}

	public String deleteCar(Integer id) {
		CarDTO cartobedeleted =carRepository.findById(id).orElse(null);
		if(cartobedeleted==null) {
			return "Car is not present with thid id";
		}
		else {
			carRepository.deleteById(id);
			return "Car id Deleted";
		}
		
	}
	public String deleteAllCars() {
		carRepository.deleteAll();
		return "All Cars Are Deleted";
	}
	
	public String updateCar(Integer id,CarDTO car) {
		CarDTO cartobeupdated =carRepository.findById(id).orElse(null);
		if(cartobeupdated==null) {
			return "Car is not present with this id";
		}
		else {
			cartobeupdated.setBrand(car.getBrand());
			cartobeupdated.setModel(car.getModel());
			cartobeupdated.setPrice(car.getPrice());
			carRepository.save(cartobeupdated);
			return "Car is Updated";
		}
	}

	public String updatebrand(Integer id, String brand) {
		CarDTO updatebrand =carRepository.findById(id).orElse(null);
		if(updatebrand==null) {
			return "Car is not present with this id";
		}
		else {
			updatebrand.setBrand(brand);
			carRepository.save(updatebrand);
			return "brand is Updated";
		}
	}
	public String updatemodel(Integer id, String model) {
		CarDTO updatedmodel =carRepository.findById(id).orElse(null);
		if(updatedmodel==null) {
			return "Car is not present with this id";
		}
		else {
			updatedmodel.setBrand(model);
			carRepository.save(updatedmodel);
			return "brand is Updated";
		}
	}
	
	public String updateprice(Integer id, String price) {
		CarDTO updatedprice =carRepository.findById(id).orElse(null);
		if(updatedprice==null) {
			return "Car is not present with this id";
		}
		else {
			updatedprice.setBrand(price);
			carRepository.save(updatedprice);
			return "brand is Updated";
		}
	}
	
	
	
	
	
	
}
