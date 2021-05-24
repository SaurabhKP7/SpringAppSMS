/*
 * @author Saurabh Prasad
 * @version 1.0
 */
package com.saurabh.dao;

import java.util.List;

import com.saurabh.entity.Fee;

// TODO: Auto-generated Javadoc
/**
 * This Interface is used declare the Methods
 * for CRUD operation on Fee Entity
 * @author Saurabh Prasad
 * @version 1.0
 * The Interface FeeDao.
 */
public interface FeeDao {

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
	 * Search for a fee record.
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
	 * Update fee where fee Amount is zero.
	 *
	 * @return the list
	 */
	public List<Fee> updateFeeWhereZero();
//	public Fee getFee(Fee fee);
}
