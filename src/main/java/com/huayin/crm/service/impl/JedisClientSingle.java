/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月25日 上午9:57:45
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.huayin.crm.service.JedisClient;
import com.huayin.crm.utils.ObjectUtils;
import com.huayin.crm.utils.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * <pre>
 * redis缓存
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月25日上午9:57:45, zby
 */
@Service
public class JedisClientSingle implements JedisClient
{
	@Value("${redis.password}")
	private String password;
	
	@Value("${redis.single-host}")
	private String host;
	
	@Value("${redis.single-port}")
	private int port;
	
	private JedisPool getJedis()
	{
		return new JedisPool(host,port);
	}
	
	private Jedis getResource()
	{
		Jedis resource = getJedis().getResource();
		if (StringUtils.isBlank(password))
		{
			return resource;
		}
		else
		{
			resource.auth(password);
			return resource;
		}
	}
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#get(java.lang.String)
	 */
	@Override
	public String get(String key)
	{
		Jedis resource = getResource();
		String string = resource.get(key);
		resource.close();
		return string;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#set(java.lang.String, java.lang.String)
	 */
	@Override
	public String set(String key, String value)
	{
		Jedis resource = getResource();
		String string = resource.set(key, value);
		resource.close();
		return string;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#hget(java.lang.String, java.lang.String)
	 */
	@Override
	public String hget(String hkey, String key)
	{
		Jedis resource = getResource();
		String string = resource.hget(hkey, key);
		resource.close();
		return string;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long hset(String hkey, String key, String value)
	{
		Jedis resource = getResource();
		Long hset = resource.hset(hkey, key, value);
		resource.close();
		return hset;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#incr(java.lang.String)
	 */
	@Override
	public long incr(String key)
	{
		Jedis resource = getResource();
		Long incr = resource.incr(key);
		resource.close();
		return incr;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#expire(java.lang.String, java.lang.Integer)
	 */
	@Override
	public long expire(String key, Integer second)
	{
		Jedis resource = getResource();
		Long expire = resource.expire(key, second);
		resource.close();
		return expire;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#ttl(java.lang.String)
	 */
	@Override
	public long ttl(String key)
	{
		Jedis resource = getResource();
		Long ttl = resource.ttl(key);
		resource.close();
		return ttl;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#del(java.lang.String)
	 */
	@Override
	public long del(String key)
	{
		Jedis resource = getResource();
		Long del = resource.del(key);
		resource.close();
		return del;
	}

	/* （非 Javadoc）
	 * @see com.huayin.crm.service.JedisClient#hdel(java.lang.String, java.lang.String)
	 */
	@Override
	public long hdel(String hkey, String key)
	{
		Jedis resource = getResource();
		Long hdel = resource.hdel(hkey, key);
		resource.close();
		return hdel;
	}
	
	public static byte[] toBytes(Object object)
	{
		return ObjectUtils.serialize(object);
	}

	public static Object toObject(byte[] bytes)
	{
		return ObjectUtils.unserialize(bytes);
	}
}
