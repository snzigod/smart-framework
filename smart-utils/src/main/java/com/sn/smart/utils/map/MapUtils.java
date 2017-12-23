package com.sn.smart.utils.map;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * map工具集
 * 
 * @author gxzhou2
 *
 */
public class MapUtils {

	private MapUtils() {
		throw new IllegalAccessError("Utility class");
	}

	/**
	 * 对象转map
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> Obj2Map(Object obj) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}
		return map;
	}

	/**
	 * map转对象
	 * 
	 * @param map
	 * @param clz
	 * @return
	 * @throws Exception
	 */
	public static Object map2Obj(Map<String, Object> map, Class<?> clz) throws Exception {
		Object obj = clz.newInstance();
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}
			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));
		}
		return obj;
	}

}
