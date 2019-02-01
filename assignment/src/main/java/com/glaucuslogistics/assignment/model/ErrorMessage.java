package com.glaucuslogistics.assignment.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO File for showing exceptions as 
 * JSON Objects
 * @author broth
 *
 */
@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	/**
	 *	Constructor to construct an ErrorMessage POJO File 
	 * @param errorMessage The error that occurred
	 * @param errorCode	The error status code
	 * @param documentation Further links for corresponding error
	 */
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
}
