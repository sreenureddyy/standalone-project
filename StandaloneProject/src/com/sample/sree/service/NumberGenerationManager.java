package com.sample.sree.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sree.common.CommonConstants;
import com.sree.dao.BaseDao;
import com.sree.domain.BaseDomain;
import com.sree.domain.numbergeneration.DocumentNumberScheme;
import com.sree.domain.numbergeneration.DocumentNumberSchemeDetails;
import com.sree.domain.numbergeneration.DocumentTagDetails;
import com.sree.domain.numbergeneration.DocumentTagValues;
import com.sree.service.BaseService;

/**
 * This Class is used for generating the DocumentNumber based on the
 * format defined in the  NumberSchemeDetails such as prefix,suffix,paddedlength,resettag stored in database
 * 
 * 
 * @version 1.0
 * @author Dany Samuel
 * 
 */


public class NumberGenerationManager implements INumberGenerationManager {

	@Autowired
	private BaseDao baseDao;
	
	/*private INumberGenerationRepository repository;

	

	public INumberGenerationRepository getRepository() {
		return repository;
	}

	public void setRepository(INumberGenerationRepository repository) {
		this.repository = repository;
	}*/

	/* (non-Javadoc)
	 * @see com.sree.service.INumberGenerationManager#generateDocumentNumber(int, java.lang.String, com.sree.domain.BaseDomain, com.sree.service.BaseService)
	 */
	
	public void saveNumberScheme(DocumentNumberScheme scheme) {
		baseDao.save(scheme);
	}
	
	public synchronized String generateDocumentNumber(int documentType,
			String numberSchemeCode, BaseDomain obj, BaseService service) {

		String documentNo = "";
		int currentNumber = 0;
		String resetTagValue =null;
		String prefixValue="";
		String suffixValue="";

		List tags = null;
        List scheme=null;
		//Retreiving the NumberSchemeDetails such as prefix,suffix,paddedlength,resettag and ll
       scheme=baseDao.find(CommonConstants.DOCUMENTNUMBERSCHEMEDETAILS,new Object[]{documentType,
						numberSchemeCode});
        
        
        
        if(scheme.size()>0){
			DocumentNumberSchemeDetails details = (DocumentNumberSchemeDetails)scheme.get(0);
	
			prefixValue = details.getPrefix();
			suffixValue = details.getSuffix() != null ? details.getSuffix() : "";
			resetTagValue = details.getDocNumResetTags();
			
			
			//Finding the individual tags in ResetTag and evaluating them
			
			if (resetTagValue != null && resetTagValue.indexOf("<") > -1) {
				tags = getTags(resetTagValue);
				resetTagValue = getTagValues(tags, resetTagValue, obj);
	
			}
			
	
			//Finding the currentNumber for the ResetTagValue
	
			if (resetTagValue != null) {
				currentNumber = getCurrentNumberFromResetTagValue(
						numberSchemeCode, resetTagValue,documentType);
						
			} else {
				resetTagValue = "Default";
				currentNumber = getCurrentNumberFromResetTagValue(
						numberSchemeCode, resetTagValue,documentType);
				System.out.println("currentNumber  ---------------->>> "+currentNumber);
	
			}
			if (currentNumber < 0) {
				currentNumber = 0;
			}
			currentNumber = currentNumber + 1;
	
			//Finding the individual tags in prefix and evaluating them
			if (prefixValue != null && prefixValue.indexOf("<") > -1) {
				tags = getTags(prefixValue);
				prefixValue = getTagValues(tags, prefixValue, obj);
			}
	
			//Finding the individual tags in suffix and evaluating them
			if (suffixValue.indexOf("<") > -1) {
				if (tags != null) {
					tags.clear();
				}
				tags = getTags(suffixValue);
				suffixValue = getTagValues(tags, suffixValue, obj);
			}
	
			//Generating the document Number 
			
			documentNo = generate(prefixValue, suffixValue, details
					.getPaddedLength(), currentNumber);
			updateCurrentValue(numberSchemeCode, documentType, resetTagValue,
					currentNumber);
        }
		return documentNo;

	}

