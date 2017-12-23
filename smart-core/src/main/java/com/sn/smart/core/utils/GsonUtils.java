package com.sn.smart.core.utils;

import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * gson工具升级版
 * 
 * @author gxzhou2
 *
 */
public class GsonUtils {

	private static Gson gson;

	static {
		if (gson == null) {
			gson = new GsonBuilder().registerTypeAdapter(String.class, new TypeAdapter<String>() {
				@Override
				public void write(JsonWriter out, String value) throws IOException {
					if (value == null) {
						out.value(""); // 序列化时将 null 转为 ""
					} else {
						out.value(value);
					}
				}

				@Override
				public String read(JsonReader in) throws IOException {
					if (in.peek() == JsonToken.NULL) {
						in.nextNull();
						return null;
					}
					String str = in.nextString();
					if (str.equals("")) { // 反序列化时将 "" 转为 null
						return null;
					} else {
						return str;
					}
				}
			}).create();
		}
	}

	private GsonUtils() {
	}

	public static Gson getGson() {
		return gson;
	}

	/**
	 * 转成json
	 *
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		String gsonString = null;
		if (gson != null) {
			gsonString = gson.toJson(object);
		}
		return gsonString;
	}

	/**
	 * Gson串转成bean
	 *
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> T fromJson(String gsonString, Class<T> cls) {
		T t = null;
		if (gson != null) {
			t = gson.fromJson(gsonString, cls);
		}
		return t;
	}

	/**
	 * Gson串转成bean
	 *
	 * @param gsonString
	 * @param typeOfT
	 * @return
	 */
	public static <T> T fromJson(String gsonString, Type typeOfT) {
		T t = null;
		if (gson != null) {
			t = gson.fromJson(gsonString, typeOfT);
		}
		return t;
	}

	/**
	 * Object对象通过Gson转成 T 对象
	 *
	 * @param instance
	 * @param classOfT
	 * @param <T>
	 * @return
	 */
	public static <T> T convert(Object instance, Class<T> classOfT) {
		if (instance == null || classOfT == null) {
			return null;
		}
		String jsonStr = toJson(instance);
		if (jsonStr == null) {
			return null;
		}
		return gson.fromJson(jsonStr, classOfT);
	}

	/**
	 * Object对象通过Gson转成 T 对象
	 *
	 * @param instance
	 * @param typeOfT
	 * @param <T>
	 * @return
	 */
	public static <T> T convert(Object instance, Type typeOfT) {
		if (instance == null || typeOfT == null) {
			return null;
		}
		String jsonStr = toJson(instance);
		if (jsonStr == null) {
			return null;
		}
		return gson.fromJson(jsonStr, typeOfT);
	}

}
