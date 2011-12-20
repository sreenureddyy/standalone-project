package com.sree.spring.bean;

import org.drools.KnowledgeBase;

public interface IRuleEngine {

	public abstract KnowledgeBase readKnowledgeBase() throws Exception;

}