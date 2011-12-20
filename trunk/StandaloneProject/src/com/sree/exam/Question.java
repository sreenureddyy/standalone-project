/**
 * 
 */
package com.sree.exam;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sree.domain.BaseDomain;

/**
 * @author srinivasr
 * 
 */
@Entity
@Table(name = "QUESTION")
@AttributeOverrides( {
		@AttributeOverride(name = "createdBy", column = @Column(name = "PREPARED_BY")),
		@AttributeOverride(name = "createdDatetime", column = @Column(name = "PREPARED_DATE")) })
@SuppressWarnings("serial")
public class Question extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QUESTION_ID")
	private Long id;

	@Column(name = "QUESTION_TYPE")
	private Long questionType;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "QUESTION_FROM")
	private String questionForm;

	@Column(name = "COMPLEXITY")
	private Long complexity;

	@Column(name = "STATUS")
	private Boolean status = true;

	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID", nullable = false)
	private Subject subject = new Subject();

	@ManyToOne
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course = new Course();

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getQuestionForm() {
		return questionForm;
	}

	public void setQuestionForm(String questionForm) {
		this.questionForm = questionForm;
	}

	public Long getComplexity() {
		return complexity;
	}

	public void setComplexity(Long complexity) {
		this.complexity = complexity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Long questionType) {
		this.questionType = questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
