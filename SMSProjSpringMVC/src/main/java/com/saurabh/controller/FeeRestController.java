/*
 * 
 */
package com.saurabh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

// TODO: Auto-generated Javadoc
/**
 * This Class is used to handle all
 * the REST APIs related to the Fee Entity.
 *
 * @author Rachana Upputuru
 * @version 1.0
 * The Class FeeRestController.
 */
@RestController
@RequestMapping(value = { "/api","/fee"})
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class FeeRestController {

	/** The fee service. */
	@Autowired
	FeeService feeService;
	
	/**
	 * Gets the fee list.
	 *
	 * @return the response entity
	 */
	@GetMapping("/getlist")
	public ResponseEntity<List<Fee>> allFee() {
		
		List<Fee> li = feeService.getFeeList();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
	
	/**
	 * Gets the fee record.
	 *
	 * @param feeId the fee id
	 * @return the fee
	 */
	@GetMapping("/getrecord/{id}")
	public ResponseEntity<List<Fee>> getFee(@PathVariable("id") int feeId) {
		
		List<Fee> li = feeService.searchFee(feeId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
	
	/**
	 * Creates the fee.
	 *
	 * @param fee the fee
	 * @return the fee
	 */
	@PostMapping("/insert")
	public Fee createFee(@RequestBody Fee fee) {
		
		feeService.createFee(fee);
		return fee;
	}
	
	/**
	 * Delete fee.
	 *
	 * @param feeId the fee id
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Fee>> deleteFee(@PathVariable("id") int feeId) {
		
		List<Fee> li = feeService.deleteFee(feeId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
	
	
	/**
	 * Update fee.
	 *
	 * @param fee the fee
	 * @return the response entity
	 */
	@PutMapping("/update")
	public ResponseEntity<List<Fee>> updateFee(@RequestBody Fee fee) {
		
		List<Fee> li = feeService.updateFee(fee);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
	
	/**
	 * Update fee where Fee Amount zero.
	 *
	 * @return the response entity
	 */
	@PutMapping("/updatezero")
	public ResponseEntity<List<Fee>> updateFeeWhereZero() {
		
		List<Fee> li = feeService.updateFeeWhereZero();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Fee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Fee>>(li, HttpStatus.OK);
		
	}
}
