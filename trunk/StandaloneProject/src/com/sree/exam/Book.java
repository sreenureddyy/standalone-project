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
import javax.persistence.Table;

import com.sree.domain.BaseDomain;

/**
 * @author srinivasr
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "BOOK")
@AttributeOverrides( {
		@AttributeOverride(name = "createdBy", column = @Column(name = "AUTHOR")),
		@AttributeOverride(name = "createdDatetime", column = @Column(name = "PUBLISH_DATE")) })
public class Book extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Long id;

	private String title;

	private String subTitle;

	private String description;

	private String isbnCode;

	private Long noOfPages;

	private String edition;

	private String volume;

	// nature, medicine, engieering, science, physics, fiction
	private String subject;

	// Biography, Business
	private Long genre;

	// Book, Pdf, CD, Audio, Viedeo etc.,
	private Long bookType;

	private String language;

	private String location;

	private Integer quantity;

	// yearly monthly weely, daily
	private Integer subscriptionType;

	private Double price;

	private Boolean status;

	private Author author = new Author();

	private Publisher publisher = new Publisher();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public Long getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Long noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getGenre() {
		return genre;
	}

	public void setGenre(Long genre) {
		this.genre = genre;
	}

	public Long getBookType() {
		return bookType;
	}

	public void setBookType(Long bookType) {
		this.bookType = bookType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(Integer subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
