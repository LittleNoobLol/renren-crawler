package io.renren.modules.crawler.context.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.crawler.context.dao.ContextDao;
import io.renren.modules.crawler.context.entity.ContextEntity;
import io.renren.modules.crawler.context.service.ContextService;



@Service("contextService")
public class ContextServiceImpl implements ContextService {
	@Autowired
	private ContextDao contextDao;
	
	@Override
	public ContextEntity queryObject(Long id){
		return contextDao.queryObject(id);
	}
	
	@Override
	public List<ContextEntity> queryList(Map<String, Object> map){
		return contextDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return contextDao.queryTotal(map);
	}
	
	@Override
	public void save(ContextEntity context){
		contextDao.save(context);
	}
	
	@Override
	public void update(ContextEntity context){
		contextDao.update(context);
	}
	
	@Override
	public void delete(Long id){
		contextDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		contextDao.deleteBatch(ids);
	}
	
}
