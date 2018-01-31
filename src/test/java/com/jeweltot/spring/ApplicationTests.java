package com.jeweltot.spring;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests
{
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup()
	{
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void callRootTest() throws Exception
	{
		this.mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(model().attributeExists("journal"))
			.andExpect(status().isOk());
	}

	@Test
	public void callTest() throws Exception
	{
		this.mockMvc.perform(get("/journal"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	//@Test
	public void summaryCallTest() throws Exception
	{
		this.mockMvc.perform(get("/journal/search/findBySummaryContaining").param("word", "요약1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$._embedded.entry.[0].summary", containsString("요약1")));
	}
}
