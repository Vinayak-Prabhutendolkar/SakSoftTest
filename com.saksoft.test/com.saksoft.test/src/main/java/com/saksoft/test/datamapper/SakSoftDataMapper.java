package com.saksoft.test.datamapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.saksoft.test.BusinessError;
import com.saksoft.test.SakSoftConstants;
import com.saksoft.test.databse.PersonEntity;
import com.saksoft.test.datamodel.Individual;
import com.saksoft.test.datamodel.PersonInformation;
import com.saksoft.test.datamodel.Response;
import com.saksoft.test.datamodel.SakSoftRequestSchema;
import com.saksoft.test.datamodel.SakSoftResponse;
import com.saksoft.test.datamodel.SakSoftResponseSchema;

@Component
public class SakSoftDataMapper {

	public SakSoftResponseSchema createSakSoftResponse(List<PersonEntity> findAll, Optional<PersonEntity> personEntity,
			PersonEntity personEnt, SakSoftRequestSchema sakSoftRequestSchema, String operationName)
			throws BusinessError {

		SakSoftResponseSchema sakSoftResponseSchema = new SakSoftResponseSchema();
		SakSoftResponse sakSoftResponse = new SakSoftResponse();
		Individual individual = new Individual();
		List<PersonInformation> informations = new ArrayList<>();
		Response response = new Response();

		if (!(operationName.isEmpty()) && operationName.equals(SakSoftConstants.GETALL)) {

			if (findAll.isEmpty()) {
				throw new BusinessError(SakSoftConstants.FAILED, "No records found");
			}

			for (PersonEntity entity : findAll) {

				PersonInformation personInformation = new PersonInformation();

				personInformation.setId(entity.getId());
				personInformation.setAge(entity.getAge());
				personInformation.setEmail(entity.getEmailId());
				personInformation.setFirstName(entity.getFirtsName());
				personInformation.setLastName(entity.getLastName());
				informations.add(personInformation);

			}

			response.setStatus(SakSoftConstants.SUCCESS);
			response.setErrorMsg("Data fetch successfully");

		}

		else if (!(operationName.isEmpty()) && operationName.equals("GETENTITYBYID")) {

			if (personEntity.isEmpty()) {
				throw new BusinessError(SakSoftConstants.SUCCESS, "No record found");
			}
			PersonEntity entity = personEntity.get();
			PersonInformation personInformation = new PersonInformation();

			personInformation.setId(entity.getId());
			personInformation.setAge(entity.getAge());
			personInformation.setEmail(entity.getEmailId());
			personInformation.setFirstName(entity.getFirtsName());
			personInformation.setLastName(entity.getLastName());
			informations.add(personInformation);

			response.setStatus(SakSoftConstants.SUCCESS);
			response.setErrorMsg("Data fetch successfully");

		}

		else if (!(operationName.isEmpty()) && operationName.equals(SakSoftConstants.ADD)) {
			PersonInformation entity = sakSoftRequestSchema.getSakSoftRequest().getIndividual().getPersonInformation()
					.get(0);
			PersonInformation personInformation = new PersonInformation();
			personInformation = entity;
			personInformation.setId(personEnt.getId());
			informations.add(personInformation);

			response.setStatus(SakSoftConstants.SUCCESS);
			response.setErrorMsg("Entity Addded successfully");

		}
		
		else if (!(operationName.isEmpty()) && operationName.equals(SakSoftConstants.UPDATE)) {

			informations.add(sakSoftRequestSchema.getSakSoftRequest().getIndividual().getPersonInformation().get(0));
			response.setStatus(SakSoftConstants.SUCCESS);
			response.setErrorMsg("Entity updated successfully");

		}
		else if (!(operationName.isEmpty()) && operationName.equals(SakSoftConstants.DELETE)) {

			
			response.setStatus(SakSoftConstants.SUCCESS);
			response.setErrorMsg("Entity deleted successfully");

		}

		individual.setPersonInformation(informations);
		sakSoftResponse.setIndividual(individual);
		sakSoftResponse.setHeader(sakSoftRequestSchema.getSakSoftRequest().getHeader());
		sakSoftResponse.setResponse(response);
		sakSoftResponseSchema.setSakSoftResponse(sakSoftResponse);

		return sakSoftResponseSchema;

	}

	public PersonEntity addRequest(SakSoftRequestSchema sakSoftRequestSchema) {

		PersonEntity personEntity = new PersonEntity();
		PersonInformation personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
				.getPersonInformation().get(0);
		personEntity.setAge(personInformation.getAge());
		personEntity.setEmailId(personInformation.getEmail());
		personEntity.setFirtsName(personInformation.getFirstName());
		personEntity.setLastName(personInformation.getLastName());
		return personEntity;

	}

	public PersonEntity updateRequest(SakSoftRequestSchema sakSoftRequestSchema, PersonEntity personEntity) {

		PersonInformation personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
				.getPersonInformation().get(0);
		PersonEntity entity = new PersonEntity();
		
		
		entity.setId(personInformation.getId());
		if (personInformation.getEmail() == null) {
			entity.setEmailId(personEntity.getEmailId());
		}
		else {
			entity.setEmailId(personInformation.getEmail());
		}
		if (personInformation.getFirstName()== null) {
			entity.setFirtsName(personEntity.getFirtsName());
		}
		else {
			entity.setFirtsName(personInformation.getFirstName());
		}
		if (personInformation.getLastName()== null) {
			entity.setLastName(personEntity.getLastName());
		}
		else {
			entity.setLastName(personInformation.getLastName());
		}
		if (personInformation.getAge() == 0) {
			entity.setAge(personEntity.getAge());
		}
		else {
			entity.setAge(personInformation.getAge());
		}

		return entity;
	}

}
