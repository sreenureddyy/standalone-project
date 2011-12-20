/**
 * 
 */
package com.sree.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

/**
 * @author srinivasr
 *
 */
@Service("testBean")
public class TestBean {
	String message;
	 
	public String getMessage() {
	  return message;
	}
 
	public void setMessage(String message) {
	  this.message = message;
	}
 
	@PostConstruct
	public void initIt() throws Exception {
	  System.out.println("Init method called......................");
	}
 
	@PreDestroy
	public void cleanUp() throws Exception {
	  System.out.println("Destroy method called.................");
	}
}
