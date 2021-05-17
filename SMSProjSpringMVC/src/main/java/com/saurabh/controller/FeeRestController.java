package com.saurabh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.entity.Fee;
import com.saurabh.service.FeeService;

@RestController
@RequestMapping(value = "/fee")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class FeeRestController {

	@Autowired
	FeeService feeService;
	
	@GetMapping("/getlist")
	private ResponseEntity<List<Fee>> allFee() {
		
		List<Fee> li = feeService.getFeeList();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
	
	@GetMapping("/getrecord/{id}")
	private ResponseEntity<List<Fee>> getFee(@PathVariable("id") int feeId) {
		
		List<Fee> li = feeService.searchFee(feeId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
	
	@PostMapping("/insert")
	private Fee createFee(@RequestBody Fee fee) {
		
		feeService.createFee(fee);
		return fee;
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<List<Fee>> deleteFee(@PathVariable("id") int feeId) {
		
		List<Fee> li = feeService.deleteFee(feeId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/update")
	private ResponseEntity<List<Fee>> updateFee(@RequestBody Fee fee) {
		
		List<Fee> li = feeService.updateFee(fee);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
}
