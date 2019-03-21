/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月21日 下午2:53:37
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * <pre>
 * id 生成策略
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:56:14, zby
 */
public class IDUtils
{

	/**
	 * <pre>
	 * 生成UUID
	 * </pre>
	 * @return
	 * @since 1.0, 2019年1月21日 上午9:41:01, think
	 */
	public static String genUUID()
	{
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * <pre>
	 * 生成Token
	 * </pre>
	 * @return
	 * @since 1.0, 2019年1月21日 上午9:38:24, think
	 */
	public static String genToken()
	{
		return genUUID();
	}

	/**
	 * <pre>
	 * 生成yyMMddHHmmssSSS + Length位随机数字
	 * </pre>
	 * @param length
	 * @return
	 * @since 1.0, 2018年12月29日 下午2:02:58, think
	 */
	public static String gen(int length)
	{
		final SimpleDateFormat formatTimestamp = new SimpleDateFormat("yyMMddHHmmssSSS");
		String serial = formatTimestamp.format(new Date());
		return serial + RandomStringUtils.randomNumeric(length);
	}

	/**
	 * <pre>
	 * 生成买家编码（yyyyMMdd + 8位随机数字）
	 * </pre>
	 * @return
	 * @since 1.0, 2019年1月9日 下午7:14:22, think
	 */
	public static String genBuyerNo()
	{
		String current = new SimpleDateFormat("yyyyMMdd").format(new Date());
		return current + RandomStringUtils.randomNumeric(8);
	}

	/**
	 * <pre>
	 * 图片名生成
	 * </pre>
	 * @return
	 * @since 1.0, 2018年11月21日 下午5:32:02, think
	 */
	public static String genImageName()
	{
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	/**
	 * <pre>
	 * 商品id生成
	 * </pre>
	 * @return
	 * @since 1.0, 2018年11月21日 下午5:32:13, think
	 */
	public static long genItemId()
	{
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	/**
	 * <pre>
	 * 订单id生成
	 * </pre>
	 * @return
	 * @since 1.0, 2018年11月21日 下午5:32:21, think
	 */
	public static String genOrderId()
	{
		//取当前时间的长整形值包含毫秒
		String millis = System.currentTimeMillis() + "";

		millis = millis.substring(5, millis.length());
		//加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		//如果不足两位前面补0
		String str = String.format("%04d", end4);

		return millis + str;
	}

	/**
	 * <pre>
	 * 订单项id生成
	 * </pre>
	 * @return
	 * @since 1.0, 2018年11月21日 下午5:32:31, think
	 */
	public static String genOrderItemId()
	{
		//取当前时间的长整形值包含毫秒
		String millis = System.currentTimeMillis() + "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String data = format.format(new Date());

		millis = millis.substring(7, millis.length());
		//加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		//如果不足两位前面补0
		String str = String.format("%04d", end4);

		return data + millis + str;
	}

	/**
	 * <pre>
	 * 创建一个256位的key
	 * </pre>
	 * @return
	 * @since 1.0, 2019年1月23日 下午7:10:33, chenlong
	 */
	public static String genKey256()
	{
		return RandomStringUtils.randomAlphanumeric(256);
	}
}
