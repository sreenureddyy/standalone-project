package com.sree.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Parent_ID")
	private Long id;
	
	@OneToMany(mappedBy = "parent")
	private List<Child> children;

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}
}