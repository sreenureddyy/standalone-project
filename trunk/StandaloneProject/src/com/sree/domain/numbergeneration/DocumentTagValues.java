/**
 * 
 */
package com.sree.domain.numbergeneration;

import com.sree.domain.BaseDomain;

/**
 * @author srinivasr
 * 
 */
public class DocumentTagValues extends BaseDomain {
	private Integer currentNum;

	private String tagValue;

	private Integer docTypeNum;

	private String numSchemeCode;

	public Integer getDocTypeNum() {
		return docTypeNum;
	}

	public void setDocTypeNum(Integer docTypeNum) {
		this.docTypeNum = docTypeNum;
	}

	public String getNumSchemeCode() {
		return numSchemeCode;
	}

	public void setNumSchemeCode(String numSchemeCode) {
		this.numSchemeCode = numSchemeCode;
	}

	public Integer getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(Integer currentNum) {
		this.currentNum = currentNum;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
}
