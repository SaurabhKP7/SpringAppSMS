package com.saurabh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Fee Entity which has all 
 * the variables related to fee details and has 
 * a one-to-one relationship with Course Entity
 * @author Sasikiran Putta
 * @version 1.0
 * The Class Fee.
 */
@Entity
public class Fee implements Serializable {

	/** The fee id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feeId;
	
	/** The fee amount. */
	private int feeAmount;
	
	/** The payment mode. */
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


	/**
 * Gets the fee id.
 *
 * @return the fee id
 */
public int getFeeId() {
		return feeId;
	}
	
	/**
	 * Sets the fee id.
	 *
	 * @param feeId the new fee id
	 */
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	
	/**
	 * Gets the fee amount.
	 *
	 * @return the fee amount
	 */
	public int getFeeAmount() {
		return feeAmount;
	}
	
	/**
	 * Sets the fee amount.
	 *
	 * @param feeAmount the new fee amount
	 */
	public void setFeeAmount(int feeAmount) {
		this.feeAmount = feeAmount;
	}
	
	/**
	 * Gets the payment mode.
	 *
	 * @return the payment mode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	
	/**
	 * Sets the payment mode.
	 *
	 * @param paymentMode the new payment mode
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Fee [feeId=" + feeId + ", feeAmount=" + feeAmount + ", paymentMode=" + paymentMode + "]";
	}


	
	
	
	
}
