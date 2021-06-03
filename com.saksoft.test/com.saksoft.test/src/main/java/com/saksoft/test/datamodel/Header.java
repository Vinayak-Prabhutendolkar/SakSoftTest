package com.saksoft.test.datamodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Header {

	@JsonProperty("CorrelationId")
	private String correlationId;
	
	
	
}
