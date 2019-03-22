/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 下午1:46:07
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.mapper.sys;
        
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.huayin.crm.vo.sys.SysUser;
       
/**
 * <pre>
 * 用户
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日下午1:46:07, zby
 */
@Mapper
public interface SysUserMapper
{
	/**
	 * <pre>
	 * 根据id获取一条系统用户
	 * </pre>
	 * @param id
	 * @return
	 * @since 1.0, 2019年3月22日 下午3:24:32, zby
	 */
	SysUser get(Long id);

	/**
	 * <pre>
	 * 根据loginname获取一条系统用户
	 * </pre>
	 * @param loginname
	 * @return
	 * @since 1.0, 2019年3月22日 下午3:24:40, zby
	 */
	SysUser getByLoginname(String loginname);

	/**
	 * <pre>
	 * 查询所有系统用户
	 * </pre>
	 * @param record
	 * @return
	 * @since 1.0, 2019年3月22日 下午3:24:51, zby
	 */
	List<SysUser> selectList(SysUser record);

	/**
	 * <pre>
	 * 新增系统用户
	 * </pre>
	 * @param record
	 * @return
	 * @since 1.0, 2019年3月22日 下午3:25:00, zby
	 */
	int insertSelective(SysUser record);

	/**
	 * <pre>
	 * 修改系统用户
	 * </pre>
	 * @param record
	 * @return
	 * @since 1.0, 2019年3月22日 下午3:25:07, zby
	 */
	int updateByIdSelective(SysUser record);

	/**
	 * <pre>
	 * 修改系统用户密码
	 * </pre>
	 * @param record
	 * @return
	 * @since 1.0, 2019年3月22日 下午3:25:17, zby
	 */
	int updatePassword(SysUser record);

	/**
	 * <pre>
	 * 根据id删除系统用户
	 * </pre>
	 * @param id
	 * @return
	 * @since 1.0, 2019年3月22日 下午1:49:15, zby
	 */
	int deleteById(Long id);

	/**
	 * <pre>
	 * 根据id集合批量删除系统用户
	 * </pre>
	 * @param ids
	 * @return
	 * @since 1.0, 2019年3月22日 下午3:25:25, zby
	 */
	int deleteByIds(@Param("ids") List<Long> ids);
  
  
}
