/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月25日 上午9:56:31
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.service;

/**
 * <pre>
 * Redis缓存
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月25日上午9:56:31, zby
 */
public interface JedisClient
{
	String get(String key);

	String set(String key, String value);

	String hget(String hkey, String key);

	long hset(String hkey, String key, String value);

	long incr(String key);

	long expire(String key, Integer second);

	long ttl(String key);

	long del(String key);

	long hdel(String hkey, String key);
}
