package io.renren.modules.crawler.service;

import io.renren.modules.crawler.entity.ForeigninfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-08-16 15:32:12
 */
public interface ForeigninfoService {
	
	ForeigninfoEntity queryObject(Long id);
	
	List<ForeigninfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ForeigninfoEntity foreigninfo);
	
	void update(ForeigninfoEntity foreigninfo);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
	
	List<ForeigninfoEntity> queryNoyetInfo();
}
