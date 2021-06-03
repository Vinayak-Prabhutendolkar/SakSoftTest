package com.saksoft.test.binding;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.saksoft.test.BusinessError;
import com.saksoft.test.datamodel.SakSoftRequestSchema;
import com.saksoft.test.datamodel.SakSoftResponseSchema;

public interface SakSoftRestBinding {
    
	@PostMapping("/getEntityById")
	public SakSoftResponseSchema getEntityById(@RequestBody SakSoftRequestSchema request) throws BusinessError ;
    
	@PostMapping("/getAll")
	public SakSoftResponseSchema getAll(@RequestBody SakSoftRequestSchema request) throws BusinessError ;
	
	@PostMapping("/addEntity")
	public SakSoftResponseSchema addEntity(@RequestBody SakSoftRequestSchema request) throws BusinessError ;
	
	@PostMapping("/updateEntity")
	public SakSoftResponseSchema updateEntity(@RequestBody SakSoftRequestSchema request) throws BusinessError;
	
	@PostMapping("/deleteEntity")
	public SakSoftResponseSchema deleteEntity(@RequestBody SakSoftRequestSchema request)throws BusinessError;
	
	

}
