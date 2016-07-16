package photoapplication.web.tests;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import photoapplication.web.controller.UploadController;


public class UploadControllerTest {
	private MockMvc initMockWithController() {
		UploadController controller = new UploadController();
		return standaloneSetup(controller).build();
	}

	@Test
	public void testHomePage() throws Exception {
		MockMvc mockMvc = initMockWithController();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
}