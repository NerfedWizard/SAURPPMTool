package com.loel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.loel.domain.User;
import com.loel.repositories.UserRepository;
import com.loel.services.UserService;

@SpringBootTest
class UserServiceTests {

	Random rand;
	@Autowired
	private UserService userServiceTest;

	@MockBean
	private UserRepository userRepositoryTest;

	@Test
	public void findAllUserTest() {
		int i = rInt();
		long userTestId = i;
		User testUser = new User();
		testUser.setId(userTestId);
		testUser.setUsername("Test@test.com" + i);
		testUser.setFullName("Test User");
		testUser.setPassword("password");

		when(userRepositoryTest.findAll()).thenReturn(Stream.of(testUser).collect(Collectors.toList()));

		Iterable<User> list = userServiceTest.findAll();

		for (User u : list) {
			System.out.println(u.getUsername());
		}

	}

	@Test
	public void saveUserTest() {
		int i = rInt();
		long userTestId = i;
		User testUser = new User();
		testUser.setId(userTestId);
		testUser.setUsername("Test@test.com" + i);
		testUser.setFullName("Test User");
		testUser.setPassword("password");

		when(userRepositoryTest.save(Mockito.any(User.class))).thenReturn(testUser);

		User u = userServiceTest.saveUser(testUser);

		assertEquals("Test@test.com" + i, u.getUsername());

	}

	private Integer rInt() {
		Integer i = rand.nextInt(99);
		return i;
	}

}
