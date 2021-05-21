package com.saurabh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feeId;
	private int feeAmount;
	private String paymentMode;
	
	
//	public Fee() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	public Fee(int feeId, int feeAmount, String paymentMode) {
//		super();
//		this.feeId = feeId;
//		this.feeAmount = feeAmount;
//		this.paymentMode = paymentMode;
//	}


	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	public int getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(int feeAmount) {
		this.feeAmount = feeAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	@Override
	public String toString() {
		return "Fee [feeId=" + feeId + ", feeAmount=" + feeAmount + ", paymentMode=" + paymentMode + "]";
	}


	
	
	
	
}
