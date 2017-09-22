package io.renren.modules.wp.service;

import io.renren.modules.wp.entity.UsersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-22 14:48:10
 */
public interface UsersService {
	
	UsersEntity queryObject(Long id);
	
	List<UsersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UsersEntity users);
	
	void update(UsersEntity users);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
	
	Long getAuthorId(String authorName);
}
