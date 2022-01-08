package com.loel;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.loel.domain.Project;
import com.loel.repositories.ProjectRepository;
import com.loel.services.ProjectService;

@SpringBootTest
public class ProjectServiceTests {

	@Autowired
	ProjectService projectServiceTest;

	@Autowired
	ProjectRepository projectRepositoryTest;

	@Test
	public void findAllProjectTest() {
		Random rnd = new Random();
		int i = rnd.nextInt(99);
		long testProjId = i;
		Project project1 = new Project();
		project1.setId(testProjId);
		project1.setProjectName("Mock Proj " + i);
		project1.setProjectIdentifier("MOCK" + i);
		project1.setDescription("Mock project" + i + "description");

	}
}