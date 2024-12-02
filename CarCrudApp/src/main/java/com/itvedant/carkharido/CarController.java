package com.itvedant.carkharido;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CarController {
	@Autowired
	CarService service;
	
	@PostMapping("/addcar")
	public ResponseEntity<?> addCar(@RequestBody CarDTO car) {
		CarDTO addedcar = service.addCar(car);
		if(addedcar==null) {
			return ResponseEntity.ok("Car Not Added!!!");
		}
		else {
			return ResponseEntity.ok("Car Added!!!");
		}	
	}
	@GetMapping("/getallcars")
	public ResponseEntity<?> viewAllCar(){
		
	List<CarDTO> carlist=service.viewCar();
	if(carlist==null) {
		return ResponseEntity.ok("Cars not Available");
	}
	else {
		return ResponseEntity.ok(carlist);
	}
	}
	
	@GetMapping("/getcar")
	public ResponseEntity<?> getCarById(@RequestParam Integer id){
		CarDTO car=service.getcar(id);
		if(car==null) {
			return ResponseEntity.ok("Car Not found");
		}
		else {
			return ResponseEntity.ok(car);
		}
		
	}

	@DeleteMapping("/deletecar")
	public ResponseEntity<?> deleteCar(@RequestParam Integer id){
		String msg= service.deleteCar(id);
		return ResponseEntity.ok(msg);
		
	}
	@DeleteMapping("/deleteallcars")
	public ResponseEntity<?> deleteAllCars(){
		String msg = service.deleteAllCars();
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("/updatecar")
	public ResponseEntity<?> updateCar(@RequestParam Integer id, @RequestBody CarDTO car){
		String msg = service.updateCar(id,car);
		return ResponseEntity.ok(msg);
	}
	@PatchMapping("/updatedata/brand")
	public ResponseEntity<?> updatbrand(@RequestParam Integer id, @RequestParam String brand){
		String msg = service.updatebrand(id,brand);
		return ResponseEntity.ok(msg);
	}
	
	@PatchMapping("/updatedata/model")
	public ResponseEntity<?> updatemodel(@RequestParam Integer id, @RequestParam String model){
		String msg = service.updatemodel(id,model);
		return ResponseEntity.ok(msg);
	}
	
	@PatchMapping("/updatedata/price")
	public ResponseEntity<?> updateprice(@RequestParam Integer id, @RequestParam String price){
		String msg = service.updateprice(id,price);
		return ResponseEntity.ok(msg);
	}
}
