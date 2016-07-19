package photoapplication.database.tests;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import photoapplication.database.config.TestDataBaseConfig;
import photoapplication.database.service.ImageUserService;
import photoapplication.database.utils.ImageUserUtil;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class TestImageUserService {

	@Resource
	private EntityManagerFactory emf;
	protected EntityManager em;

	@Resource
	private ImageUserService imageUserService;

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@Test
	public void testInitializing() throws Exception {

	}
	
	@Test
	public void testWhithCustomQueryMethod() throws Exception {

	}

	@Test
	public void testSaveBank() throws Exception {
		imageUserService.addUser(ImageUserUtil.createImageUser());
	}
}
