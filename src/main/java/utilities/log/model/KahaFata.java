package utilities.log.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class KahaFata implements Serializable {

	private static final long serialVersionUID = 1;

	private String fileName;
	private String className;
	private String methodName;
	private int lineNumber;
	private boolean nativeMethod;

	public KahaFata() {

	}

	public KahaFata(StackTraceElement stackTraceElement) {
		fileName = stackTraceElement.getFileName();
		className = stackTraceElement.getClassName();
		methodName = stackTraceElement.getMethodName();
		lineNumber = stackTraceElement.getLineNumber();
		nativeMethod = stackTraceElement.isNativeMethod();
	}

}
