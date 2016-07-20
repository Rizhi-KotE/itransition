package photoapplication.web.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import photoapplication.config.PhotoApplicationConfig;
import photoapplication.config.SecurityConfig;
import photoapplication.web.controller.UploadController;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PhotoApplicationConfig.class)
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