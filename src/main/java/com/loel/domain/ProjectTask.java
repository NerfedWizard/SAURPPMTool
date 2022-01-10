package com.loel.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Proxy(lazy = false)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false, unique = true)
	private String projectSequence;
	@ApiModelProperty(notes = "Summary of the ProjectTask")
	@NotBlank(message = "Not asking a lot but a simple Summary of Project")
	private String summary;
	private String acceptanceCriteria;
	private String status;
	private Integer priority;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@ApiModelProperty(notes = "When ProjectTask is Due")
	@Future(message = "Due date must be in the future")
	private Date dueDate;
	// ManyToOne with Backlog
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "backlog_id", updatable = false, nullable = false)
	@JsonIgnore
	private Backlog backlog;

	@Column(updatable = false)
	private String projectIdentifier;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date create_at;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date update_At;

	@PrePersist
	protected void onCreate() {
		this.create_at = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.update_At = new Date();
	}
}
