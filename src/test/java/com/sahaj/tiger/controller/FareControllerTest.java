package com.sahaj.tiger.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahaj.tiger.data.JourneyDataProvider;
import com.sahaj.tiger.model.Zones;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FareControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Test the single journey")
	public void calculateFareSuccessForSingleJourneyTest() throws Exception {
		mockMvc.perform(post("/calculate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(asJsonString(JourneyDataProvider.getSingleJourneyRequest())))
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Test the multiple journey")
	public void calculateFareSuccessForMultipleJourneyTest() throws Exception {
		MvcResult result = mockMvc.perform(post("/calculate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(asJsonString(JourneyDataProvider.getMultipleJourneyRequest())))
				.andExpect(status().isOk())
				.andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), "50");
	}
	
	@Test
	@DisplayName("Test the multiple days journey for Zone 1")
	public void calculateFareSuccessForMultipleDaysJourneyZone1Test() throws Exception {
		MvcResult result = mockMvc.perform(post("/calculate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(asJsonString(JourneyDataProvider.getMultipleDaysJourneyRequest(Zones.Zone1))))
				.andExpect(status().isOk())
				.andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), "250");
	}
	
	@Test
	@DisplayName("Test the multiple days journey for Zone 2")
	public void calculateFareSuccessForMultipleDaysJourneyZone2Test() throws Exception {
		MvcResult result = mockMvc.perform(post("/calculate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(asJsonString(JourneyDataProvider.getMultipleDaysJourneyRequest(Zones.Zone2))))
				.andExpect(status().isOk())
				.andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), "200");
	}
	
	@Test
	@DisplayName("Test the multiple days journey as asked in assignment")
	public void calculateFareSuccessForMultipleDaysJourneyAssignmentInputTest() throws Exception {
		MvcResult result = mockMvc.perform(post("/calculate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(asJsonString(JourneyDataProvider.getAskedJourneyRequestAsInput(Zones.Zone1))))
				.andExpect(status().isOk())
				.andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), "120");
	}
	
	@Test
	@DisplayName("Test the invalid journey")
	public void calculateFareFailureForInvalidJourneyTest() throws Exception {
		mockMvc.perform(post("/calculate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				//.content(null))
				.andExpect(status().isBadRequest());
	}
	
	
	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
