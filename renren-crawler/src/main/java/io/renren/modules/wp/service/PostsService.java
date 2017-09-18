package io.renren.modules.wp.service;

import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.wp.entity.PostsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-18 10:39:55
 */
public interface PostsService {
	

	int queryMaxId();
	
	void publish(TbDetailsEntity detail);
	
	PostsEntity queryObject(Long id);
	
	List<PostsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PostsEntity posts);
	
	void update(PostsEntity posts);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
