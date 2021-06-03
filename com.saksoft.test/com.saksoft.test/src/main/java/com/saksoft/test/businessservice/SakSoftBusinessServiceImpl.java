package com.saksoft.test.businessservice;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoft.test.BusinessError;
import com.saksoft.test.SakSoftConstants;
import com.saksoft.test.databse.PersonEntity;
import com.saksoft.test.databse.PersonEntityJPAEntity;
import com.saksoft.test.datamapper.SakSoftDataMapper;
import com.saksoft.test.datamodel.PersonInformation;
import com.saksoft.test.datamodel.SakSoftRequestSchema;
import com.saksoft.test.datamodel.SakSoftResponseSchema;

@Service
public class SakSoftBusinessServiceImpl implements SakSoftBusinessService {

	@Autowired
	private PersonEntityJPAEntity personJPA;
	@Autowired
	private SakSoftDataMapper dataMapper;

	@Override
	public SakSoftResponseSchema getAll(SakSoftRequestSchema sakSoftRequestSchema) throws BusinessError {

		List<PersonEntity> findAll = personJPA.findAll();
		SakSoftResponseSchema sakSoftResponseSchema = dataMapper.createSakSoftResponse(findAll, null, null,
				sakSoftRequestSchema, SakSoftConstants.GETALL);

		return sakSoftResponseSchema;
	}

	@Override
	public SakSoftResponseSchema getEntityById(SakSoftRequestSchema sakSoftRequestSchema) throws BusinessError {

		validateRequest(sakSoftRequestSchema, SakSoftConstants.GETENTITYBYID);
		List<PersonInformation> personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
				.getPersonInformation();
		int id = personInformation.get(0).getId();
		Optional<PersonEntity> personEntity = personJPA.findById(id);
		SakSoftResponseSchema sakSoftResponseSchema = dataMapper.createSakSoftResponse(null, personEntity, null,
				sakSoftRequestSchema, SakSoftConstants.GETENTITYBYID);

		return sakSoftResponseSchema;
	}

	@Override
	public SakSoftResponseSchema addEntity(SakSoftRequestSchema sakSoftRequestSchema) throws BusinessError {

		validateRequest(sakSoftRequestSchema, SakSoftConstants.ADD);
		PersonEntity personEntity = dataMapper.addRequest(sakSoftRequestSchema);
		personJPA.save(personEntity);
		SakSoftResponseSchema sakSoftResponseSchema = dataMapper.createSakSoftResponse(null, null, personEntity,
				sakSoftRequestSchema, SakSoftConstants.ADD);

		return sakSoftResponseSchema;
	}

	@Override
	public SakSoftResponseSchema updateEntity(SakSoftRequestSchema sakSoftRequestSchema) throws BusinessError {

		validateRequest(sakSoftRequestSchema, SakSoftConstants.UPDATE);
		Optional<PersonEntity> entity = personJPA.findById(
				sakSoftRequestSchema.getSakSoftRequest().getIndividual().getPersonInformation().get(0).getId());
		validateRequest(sakSoftRequestSchema, SakSoftConstants.GETENTITYBYID_UPDATE);
		PersonEntity personEntity = dataMapper.updateRequest(sakSoftRequestSchema, entity.get());
		personJPA.save(personEntity);
		SakSoftResponseSchema sakSoftResponseSchema = dataMapper.createSakSoftResponse(null, null, personEntity,
				sakSoftRequestSchema, SakSoftConstants.UPDATE);
		return sakSoftResponseSchema;
	}

	@Override
	public SakSoftResponseSchema deleteEntity(SakSoftRequestSchema sakSoftRequestSchema) throws BusinessError {
		
		validateRequest(sakSoftRequestSchema, SakSoftConstants.DELETE);
	    getEntityById(sakSoftRequestSchema);
		List<PersonInformation> personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
				.getPersonInformation();
		int id = personInformation.get(0).getId();
		personJPA.deleteById(id);
		SakSoftResponseSchema sakSoftResponseSchema = dataMapper.createSakSoftResponse(null, null, null,
				sakSoftRequestSchema, SakSoftConstants.DELETE);
		
		return sakSoftResponseSchema;
	}
	
	
	private void validateRequest(SakSoftRequestSchema sakSoftRequestSchema, String operation) throws BusinessError {

		if ((!operation.isEmpty()) && operation.equals(SakSoftConstants.GETENTITYBYID)) {

			List<PersonInformation> personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
					.getPersonInformation();
			int id = personInformation.get(0).getId();
			if (String.valueOf(id).isBlank() || id == 0) {
				if (operation.equals(SakSoftConstants.GETENTITYBYID)) {
					throw new BusinessError(SakSoftConstants.FAILED, "Id cannot be blank");
				} else if (operation.equals(SakSoftConstants.GETENTITYBYID_UPDATE)) {
					throw new BusinessError(SakSoftConstants.FAILED, "No records found");
				}
			}

		} else if ((!operation.isEmpty()) && operation.equals(SakSoftConstants.ADD)) {

			StringJoiner errMsg = new StringJoiner(",");
			Boolean errorFlag = false;
			List<PersonInformation> personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
					.getPersonInformation();
			PersonInformation entity = personInformation.get(0);
			if (entity.getId() != 0) {
				throw new BusinessError(SakSoftConstants.FAILED, "Invalid parameter: Id");
			}
			if (entity.getEmail().isBlank()) {
				errorFlag = true;
				errMsg.add("Email");
			}
			if (entity.getFirstName().isBlank()) {
				errorFlag = true;
				errMsg.add("First Name");
			}
			if (entity.getLastName().isBlank()) {
				errorFlag = true;
				errMsg.add("Last Name");
			}
			if (entity.getEmail().isBlank()) {
				errorFlag = true;
				errMsg.add("Last Name");
			}
			if (String.valueOf(entity.getAge()).isBlank() || entity.getAge() == 0) {
				errorFlag = true;
				errMsg.add("Age");
			}

			if (errorFlag == true) {
				throw new BusinessError(SakSoftConstants.FAILED, "Mentioned parameters cannot be empty : " + errMsg.toString());
			}
		}
		else if ((!operation.isEmpty()) && operation.equals(SakSoftConstants.UPDATE)) {

			List<PersonInformation> personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
					.getPersonInformation();
			int id = personInformation.get(0).getId();
			if (String.valueOf(id).isBlank() || id == 0) {
				throw new BusinessError(SakSoftConstants.FAILED, "Id cannot be blank");
			}

		}
		else if ((!operation.isEmpty()) && operation.equals(SakSoftConstants.DELETE)) {

			List<PersonInformation> personInformation = sakSoftRequestSchema.getSakSoftRequest().getIndividual()
					.getPersonInformation();
			int id = personInformation.get(0).getId();
			if (String.valueOf(id).isBlank() || id == 0) {
				throw new BusinessError(SakSoftConstants.FAILED, "Id cannot be blank");
				
			}

		}

	}

	

}
