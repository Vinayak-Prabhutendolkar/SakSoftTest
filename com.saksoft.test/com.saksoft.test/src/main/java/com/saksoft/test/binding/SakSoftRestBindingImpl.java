package com.saksoft.test.binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saksoft.test.BusinessError;
import com.saksoft.test.businessservice.SakSoftBusinessService;
import com.saksoft.test.datamodel.SakSoftRequestSchema;
import com.saksoft.test.datamodel.SakSoftResponseSchema;

@RestController
@RequestMapping("/person")
public class SakSoftRestBindingImpl implements SakSoftRestBinding {

	@Autowired
	private SakSoftBusinessService businessService;

	@Override
	public SakSoftResponseSchema getEntityById(SakSoftRequestSchema request) throws BusinessError {

		return businessService.getEntityById(request);
	}

	@Override
	public SakSoftResponseSchema getAll(SakSoftRequestSchema request) throws BusinessError {

		return businessService.getAll(request);
	}

	@Override
	public SakSoftResponseSchema addEntity(SakSoftRequestSchema request) throws BusinessError {

		return businessService.addEntity(request);
	}

	@Override
	public SakSoftResponseSchema updateEntity(SakSoftRequestSchema request) throws BusinessError {

		return businessService.updateEntity(request);
	}

	@Override
	public SakSoftResponseSchema deleteEntity(SakSoftRequestSchema request) throws BusinessError {

		return businessService.deleteEntity(request);
	}

}
