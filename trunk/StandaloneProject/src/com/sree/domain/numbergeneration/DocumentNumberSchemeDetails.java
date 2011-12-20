/**
 * 
 */
package com.sree.domain.numbergeneration;

import com.sree.domain.BaseDomain;

/**
 * @author srinivasr
 * 
 */
public class DocumentNumberSchemeDetails extends BaseDomain {
	private String prefix;

	private String suffix;

	private String docNumResetTags;

	private Integer paddedLength;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getDocNumResetTags() {
		return docNumResetTags;
	}

	public void setDocNumResetTags(String docNumResetTags) {
		this.docNumResetTags = docNumResetTags;
	}

	public Integer getPaddedLength() {
		return paddedLength;
	}

	public void setPaddedLength(Integer paddedLength) {
		this.paddedLength = paddedLength;
	}
}
