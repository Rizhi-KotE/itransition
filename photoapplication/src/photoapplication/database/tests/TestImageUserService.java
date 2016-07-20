package photoapplication.database.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.codearte.jfairy.producer.person.Person;
import photoapplication.database.config.TestDataBaseConfig;
import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;
import photoapplication.database.service.ImageService;
import photoapplication.database.service.ImageUserService;
import utils.TestUtils;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
public class TestImageUserService {

	protected EntityManager em;
	@Resource
	private EntityManagerFactory emf;

	@Resource
	private ImageUserService imageUserService;

	@Resource
	private ImageService imageService;

	private List<ImageUser> users = new ArrayList<>();

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

	private List<ImageUser> createListOfUsers(int amount) {
		List<ImageUser> users = new ArrayList<>(amount);
		for (int i = 0; i < amount; i++) {
			users.add(createUser());
		}
		return users;
	}

	private ImageUser createUser() {
		ImageUser user = new ImageUser();
		Person person = TestUtils.getRandomPerson();
		user.setName(person.username());
		List<Image> images = createImages();
		user.setImages(images);
		return user;
	}

	@Test
	public void getImage() throws Exception {

	}

	@Test
	public void saveImage() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		users = createListOfUsers(3);
	}

	@Test
	public void testInitializing() throws Exception {

	}

	@Test
	public void testSaveUser() throws Exception {
		ImageUser user = createUser();
		ImageUser savedUser = imageUserService.addUser(user);
		assertEquals(savedUser, user);
	}

	@Test
	public void testUserEquals() throws Exception {
		ImageUser user1 = new ImageUser();
		ImageUser user2 = new ImageUser();
		String name = TestUtils.getRandomIntegerString(5);
		long id = TestUtils.getRandomLong();
		user1.setName(name);
		user2.setName(name);
		user1.setId(id);
		user2.setId(id);
		assertEquals(user1, user2);
	}

	@Test
	public void testImageSave() throws Exception {
		Image image = createImage();
		Image savedImage = imageService.addImage(image, new FileInputStream("test.png"));
		assertEquals(image, savedImage);
	}

	@Test
	public void testUserEqualsWith() throws Exception {
		ImageUser user1 = new ImageUser();
		ImageUser user2 = new ImageUser();
		String name = TestUtils.getRandomIntegerString(5);
		long id = TestUtils.getRandomLong();
		user1.setName(name);
		user2.setName(name);
		user1.setId(id);
		user2.setId(id);
		assertEquals(user1, user2);
	}

	@Test
	public void testWhithCustomQueryMethod() throws Exception {

	}
}
