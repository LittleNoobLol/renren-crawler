package io.renren.modules.crawler.ydzx.service;

import io.renren.common.utils.R;
import io.renren.modules.crawler.ydzx.entity.TbAuthorEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-09-05 10:17:11
 */
public interface TbAuthorService {
	
	R crawlerAuthor(String authorUrl);
	
	TbAuthorEntity queryObject(Integer id);
	
	List<TbAuthorEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TbAuthorEntity tbAuthor);
	
	void update(TbAuthorEntity tbAuthor);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
