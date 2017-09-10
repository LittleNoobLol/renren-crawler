package io.renren.modules.crawler.ydzx.dao;

import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;

import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-09-05 10:17:11
 */
@Mapper
public interface TbDetailsDao extends BaseDao<TbDetailsEntity> {
	int queryMaxId();

	int queryIdExsts(int value);

}
