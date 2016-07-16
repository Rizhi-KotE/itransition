package test.resources;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.webapplication.photoaplication.controller.UploadFileController;

public class UploadControllerTest {
	@Test
	public void testHomePage() throws Exception {
		UploadFileController controller = new UploadFileController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		assertEquals("home", controller.home());
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
}
