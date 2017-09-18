package io.renren.modules.wp.dao;

import io.renren.modules.wp.entity.PostsEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-18 10:39:55
 */
@Mapper
public interface PostsDao extends BaseDao<PostsEntity> {
	
	int queryMaxId();
}
