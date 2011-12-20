package com.sree.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	// the index column is mapped as a property in the associated entity

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Child_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = false)
	private Parent parent;

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
}