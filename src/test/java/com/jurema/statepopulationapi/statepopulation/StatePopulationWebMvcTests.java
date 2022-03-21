package com.jurema.statepopulationapi.statepopulation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
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
	@Sql("classpath:datasets/state-populations.sql")
	@Sql(statements = "delete from state_population", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void shouldListStatePopulation() throws Exception {
		// given
		var request = get("/state-populations");

		// when
		var response = mvc.perform(request);

		// then
		response.andExpectAll(
			status().isOk(),
			jsonPath("$", hasSize(2)),
			jsonPath("$[0].id", equalTo(1)),
			jsonPath("$[0].uf", equalTo("SP")),
			jsonPath("$[0].populacao", equalTo(1000)),
			jsonPath("$[1].id", equalTo(2)),
			jsonPath("$[1].uf", equalTo("RJ")),
			jsonPath("$[1].populacao", equalTo(2000))
		);
	}
}
