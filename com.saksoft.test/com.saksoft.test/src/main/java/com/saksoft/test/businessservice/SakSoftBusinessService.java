package com.saksoft.test.businessservice;

import com.saksoft.test.BusinessError;
import com.saksoft.test.datamodel.SakSoftRequestSchema;
import com.saksoft.test.datamodel.SakSoftResponseSchema;

public interface SakSoftBusinessService {
	
	public SakSoftResponseSchema getAll(SakSoftRequestSchema sakSoftRequestSchema)throws BusinessError ;

	public SakSoftResponseSchema getEntityById(SakSoftRequestSchema sakSoftRequestSchema)throws BusinessError;
	
	public SakSoftResponseSchema addEntity(SakSoftRequestSchema sakSoftRequestSchema)throws BusinessError;
	
	public SakSoftResponseSchema updateEntity(SakSoftRequestSchema sakSoftRequestSchema)throws BusinessError;

	public SakSoftResponseSchema deleteEntity(SakSoftRequestSchema sakSoftRequestSchema)throws BusinessError;;
}
