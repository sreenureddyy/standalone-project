package com.sample.sree.service;

import com.sree.domain.BaseDomain;
import com.sree.domain.numbergeneration.DocumentNumberScheme;
import com.sree.service.BaseService;

public interface INumberGenerationManager {

	public abstract void saveNumberScheme(DocumentNumberScheme scheme);

	public abstract String generateDocumentNumber(int documentType,
			String numberSchemeCode, BaseDomain obj, BaseService service);

}