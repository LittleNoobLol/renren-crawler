package io.renren.modules.crawler.service;

import io.renren.modules.crawler.entity.PagesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-08-16 15:32:12
 */
public interface PagesService {
	
	PagesEntity queryObject(Long id);
	
	List<PagesEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PagesEntity pages);
	
	void update(PagesEntity pages);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
	
	PagesEntity queryNoyetPage();
}
