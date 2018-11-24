package utilities.log;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import utilities.json.JsonUtil;
import utilities.log.model.GenericException;

@Slf4j
@Component
public class LogUtil {

	JsonUtil<GenericException> medlifeJsonUtil = new JsonUtil<GenericException>();

	public void logException(Exception e) {
		GenericException genericException = new GenericException(e);
		log.error(medlifeJsonUtil.convertObjectToJson(genericException));
	}

	public String getLocalizedExceptionJson(Exception e) {
		GenericException genericException = new GenericException(e);
		return medlifeJsonUtil.convertObjectToJson(genericException);
	}

}
