package spring.learning.petclinic.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
class IndexControllerTest {
	@InjectMocks
	IndexController controller;

	@Test
	void index() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
		                                 .build();

		mockMvc.perform(get("/"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("index"));
	}

	@Test
	void oupsHendler() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
		                                 .build();

		mockMvc.perform(get("/oups"))
		       .andExpect(status().isNotImplemented())
		       .andExpect(view().name("notimplemented"));
	}

}