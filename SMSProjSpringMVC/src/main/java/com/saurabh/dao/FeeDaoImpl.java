package com.saurabh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saurabh.entity.Fee;

@Repository
public class FeeDaoImpl implements FeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createFee(Fee fee) {

		getSession().saveOrUpdate(fee);
		System.out.println("Fee Saved Successfully");
	}

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

	@Override
	public List<Fee> searchFee(int feeId) {

		Query query = getSession().createQuery("from Fee where feeId =:fid");
		query.setParameter("fid", feeId);
		List<Fee> feeList = query.list();

		return feeList;
	}

	@Override
	public List<Fee> getFeeList() {

		Query query = getSession().createQuery("select me from Fee me");
		List<Fee> feeList = query.list();
		return feeList;
	}

}
