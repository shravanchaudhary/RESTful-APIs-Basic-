package com.glaucuslogistics.assignment.exception;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.glaucuslogistics.assignment.model.ErrorMessage;

/**
 * Catches generic Exceptions
 * @author Shravan
 *
 */

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	@Override	
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),500,"Shravanchaudhary.github.io");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
		throw new InternalServerErrorException(response);
	}
	
}
