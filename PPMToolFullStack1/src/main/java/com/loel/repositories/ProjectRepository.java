<<<<<<< HEAD
package com.loel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loel.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	Project findByProjectIdentifier(String projectId);

	@Override
	Iterable<Project> findAll();

	Iterable<Project> findAllByProjectLeader(String username);
=======
package com.loel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loel.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	Project findByProjectIdentifier(String projectId);

	@Override
	Iterable<Project> findAll();

	Iterable<Project> findAllByProjectLeader(String username);
>>>>>>> bb5f7472f599139ed6a3b9bc2ea695cff829329c
}