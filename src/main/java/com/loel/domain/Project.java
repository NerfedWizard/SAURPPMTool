package com.loel.domain;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Proxy(lazy = false)
@Entity
@NoArgsConstructor
@Data
@ApiModel(description = "Details about current Projects")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(notes = "The Unique ID of the Project")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes = "The Project Name")
	@NotBlank(message = "How will you know the Project wihout a Name")
	private String projectName;
	@ApiModelProperty(notes = "Unique Project Identifier")
	@NotBlank(message = "Can't read minds so we need a Project Identifier")
	@Size(min = 4, max = 5, message = "Must be 4 or 5 characters big shooter!")
	@Column(updatable = false, unique = true)
	private String projectIdentifier;
	@NotBlank(message = "You need to give your Project a Description Buddy!")
	@ApiModelProperty(notes = "Description of the Current Project")
	private String description;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(updatable = false)
	@ApiModelProperty(notes = "When Project Was Created")
	private Date createdAt;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@ApiModelProperty(notes = "When the last Update Occured")
	private Date updatedAt;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "project")
	@JsonIgnore
	private Backlog backlog;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	private String projectLeader;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}