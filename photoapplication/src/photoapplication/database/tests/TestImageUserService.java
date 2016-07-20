package photoapplication.database.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.codearte.jfairy.producer.person.Person;
import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;
import photoapplication.database.service.ImageService;
import photoapplication.database.service.ImageUserService;
import utils.TestUtils;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
public class TestImageUserService {

	protected EntityManager em;
	@Resource
	private EntityManagerFactory emf;

	@Resource
	private ImageUserService imageUserService;

	@Resource
	private ImageService imageService;

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

	private ImageUser createUser() {
		ImageUser user = new ImageUser();
		user = setUsersDetails(user);
		List<Image> images = createImages();
		user.setImages(images);
		return user;
	}

	private ImageUser setUsersDetails(ImageUser user) {
		Person person = TestUtils.getRandomPerson();
		user.setUsername(person.username());
		user.setFirstName(person.firstName());
		user.setLastName(person.lastName());
		user.setPassword(TestUtils.getRandomString(10));
		return user;
	}

	@Test
	public void getImage() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
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
		user1.setUsername(name);
		user2.setUsername(name);
		user1.setId(id);
		user2.setId(id);
		assertEquals(user1, user2);
	}

	@Test
	public void testImageSave() throws Exception {
		Image image = createImage();
		Image savedImage = imageService.addImage(image, new File("test.png"));
		assertEquals(image, savedImage);
	}

	@Test
	public void testFindByUsername() throws Exception {
		ImageUser user = createUser();
		String username = user.getUsername();
		imageUserService.addUser(user);
		ImageUser gettedUser = imageUserService.findByUserName(username);
		extendsAssertEquals(user, gettedUser);
	}

	private void extendsAssertEquals(ImageUser user, ImageUser gettedUser) throws Exception {
		assertNotNullEquals(user, gettedUser);
		assertNotNullEquals(user.getUsername(), gettedUser.getUsername());
		assertNotNullEquals(user.getFirstName(), gettedUser.getFirstName());
		assertNotNullEquals(user.getLastName(), gettedUser.getLastName());
		assertNotNullEquals(user.getPassword(), gettedUser.getPassword());
	}

	private void assertNotNullEquals(Object user1, Object user2) {
		assertNotNull(user1);
		assertNotNull(user2);
		assertEquals(user1, user2);
	}

	@Test
	public void testUserEqualsWith() throws Exception {
		ImageUser user1 = new ImageUser();
		ImageUser user2 = new ImageUser();
		String name = TestUtils.getRandomIntegerString(5);
		long id = TestUtils.getRandomLong();
		user1.setUsername(name);
		user2.setUsername(name);
		user1.setId(id);
		user2.setId(id);
		assertEquals(user1, user2);
	}
}
