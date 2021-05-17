package com.saurabh.dao;

import java.util.List;

import com.saurabh.entity.Fee;

public interface FeeDao {

	public void createFee(Fee fee);
	public List<Fee> updateFee(Fee fee);
	public List<Fee> deleteFee(int feeId); 
	public List<Fee> searchFee(int feeId);
	public List<Fee> getFeeList();
//	public Fee getFee(Fee fee);
}
