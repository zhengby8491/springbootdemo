/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月25日 上午10:05:33
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Object 工具
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月25日上午10:05:33, zby
 */
public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils
{
	/**
	 * <pre>
	 * 注解到对象复制，只复制能匹配上的方法。
	 * </pre>
	 * @param annotation
	 * @param object
	 * @since 1.0, 2019年3月25日 上午10:06:15, zby
	 */
	public static void annotationToObject(Object annotation, Object object)
	{
		if (annotation != null)
		{
			Class<?> annotationClass = annotation.getClass();
			Class<?> objectClass = object.getClass();
			for (Method m : objectClass.getMethods())
			{
				if (StringUtils.startsWith(m.getName(), "set"))
				{
					try
					{
						String s = StringUtils.uncapitalize(StringUtils.substring(m.getName(), 3));
						Object obj = annotationClass.getMethod(s).invoke(annotation);
						if (obj != null && !"".equals(obj.toString()))
						{
							if (object == null)
							{
								object = objectClass.newInstance();
							}
							m.invoke(object, obj);
						}
					}
					catch (Exception e)
					{
						// 忽略所有设置失败方法
					}
				}
			}
		}
	}

	/**
	 * <pre>
	 * 序列化对象
	 * </pre>
	 * @param object
	 * @return
	 * @since 1.0, 2019年3月25日 上午10:06:27, zby
	 */
	public static byte[] serialize(Object object)
	{
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try
		{
			if (object != null)
			{
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.writeObject(object);
				return baos.toByteArray();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <pre>
	 * 反序列化对象
	 * </pre>
	 * @param bytes
	 * @return
	 * @since 1.0, 2019年3月25日 上午10:06:35, zby
	 */
	public static Object unserialize(byte[] bytes)
	{
		ByteArrayInputStream bais = null;
		try
		{
			if (bytes != null && bytes.length > 0)
			{
				bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				return ois.readObject();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <pre>
	 * 对象转Map
	 * </pre>
	 * @param obj
	 * @return
	 * @throws Exception
	 * @since 1.0, 2019年3月25日 上午10:06:44, zby
	 */
	public static Map<String, Object> objectToMap(Object obj) throws Exception
	{
		if (obj == null)
			return null;

		Map<String, Object> map = new HashMap<String, Object>();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors)
		{
			String key = property.getName();
			if (key.compareToIgnoreCase("class") == 0)
			{
				continue;
			}
			Method getter = property.getReadMethod();
			Object value = getter != null ? getter.invoke(obj) : null;
			map.put(key, value);
		}

		return map;
	}
}
