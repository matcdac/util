package util;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExceptionLogUtil {

	JsonUtil<GenericException> jsonUtil = new JsonUtil<GenericException>();

	public ExceptionLogUtil() {

	}

	private GenericException getGenericException(Exception e, String customMessage) {
		if (null != customMessage && !customMessage.trim().isEmpty()) {
			return new GenericException(e, customMessage);
		} else {
			return new GenericException(e);
		}
	}

	public void logException(Exception e, String customMessage) {
		log.error(jsonUtil.convertObjectToJson(getGenericException(e, customMessage)));
	}

	public String getLocalizedExceptionJson(Exception e, String customMessage) {
		return jsonUtil.convertObjectToJson(getGenericException(e, customMessage));
	}

}
