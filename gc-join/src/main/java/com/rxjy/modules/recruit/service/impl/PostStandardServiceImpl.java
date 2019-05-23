package com.rxjy.modules.recruit.service.impl;

import com.rxjy.datasources.DataSourceNames;
import com.rxjy.datasources.annotation.DataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.common.utils.PageUtils;
import com.rxjy.common.utils.Query;

import com.rxjy.modules.recruit.dao.PostStandardDao;
import com.rxjy.modules.recruit.entity.PostStandardEntity;
import com.rxjy.modules.recruit.service.PostStandardService;


@Service("postStandardService")
public class PostStandardServiceImpl extends ServiceImpl<PostStandardDao, PostStandardEntity> implements PostStandardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PostStandardEntity> page = this.selectPage(
                new Query<PostStandardEntity>(params).getPage(),
                new EntityWrapper<PostStandardEntity>()
        );

        return new PageUtils(page);
    }

	/**
	 * 查询一段列表
	 * @return
	 * @param postStandard
	 */
	@Override
	public List<PostStandardEntity> findList(PostStandardEntity postStandard) {
		return baseMapper.findList(postStandard);
	}
	/**
	 * 内部人事一段导航列表 新sql
	 * @param map
	 * @return
	 */
	@DataSource(name = DataSourceNames.FOUR)
	@Override
	public List<Map<String, String>> getInternalUserList(Map<String, Object> map) {
		return baseMapper.getInternalUserList(map);
	}
	/**
	 *  内部人事一段导航列表 新sql
	 * @return
	 */
	@DataSource(name = DataSourceNames.FOUR)
	@Override
	public List<Map<String, String>> getInternalUserListByCityId() {
		return baseMapper.getInternalUserListByCityId();
	}

}
