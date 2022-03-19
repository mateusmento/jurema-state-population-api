package com.jurema.statepopulationapi.statepopulation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@WebMvcTest
@AutoConfigureDataJpa
public class StatePopulationWebMvcTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void shouldListStatePopulation() throws Exception {
		// given
		var request = get("/state-populations");

		// when
		var response = mvc.perform(request);

		// then
		response.andExpectAll(
			status().isOk(),
			jsonPath("$", hasSize(0))
		);
	}
}
