package com.sn.smart.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具
 * 
 * @author gxzhou2
 *
 */
public class ReflectUtils {

	private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

	private static final String GET_METHOD_PRE = "get";
	private static final String SET_METHOD_PRE = "set";

	/**
	 * 将B的属性反射到A
	 * 
	 * @param objA
	 * @param objB
	 * @return
	 */
	public static Object reflectB2A(Object objA, Object objB) {
		if (objA == null || objB == null) {
			return null;
		}
		for (Class<?> clazz = objB.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				String firstLetter = name.substring(0, 1).toUpperCase();
				String getMethodName = GET_METHOD_PRE + firstLetter + name.substring(1);
				String setMethodName = SET_METHOD_PRE + firstLetter + name.substring(1);
				try {
					Method getMethod = clazz.getMethod(getMethodName, new Class[] {});
					Method setMethod = clazz.getMethod(setMethodName, new Class[] { field.getType() });
					Object value = getMethod.invoke(objB, new Object[] {});
					if (value != null) {
						setMethod.invoke(objA, new Object[] { value });
					}
				} catch (Exception e) {
					logger.info("this is a log to remark ignored exceptions!");
					e.printStackTrace();
					logger.info("this is a log to remark ignored exceptions!");
				}
			}
		}
		return objA;
	}

}
