package com.saurabh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.saurabh.entity.Student;
import com.saurabh.service.StudentService;

@Controller
public class StudentController {

	Student student;
	
	@Autowired
	StudentService studentService;
	
	
	private ModelAndView allStudent() {
		
		List<Student> li = studentService.getStudentList();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", li);
		return mv;
		
	}
	
	@RequestMapping(value = "/regstudent", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam Map<String, String> allQueryParams) {
		
		System.out.println(allQueryParams);
		
//		int sid = Integer.parseInt(allQueryParams.get("txtempid"));
		String fname = allQueryParams.get("txtfname");
		String lname = allQueryParams.get("txtlname");
		String gender = allQueryParams.get("rdgender");
		int age = Integer.parseInt(allQueryParams.get("txtage"));
		String phone = allQueryParams.get("txtage");
		String email = allQueryParams.get("txtemail");
		String password = allQueryParams.get("txtpassword");
		
		student = new Student();
		student.setFirstname(fname);
		student.setLastname(lname);
		student.setGender(gender);
		student.setEmail(email);
		student.setAge(age);
		student.setPhone(phone);
		student.setPassword(password);
		System.out.println(student);
		studentService.createStudent(student);
		
		return new ModelAndView("login"); 
	}
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam Map<String, String> allQueryParams) {
		
		int sid = Integer.parseInt(allQueryParams.get("sid"));
		String fname = allQueryParams.get("fname");
		String lname = allQueryParams.get("lname");
		String gender = allQueryParams.get("gender");
		int age = Integer.parseInt(allQueryParams.get("age"));
		String phone = allQueryParams.get("age");
		String email = allQueryParams.get("email");
		String password = allQueryParams.get("password");
		
		student.setStudentId(sid);
		student.setFirstname(fname);
		student.setLastname(lname);
		student.setGender(gender);
		student.setEmail(email);
		student.setAge(age);
		student.setPhone(phone);
		student.setPassword(password);
		studentService.updateStudent(student);
		return allStudent();

	}



	
	
}
