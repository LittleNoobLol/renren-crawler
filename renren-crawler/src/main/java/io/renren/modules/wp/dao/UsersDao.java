package io.renren.modules.wp.dao;

import io.renren.modules.wp.entity.UsersEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-22 14:48:10
 */
@Mapper
public interface UsersDao extends BaseDao<UsersEntity> {
	
	UsersEntity queryAuthorName(Object value);
	
}
