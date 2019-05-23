package com.rxjy.modules.recruit.dao;

import com.rxjy.modules.recruit.entity.PostStandardEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 岗位标准表
 * 
 * @author kami
 * @email zhangqm@rxjy.com
 * @date 2018-11-18 11:22:54
 */
public interface PostStandardDao extends BaseMapper<PostStandardEntity> {

	/**
	 * 查询一段列表
	 * @return
	 * @param postStandard
	 */
	List<PostStandardEntity> findList(PostStandardEntity postStandard);

	/**
	 * 内部人事一段导航列表 新sql
 	 * @param map
	 * @return
	 */
	List<Map<String,String>> getInternalUserList(Map<String,Object> map);

	/**
	 *  内部人事一段导航列表 新sql
	 * @return
	 */
	List<Map<String,String>> getInternalUserListByCityId();
}
