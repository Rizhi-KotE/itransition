package photoapplication.web.tests;

import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import io.codearte.jfairy.producer.person.Person;
import photoapplication.config.TestDataConfig;
import photoapplication.config.WebConfig;
import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;
import photoapplication.database.service.EmailExistsException;
import photoapplication.database.service.ImageService;
import photoapplication.database.service.ImageUserService;
import photoapplication.web.dto.UserDTO;
import utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, TestDataConfig.class })
@WebAppConfiguration
public class TestUserController {

	protected EntityManager em;
	@Resource
	private EntityManagerFactory emf;
	
	@Autowired
	private WebApplicationContext context;

	@Resource
	private ImageUserService imageUserService;

	@Resource
	private ImageService imageService;

	private MockMvc mvc;
	
	private ImageUser user;
	
	private UserDTO userDTO;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		userDTO = createNewUserAccount();
		try {
			user = imageUserService.registerNewUserAccount(userDTO);
		} catch (EmailExistsException e) {
			user = imageUserService.findByEmail(userDTO.getEmail());
		}
	}
	
	private UserDTO createNewUserAccount() {
		userDTO = new UserDTO();
		userDTO.setEmail("d1mqn1ch@mail.ru");
		userDTO.setUsername("Rizhi_KotE");
		userDTO.setPassword("11111");
		userDTO.setMatchingPassword("11111");
		return userDTO;
	}

	private Image createImage() {
		Image image = new Image();
		image.setName(TestUtils.getRandomString(5));
		return image;
	}

	private List<Image> createImages() {
		int amount = TestUtils.getRandomInteger(5);
		List<Image> images = new ArrayList<>(amount);
		for (int i = 0; i < amount; i++) {
			images.add(createImage());
		}
		return images;
	}
	
	private ImageUser setUsersDetails(ImageUser user) {
		Person person = TestUtils.getRandomPerson();
		user.setUsername(person.username());
		user.setPassword(person.password());
		user.setEmail(person.email());
		user.setRole(1);
		return user;
	}

	private ImageUser createUser() {
		ImageUser user = new ImageUser();
		user = setUsersDetails(user);
		List<Image> images = createImages();
		user.setImages(images);
		return user;
	}

	@Test
	public void getAnonimousUserPage() throws Exception{
		MockHttpServletRequestBuilder builder = get("/user/").with(anonymous());
		MvcResult result = mvc
			.perform(builder)
			.andDo(print())
			.andExpect(unauthenticated())
			.andExpect(redirectedUrlPattern("**/login"))
			.andReturn();
		System.out.println(builder);
		System.out.println(result);
	}
	
	@Test(expected = EmailExistsException.class)
	public void exceptionOldUserRegistration() throws Exception{
		imageUserService.registerNewUserAccount(userDTO);
	}
	
	@Test
	public void getUserPage() throws Exception{
		assertNotNull(user);
		MockHttpServletRequestBuilder builder = get("/user/").with(SecurityMockMvcRequestPostProcessors.user(user.getEmail()));
		MvcResult result = mvc
			.perform(builder).andDo(print()).andExpect(view().name("user/userPage")).andReturn();
		System.out.println(builder);
		System.out.println(result);
	}
	
	@Test
	public void getUserImages() throws Exception{
		MockHttpServletRequestBuilder builder = post("/user/gallery/images").with(SecurityMockMvcRequestPostProcessors.user(user.getEmail()));
		MvcResult result = mvc
			.perform(builder).andDo(print()).andReturn();
		System.out.println(builder);
		System.out.println(result);
	}
	
	@Test
	public void uploadImage() throws Exception{
		MockMultipartFile file = new MockMultipartFile("icon.png", new FileInputStream("test.png"));
		MockHttpServletRequestBuilder builder = fileUpload("/user/upload").file(file).contentType(MediaType.MULTIPART_FORM_DATA).content(file.getBytes()).with(SecurityMockMvcRequestPostProcessors.user(user.getEmail()));
		MvcResult result = null;
		try {
			result = mvc
				.perform(builder).andDo(print()).andExpect(status().isOk()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(builder);
		System.out.println(",kzlbyf");
		System.out.println(result.getRequest().getParameterMap());
		System.out.println(",kzlbyf");
		System.out.println(result.getResponse());
	}
}
