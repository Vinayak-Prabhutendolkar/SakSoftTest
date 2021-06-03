package com.saksoft.test.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SakSoftRequestSchema {

	@JsonProperty("SakSoftRequest")
	private SakSoftRequest sakSoftRequest;

	public SakSoftRequest getSakSoftRequest() {
		return sakSoftRequest;
	}

	public void setSakSoftRequest(SakSoftRequest sakSoftRequest) {
		this.sakSoftRequest = sakSoftRequest;
	}

}
