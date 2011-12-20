/**
 * 
 */
package com.sree.exam;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sree.domain.BaseDomain;

/**
 * @author srinivasr
 * 
 */
@Entity
@Table(name = "SUBJECT")
@SuppressWarnings("serial")
public class Subject extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBJECT_ID")
	private Long id;

	@Column(name = "SUBJECT")
	private String subject;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "SUBJECT_ID")
	private List<Book> reference = new ArrayList<Book>();

	@ManyToOne
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course = new Course();

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Book> getReference() {
		return reference;
	}

	public void setReference(List<Book> reference) {
		this.reference = reference;
	}

}
