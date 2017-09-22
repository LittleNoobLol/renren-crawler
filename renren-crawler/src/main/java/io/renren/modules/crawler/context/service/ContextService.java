package io.renren.modules.crawler.context.service;

import io.renren.modules.crawler.context.entity.ContextEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-22 14:45:30
 */
public interface ContextService {
	
	ContextEntity queryObject(Long id);
	
	List<ContextEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ContextEntity context);
	
	void update(ContextEntity context);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