	private void updateCurrentValue(String numberSchemeCode,
			int documentType, String resetTagValue, int currentNumber) {
		
		
		
		DocumentTagValues tagValue;
		List value = null;
		
		if ((resetTagValue != null)&&(resetTagValue!="")) {
				
			value = baseDao
					.find(
							"DocumentTagValueDetails",
							new Object[] {numberSchemeCode,resetTagValue,documentType });
		} else {
			
			System.out.println("resetTagValue is Default with "+numberSchemeCode +""+resetTagValue);
			resetTagValue = "Default";
			value = baseDao
					.find(
							"DocumentTagValueDetails",
							new Object[] {numberSchemeCode,resetTagValue,documentType });
			
		}

		if (value.size() > 0) {
			tagValue = (DocumentTagValues) value.get(0);
			tagValue.setCurrentNum(currentNumber);
		} else {
			tagValue = new DocumentTagValues();
			tagValue.setTagValue(resetTagValue);
			tagValue.setCurrentNum(currentNumber);
			tagValue.setDocTypeNum(documentType);
			tagValue.setNumSchemeCode(numberSchemeCode);
		}
		saveDocumentTagValue(tagValue);
	}

	private void saveDocumentTagValue(DocumentTagValues values) {
		// TODO Auto-generated method stub
		baseDao.save(values);
	}

	//For extracting individual tags from the passed tagString
	private List getTags(String tagString) {
		List tags = new ArrayList();
		int len = 0;
		String substr = "";
		while (len <= tagString.length()) {
			substr = tagString.substring(tagString.indexOf("<") + 1, tagString
					.indexOf(">"));
			tags.add(substr);
			tagString = tagString.replace("<" + substr + ">", "");
			if (tagString.length() <= 0 || tagString.indexOf("<") == -1) {
				break;
			}
			len = tagString.length();
		}
		return tags;
	}

	//For evaluating the tags passed as a list and returning the actual tagValue
	private String getTagValues(List tags, String actualTag,
			BaseDomain obj) {

		String tagValue = "";
		List tagInfo;

		for (Object tag : tags) {
			tagInfo = baseDao.find("DocumentTagExpressionDetails",
					new Object[] { tag.toString() });
			if (tagInfo.size() > 0) {
				DocumentTagDetails tagDet = (DocumentTagDetails) tagInfo.get(0);
				tagValue = evaluateString(tagDet, obj);
			}
			actualTag = actualTag.replaceAll("<" + tag.toString() + ">", tagValue);
		}
		return actualTag;

	}

	private String generate(String prefixValue, String suffix,
			int paddedLength, int currentNumber) {

		String docNo;
		String paddedNo = "";
		String number = String.valueOf(currentNumber);
		if (paddedLength < number.length()) {
			docNo = prefixValue + number + suffix;
		} else {
			for (int i = 0; i < (paddedLength - number.length()); i++) {
				paddedNo = paddedNo + "0";

			}
			docNo = prefixValue + paddedNo + number + suffix;

		}
		System.out.println("*********************************");
		System.out.println("Document No ---------------> " + docNo);
		System.out.println("*********************************");
		return docNo;

	}

	private int getCurrentNumberFromResetTagValue(String numberSchemeCode,
			String resetTagValue, int documentType) {
		// TODO Auto-generated method stub

		int currentNumber = -1;
		DocumentTagValues tag = null;
		
		List tagValues = baseDao.find("DocumentTagValueDetails",
				new Object[] {numberSchemeCode, resetTagValue,documentType });
		if (tagValues.size() > 0) {
			tag = (DocumentTagValues) tagValues.get(0);
			currentNumber = tag.getCurrentNum();
		}
		return currentNumber;
	}

	private String evaluateString(DocumentTagDetails tagDet,
			BaseDomain obj) {

		String value = "";
		String expression = "";

		expression = tagDet.getExpression();
//		exprValue = exprValue.substring(exprValue.indexOf(".") + 1, exprValue
//				.length());
		
		StringTokenizer stk=new StringTokenizer(expression,".");
		while(stk.hasMoreTokens()){
			expression=stk.nextToken();
		}
		if (tagDet.getExpression().startsWith("SESSION")) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			if (ctx.getExternalContext().getSessionMap().containsKey(expression)) {
				value = ctx.getExternalContext().getSessionMap().get(expression)
						.toString();
		}}
		else if (tagDet.getExpression().startsWith("GENERAL")) {
			
			Calendar cal=new GregorianCalendar();
			
			if (expression.equals("CURRENTMONTH")) {
				value = String.valueOf(cal.get(Calendar.MONTH)+1);
			} else if (expression.equals("CURRENTYEAR")) {
				value = String.valueOf(cal.get(Calendar.YEAR));
			} else if (expression.equals("CURRENTDAY")) {
				value = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			}
		} else if (tagDet.getExpression().startsWith("DOMAINOBJECT")) {
			Method meth = null;
			try {
				meth = obj.getClass().getMethod(expression, null);
				Object object = meth.invoke(obj, null);
				value = value + object.toString();
    		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  	 else {
			value = expression;
		}
	return value;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}



}
