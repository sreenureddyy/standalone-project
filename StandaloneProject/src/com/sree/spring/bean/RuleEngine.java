/**
 * 
 */
package com.sree.spring.bean;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.DecisionTableConfiguration;
import org.drools.builder.DecisionTableInputType;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.springframework.stereotype.Service;

/**
 * @author srinivasr
 *
 */
@Service("ruleEngine")
public class RuleEngine implements IRuleEngine{

	public KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		DecisionTableConfiguration config = KnowledgeBuilderFactory.newDecisionTableConfiguration();
		config.setInputType(DecisionTableInputType.XLS);
		kbuilder.add(ResourceFactory.newFileResource("C://Employee.xls"), ResourceType.DTABLE, config);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error: errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

}
