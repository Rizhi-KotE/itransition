package photoapplication.web.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import photoapplication.web.controller.MainPageController;

public class MainPageControllerTest {
	@Test
	public void testMainPage() throws Exception {
		MainPageController controller = new MainPageController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/works_with_photo/")).andExpect(view().name("working_area"));
	}
}