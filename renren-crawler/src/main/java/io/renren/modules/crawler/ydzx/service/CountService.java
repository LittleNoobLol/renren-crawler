package io.renren.modules.crawler.ydzx.service;

import io.renren.modules.crawler.ydzx.entity.CountEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-11 19:55:33
 */
public interface CountService {
	
	CountEntity queryObject(Long id);
	
	List<CountEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CountEntity count);
	
	void update(CountEntity count);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
