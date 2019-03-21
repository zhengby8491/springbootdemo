/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月21日 下午2:13:57
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.conf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

/**
 * <pre>
 * 全局页面传入日期字符串，自动转换成日期格式
 * </pre>
 * 
 * @author zby
 * @version 1.0, 2019年3月21日下午2:13:57, zby
 */
public class DateConverterConfig implements Converter<String, Date> {
	private static final List<String> formarts = new ArrayList<>(4);
	static {
		formarts.add("yyyy-MM");
		formarts.add("yyyy-MM-dd");
		formarts.add("yyyy-MM-dd hh:mm");
		formarts.add("yyyy-MM-dd hh:mm:ss");
	}

	@Override
	public Date convert(String source) {
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}
		if (source.matches("^\\d{4}-\\d{1,2}$")) {
			return parseDate(source, formarts.get(0));
		} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
			return parseDate(source, formarts.get(1));
		} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
			return parseDate(source, formarts.get(2));
		} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
			return parseDate(source, formarts.get(3));
		} else {
			throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
		}
	}

	/**
	 * 格式化日期
	 * 
	 * @param dateStr String 字符型日期
	 * @param format  String 格式
	 * @return Date 日期
	 */
	public Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {

		}
		return date;
	}
}
