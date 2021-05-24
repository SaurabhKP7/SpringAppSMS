package com.saurabh.test;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saurabh.dao.FeeDao;
import com.saurabh.dao.FeeDaoImpl;
import com.saurabh.entity.Fee;

// TODO: Auto-generated Javadoc
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.saurabh.service.TeacherService;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//public class TeacherRestControllerTest {
//
//	private MockMvc mockMvc;
//	
//	@Autowired
//	TeacherService teacherService;
//	
//	@Test
//	public void testGetAllTeachers() throws Exception {
//		
//		 mockMvc.perform(get("/getlist"))
//         .andExpect(status().isOk())
//         .andExpect(jsonPath("$", hasSize(2)))
//         .andExpect(jsonPath("$[0].id", is(1)));
////         .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
////         .andExpect(jsonPath("$[0].title", is("Foo")))
////         .andExpect(jsonPath("$[1].id", is(2)))
////         .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
////         .andExpect(jsonPath("$[1].title", is("Bar")));
//
//		 verify(teacherService, times(1)).getTeacherList();
//		 verifyNoMoreInteractions(teacherService);
//	}
//
//	
//	
//}

/**
 * This is a Test Class for Fee Repository which tests
 * some of the CRUD functionalities of Fee Entity
 * @author Ramalingeswara Swamy Chaganti
 * @version 1.0
 * The Class FeeDaoTest.
 */
public class FeeDaoTest {
	
	/** The fee dao. */
	static FeeDao feeDao;
	
	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		feeDao = (FeeDaoImpl)context.getBean("feeDao");
	}
	
	/**
	 * Test get fee list.
	 */
	@Test
	public void testGetFeeList() {
		List<Fee> fees = feeDao.getFeeList();
		System.out.println(fees.get(0));
//		assertTrue((feeDao.getFeeList()).size() >= 1);
//		assertTrue((fees.get(1)).getFeeAmount()==1499);
		assertEquals(fees.get(0).getFeeAmount(), 1588);
	}
	
	/**
	 * Test update fee.
	 */
	@Test
	public void testUpdateFee()
	{
		Fee f = new Fee();
		f.setFeeAmount(1588);
		f.setPaymentMode("UPI");
		f.setFeeId(2);
		List<Fee> fees = feeDao.updateFee(f);
		assertEquals(fees.get(0).getPaymentMode(),"UPI");
		
	}
//	@Test
//	public void testAddFee()
//	{
//		Fee f = new Fee();
//		f.setFeeAmount(1000);
//		f.setPaymentMode("NET BANKING");
//		f.setFeeId(3);
//		feeDao.createFee(f);
//		List<Fee> fees = feeDao.getFeeList();
//		assertEquals(fees.get(2).getPaymentMode(),"NET BANKING");
//		
//	}
}
