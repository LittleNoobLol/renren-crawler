package io.renren.modules.crawler.ydzx.service;

import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-09-05 10:17:11
 */
public interface TbDetailsService {
	
	TbDetailsEntity queryObject(Long id);
	
	List<TbDetailsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TbDetailsEntity tbDetails);
	
	void update(TbDetailsEntity tbDetails);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
