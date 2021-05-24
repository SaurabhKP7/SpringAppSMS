package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.FeeDao;
import com.saurabh.entity.Fee;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Service Layer between the Fee Repository
 * and Fee REST Controller.
 * @author Saurabh Prasad
 * @version 1.0
 * The Class FeeServiceImpl.
 */
@Service
@Transactional
public class FeeServiceImpl implements FeeService {

	/** The fee dao. */
	@Autowired
	FeeDao feeDao;
	
	/**
	 * Creates the fee.
	 *
	 * @param fee the fee
	 */
	@Override
	public void createFee(Fee fee) {
		
		feeDao.createFee(fee);
	}

	/**
	 * Update fee.
	 *
	 * @param fee the fee
	 * @return the list
	 */
	@Override
	public List<Fee> updateFee(Fee fee) {
		
		return feeDao.updateFee(fee);
	}

	/**
	 * Delete fee.
	 *
	 * @param feeId the fee id
	 * @return the list
	 */
	@Override
	public List<Fee> deleteFee(int feeId) {
		
		return feeDao.deleteFee(feeId);
	}

	/**
	 * Search fee.
	 *
	 * @param feeId the fee id
	 * @return the list
	 */
	@Override
	public List<Fee> searchFee(int feeId) {
		
		return feeDao.searchFee(feeId);
	}

	/**
	 * Gets the fee list.
	 *
	 * @return the fee list
	 */
	@Override
	public List<Fee> getFeeList() {
		
		return feeDao.getFeeList();
	}

	/**
	 * Update fee where zero.
	 *
	 * @return the list
	 */
	@Override
	public List<Fee> updateFeeWhereZero() {
		
		return feeDao.updateFeeWhereZero();
	}

}
