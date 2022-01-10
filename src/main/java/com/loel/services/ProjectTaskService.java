
package com.loel.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loel.domain.Backlog;
import com.loel.domain.ProjectTask;
import com.loel.exceptions.ProjectNotFoundException;
import com.loel.repositories.BacklogRepository;
import com.loel.repositories.ProjectRepository;
import com.loel.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	final Logger myLog = LogManager.getLogger(ProjectTaskService.class);
//	@Autowired
	private BacklogRepository backlogRepository;

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

//	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectService projectService;

	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask, String username) {

		// PTs to be added to a specific project, project != null, BL exists
		Backlog backlog = projectService.findProjectByIdentifier(projectIdentifier, username).getBacklog();
		// set the bl to pt
		myLog.info(backlog);
		projectTask.setBacklog(backlog);
		// we want our project sequence to be like this: IDPRO-1 IDPRO-2 ...100 101
		Integer backlogSequence = backlog.getPTSequence();
		// Update the BackLog SEQUENCE
		backlogSequence++;

		backlog.setPTSequence(backlogSequence);

		// Add Sequence to Project Task
		projectTask.setProjectSequence(backlog.getProjectIdentifier() + "-" + backlogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);

		// INITIAL status when status is null
		if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
			projectTask.setStatus("TO_DO");
		}

		// Fix bug with priority in Spring Boot Server, needs to check null first
		if (projectTask.getPriority() == null || projectTask.getPriority() == 0) { // In the future we need
																					// projectTask.getPriority()== 0 to
																					// handle the form
			projectTask.setPriority(3);
		}

		return projectTaskRepository.save(projectTask);
	}

	public Iterable<ProjectTask> findBacklogById(String id, String username) {

		projectService.findProjectByIdentifier(id, username);

		return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
	}

	public ProjectTask findPTByProjectSequence(String backlogId, String ptId, String username) {

		// make sure we are searching on an existing backlog
		projectService.findProjectByIdentifier(backlogId, username);

		// make sure that our task exists
		ProjectTask projectTask = projectTaskRepository.findByProjectSequence(ptId);

		if (projectTask == null) {
			throw new ProjectNotFoundException(
					"This Project Task '" + ptId + "' aren't the droids you are looking for");
		}

		// make sure that the backlog/project id in the path corresponds to the right
		// project
		if (!projectTask.getProjectIdentifier().equals(backlogId)) {
			throw new ProjectNotFoundException(
					"This Project Task '" + ptId + "' only exists in a different reality for Project: '" + backlogId);
		}

		return projectTask;
	}

	public ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlogId, String ptId,
			String username) {
		ProjectTask projectTask = findPTByProjectSequence(backlogId, ptId, username);

		projectTask = updatedTask;

		return projectTaskRepository.save(projectTask);
	}

	public void deletePTByProjectSequence(String backLogId, String ptId, String username) {
		ProjectTask projectTask = findPTByProjectSequence(backLogId, ptId, username);
		projectTaskRepository.delete(projectTask);
	}

}