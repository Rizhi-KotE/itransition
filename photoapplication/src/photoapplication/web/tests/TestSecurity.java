package photoapplication.web.tests;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.google.common.collect.Maps;

import io.codearte.jfairy.producer.person.Person;
import photoapplication.config.WebConfig;
import utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class })
@WebAppConfiguration
public class TestSecurity {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@Test
	@WithMockUser
	public void getHome() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));
	}
	
	@Test
	public void unregistredUserHome() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print())
				.andExpect(redirectedUrl("../login"));
	}
	
	@Test
	public void getregisterPage() throws Exception{
		RequestBuilder registerRequest = get("/user/registration");
		mockMvc.perform(registerRequest).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void registerUser() throws Exception{
		MultiValueMap<String, String> params = createUserParams();
		RequestBuilder registerRequest = post("/user/registration");
		mockMvc.perform(registerRequest).andDo(print()).andExpect(status().isOk());
	}

	private MultiValueMap<String, String> createUserParams() {
		Person person = TestUtils.getRandomPerson();
		MultiValueMap<String, String> params = createUserParams();
		params.add("firstName", person.firstName());
		params.add("lastName", person.lastName());
		params.add("password", person.password());
		params.add("matchingPassword", person.password());
		params.add("email", person.email());
		return params;
	}
}