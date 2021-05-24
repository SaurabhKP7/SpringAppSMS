package com.saurabh.service;

import java.util.List;

import com.saurabh.entity.Fee;

// TODO: Auto-generated Javadoc
/**
 * This Interface is used to declare methods
 * for CRUD operations of Fee Entity through Fee Service Layer
 * @author Saurabh Prasad
 * @version 1.0
 * The Interface FeeService.
 */
public interface FeeService {

	/**
	 * Creates the fee.
	 *
	 * @param fee the fee
	 */
	public void createFee(Fee fee);
	
	/**
	 * Update fee.
	 *
	 * @param fee the fee
	 * @return the list
	 */
	public List<Fee> updateFee(Fee fee);
	
	/**
	 * Delete fee.
	 *
	 * @param feeId the fee id
	 * @return the list
	 */
	public List<Fee> deleteFee(int feeId); 
	
	/**
	 * Search fee.
	 *
	 * @param feeId the fee id
	 * @return the list
	 */
	public List<Fee> searchFee(int feeId);
	
	/**
	 * Gets the fee list.
	 *
	 * @return the fee list
	 */
	public List<Fee> getFeeList();
	
	/**
	 * Update fee where feeAmount is zero.
	 *
	 * @return the list
	 */
	public List<Fee> updateFeeWhereZero();
//	public Fee getFee(Fee fee);
}
