package util;

import java.util.HashMap;
import java.util.Map;

public class GenericJsonUtil {

	private static Map<Class<?>, JsonUtil<?>> jsonUtilMapper;

	static {
		jsonUtilMapper = new HashMap<Class<?>, JsonUtil<?>>();
	}

	private static <T> void createJsonUtilMapper(Class<T> clazz) {
		JsonUtil<?> jsonUtil = new JsonUtil<T>();
		jsonUtilMapper.put(clazz, jsonUtil);
	}

	private static <T> JsonUtil<T> getJsonUtil(Class<T> clazz) {
		if (null == jsonUtilMapper.get(clazz)) {
			synchronized (GenericJsonUtil.class) {
				if (null == jsonUtilMapper.get(clazz)) {
					createJsonUtilMapper(clazz);
				}
			}
		}
		return (JsonUtil<T>) jsonUtilMapper.get(clazz);
	}

	public static <T> String convertObjectToJson(T object) {
		return ((JsonUtil<T>) getJsonUtil(object.getClass())).convertObjectToJson(object);
	}

	public static <T> T convertJsonToObject(String json, Class<T> clazz) {
		return ((JsonUtil<T>) getJsonUtil(clazz)).convertJsonToObject(json, clazz);
	}

}
