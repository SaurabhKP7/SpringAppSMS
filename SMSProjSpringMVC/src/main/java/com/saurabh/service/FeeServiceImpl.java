package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.FeeDao;
import com.saurabh.entity.Fee;

@Service
@Transactional
public class FeeServiceImpl implements FeeService {

	@Autowired
	FeeDao feeDao;
	
	@Override
	public void createFee(Fee fee) {
		
		feeDao.createFee(fee);
	}

	@Override
	public List<Fee> updateFee(Fee fee) {
		
		return feeDao.updateFee(fee);
	}

	@Override
	public List<Fee> deleteFee(int feeId) {
		
		return feeDao.deleteFee(feeId);
	}

	@Override
	public List<Fee> searchFee(int feeId) {
		
		return feeDao.searchFee(feeId);
	}

	@Override
	public List<Fee> getFeeList() {
		
		return feeDao.getFeeList();
	}

}
