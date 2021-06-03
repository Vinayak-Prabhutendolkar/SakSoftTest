package com.saksoft.test.datamodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Individual {
	
	private List<PersonInformation> personInformation;

	public List<PersonInformation> getPersonInformation() {
		return personInformation;
	}

	public void setPersonInformation(List<PersonInformation> personInformation) {
		this.personInformation = personInformation;
	}
	
	
}
