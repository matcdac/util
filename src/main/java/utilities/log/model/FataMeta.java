package utilities.log.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class FataMeta implements Serializable {

	private static final long serialVersionUID = 1;

	private String classType;
	private String message;
	private Throwable cause;

	public FataMeta() {

	}

	public FataMeta(String classType, String message, Throwable cause) {
		this.classType = classType;
		this.message = message;
		this.cause = cause;
	}

}
