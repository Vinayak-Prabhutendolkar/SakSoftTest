package com.saksoft.test.binding;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.saksoft.test.BusinessError;
import com.saksoft.test.datamodel.Response;
import com.saksoft.test.datamodel.SakSoftResponse;
import com.saksoft.test.datamodel.SakSoftResponseSchema;

@ControllerAdvice
public class SakSoftGlobalException {
	
	@ExceptionHandler
	public ResponseEntity<SakSoftResponseSchema> handleException(BusinessError ex){
		
		SakSoftResponseSchema sakSoftResponseSchema = new SakSoftResponseSchema();
		SakSoftResponse sakSoftResponse = new SakSoftResponse();
		Response resp= new Response();
		resp.setStatus(ex.getStatus());
		resp.setErrorMsg(ex.getErrMsg());
		sakSoftResponse.setResponse(resp);
		sakSoftResponseSchema.setSakSoftResponse(sakSoftResponse);
		return new ResponseEntity<SakSoftResponseSchema>(sakSoftResponseSchema, HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler
	public ResponseEntity<SakSoftResponseSchema> handleException(Exception ex){
		
		SakSoftResponseSchema sakSoftResponseSchema = new SakSoftResponseSchema();
		SakSoftResponse sakSoftResponse = new SakSoftResponse();
		Response resp= new Response();
		resp.setStatus("FAILED");
		resp.setErrorMsg(ex.getMessage());
		sakSoftResponse.setResponse(resp);
		sakSoftResponseSchema.setSakSoftResponse(sakSoftResponse);
		return new ResponseEntity<SakSoftResponseSchema>(sakSoftResponseSchema, HttpStatus.NOT_FOUND);
		
	}
}
