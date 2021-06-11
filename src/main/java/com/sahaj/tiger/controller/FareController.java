package com.sahaj.tiger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahaj.tiger.model.JourneysRequest;
import com.sahaj.tiger.service.FareCalculatorService;
//This class exposes the API end points
@RestController
public class FareController {
	
	@Autowired
	FareCalculatorService fareCalcService;
	
	/**
	 * This method calculate the fare based on input journey
	 * @param request
	 * @return
	 */
	@PostMapping(path="/calculate",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> calculateFare(@RequestBody JourneysRequest request) {
		//return bad request response is request is null
		if(null == request)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok().body(fareCalcService.calculateFare(request.getJourneys()));
	}

}
