/*
 * @author Saurabh Prasad
 * @version 1.0
 */
package com.saurabh.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saurabh.entity.Fee;

// TODO: Auto-generated Javadoc
/**
 * This Class is used to perform CRUD
 * operations on Fee Entity which interacts
 * with the Database
 * @author Saurabh Prasad
 * @version 1.0
 * The Class FeeDaoImpl.
 */
@Repository
public class FeeDaoImpl implements FeeDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

//	protected Session getSession() {
//
//		return sessionFactory.getCurrentSession();
//	}
	
	/**
 * Gets the session factory.
 *
 * @return the session factory
 */
public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Gets the current session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		try 
		{
		   return sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    return sessionFactory.openSession();
		}
	}

	/**
	 * Creates the fee.
	 *
	 * @param fee the fee
	 */
	@Override
	public void createFee(Fee fee) {

		getSession().saveOrUpdate(fee);
		System.out.println("Fee Saved Successfully");
	}

	/**
	 * Update fee.
	 *
	 * @param fee the fee
	 * @return the list
	 */
	@Override
	public List<Fee> updateFee(Fee fee) {

		Query query = getSession()
				.createQuery("update Fee me set feeAmount=:famount,paymentMode=:pmode where feeId =:fid");
		query.setParameter("fid", fee.getFeeId());
		query.setParameter("famount", fee.getFeeAmount());
		query.setParameter("pmode", fee.getPaymentMode());

		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getFeeList();
	}

	/**
	 * Delete fee.
	 *
	 * @param feeId the fee id
	 * @return the list
	 */
	@Override
	public List<Fee> deleteFee(int feeId) {

		Query query = getSession().createQuery("delete Fee me where feeId =:fid");
		query.setParameter("fid", feeId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}

		return getFeeList();
	}

	/**
	 * Search for a fee record.
	 *
	 * @param feeId the fee id
	 * @return the list
	 */
	@Override
	public List<Fee> searchFee(int feeId) {

		Query query = getSession().createQuery("from Fee where feeId =:fid");
		query.setParameter("fid", feeId);
		List<Fee> feeList = query.list();

		return feeList;
	}

	/**
	 * Gets the fee list.
	 *
	 * @return the fee list
	 */
	@Override
	public List<Fee> getFeeList() {

		Query query = getSession().createQuery("select me from Fee me");
		List<Fee> feeList = query.list();
		return feeList;
	}

	/**
	 * Update fee where fee amount is zero.
	 *
	 * @return the list
	 */
	@Override
	public List<Fee> updateFeeWhereZero() {
		Query query = getSession()
				.createQuery("update Fee me set feeAmount=:famount where feeAmount =:zero");
		query.setParameter("zero", 0);
		query.setParameter("famount", 14299);

		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getFeeList();
	}

}
