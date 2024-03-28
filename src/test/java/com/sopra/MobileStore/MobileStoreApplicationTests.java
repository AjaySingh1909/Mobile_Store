package com.sopra.MobileStore;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sopra.MobileStore.Model.Mobile;
import com.sopra.MobileStore.Repository.Repos;

@SpringBootTest
@AutoConfigureMockMvc
class MobileStoreApplicationTests {

	@Autowired
	private MockMvc mockmvc;
	
	
	@Autowired
	private Repos repo;
	
	@Test
	@Disabled
	public void testFun() throws Exception {
		List<Mobile> lis=new ArrayList<Mobile>();
		
		Mobile m1=new Mobile("Samsung", "S23", "abc201", 34000, "12", "256", "Black", "No image");
		Mobile m2=new Mobile("Apple", "14Plus", "abc301", 70000, "-", "128", "Black", "No image");
		
		repo.save(m1);
		repo.save(m2);
		
		ResultActions res=mockmvc.perform(MockMvcRequestBuilders.get("/Mobile/all"));
		
		res.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testpost() throws Exception {
		Mobile m3=new Mobile("Oppo", "14Plus", "abc401", 15000, "8", "128", "Black", "No image");
		repo.save(m3);
		mockmvc.perform(post("/Mobile/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(m3)))
				.andExpect(status().isCreated());
	}
	
}
