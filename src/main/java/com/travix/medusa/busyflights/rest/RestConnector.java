package com.travix.medusa.busyflights.rest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
/**
 * Class to provide REST connection and response validation
 * @author Saquib Sayyad
 *
 */
public class RestConnector {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	Validator validator;
	
	protected <T, R extends T> T getForObject(String urlTemplate, Class<R> responseType, Object[] uriArguments) {
		R response = restTemplate.getForObject(urlTemplate, responseType, uriArguments);
		this.validateResponse(response);
		
		return response;
	}
	
	 protected <T> void validateResponse(T response) {
		Set<ConstraintViolation<T>> validationConstraints = this.validator.validate(response);

		if (validationConstraints.size() > 0) {
			List<String> errors = validationConstraints.stream().map(constraint -> constraint.getMessage())
					.collect(Collectors.toList());
			throw new ValidationException(errors.toString());
		}
	}

}
