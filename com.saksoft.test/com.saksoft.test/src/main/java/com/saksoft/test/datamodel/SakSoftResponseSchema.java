package com.saksoft.test.datamodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SakSoftResponseSchema {

	@JsonProperty("SakSoftResponse")
	private SakSoftResponse sakSoftResponse;

	public SakSoftResponse getSakSoftResponse() {
		return sakSoftResponse;
	}

	public void setSakSoftResponse(SakSoftResponse sakSoftResponse) {
		this.sakSoftResponse = sakSoftResponse;
	}

}
