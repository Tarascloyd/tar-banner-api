package com.taras.tarbannerapi.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Where(clause = "deleted = false")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="name", unique = true)
	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, max = 255, message
			= "Name must be between 2 and 255 characters")
	private String name;

	@Column(name="req_name", unique = true)
	@NotBlank(message = "Request ID is mandatory")
	@Size(min = 2, max = 255, message
			= "Request ID must be between 2 and 255 characters")
	private String reqName;

	@Column(name="deleted")
	private boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
