package com.saurabh.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.saurabh.service.TeacherService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TeacherRestControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	TeacherService teacherService;
	
	@Test
	public void testGetAllTeachers() throws Exception {
		
		 mockMvc.perform(get("/getlist"))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$", hasSize(2)))
         .andExpect(jsonPath("$[0].id", is(1)));
//         .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
//         .andExpect(jsonPath("$[0].title", is("Foo")))
//         .andExpect(jsonPath("$[1].id", is(2)))
//         .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
//         .andExpect(jsonPath("$[1].title", is("Bar")));

		 verify(teacherService, times(1)).getTeacherList();
		 verifyNoMoreInteractions(teacherService);
	}

	
	
}
