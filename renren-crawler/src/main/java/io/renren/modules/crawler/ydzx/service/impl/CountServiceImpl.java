package io.renren.modules.crawler.ydzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.crawler.ydzx.dao.CountDao;
import io.renren.modules.crawler.ydzx.entity.CountEntity;
import io.renren.modules.crawler.ydzx.service.CountService;



@Service("countService")
public class CountServiceImpl implements CountService {
	@Autowired
	private CountDao countDao;
	
	@Override
	public CountEntity queryObject(Long id){
		return countDao.queryObject(id);
	}
	
	@Override
	public List<CountEntity> queryList(Map<String, Object> map){
		return countDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return countDao.queryTotal(map);
	}
	
	@Override
	public void save(CountEntity count){
		countDao.save(count);
	}
	
	@Override
	public void update(CountEntity count){
		countDao.update(count);
	}
	
	@Override
	public void delete(Long id){
		countDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		countDao.deleteBatch(ids);
	}
	
}
