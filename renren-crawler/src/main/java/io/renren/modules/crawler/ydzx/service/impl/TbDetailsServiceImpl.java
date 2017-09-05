package io.renren.modules.crawler.ydzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.crawler.ydzx.dao.TbDetailsDao;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;



@Service("tbDetailsService")
public class TbDetailsServiceImpl implements TbDetailsService {
	@Autowired
	private TbDetailsDao tbDetailsDao;
	
	@Override
	public TbDetailsEntity queryObject(Long id){
		return tbDetailsDao.queryObject(id);
	}
	
	@Override
	public List<TbDetailsEntity> queryList(Map<String, Object> map){
		return tbDetailsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tbDetailsDao.queryTotal(map);
	}
	
	@Override
	public void save(TbDetailsEntity tbDetails){
		tbDetailsDao.save(tbDetails);
	}
	
	@Override
	public void update(TbDetailsEntity tbDetails){
		tbDetailsDao.update(tbDetails);
	}
	
	@Override
	public void delete(Long id){
		tbDetailsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		tbDetailsDao.deleteBatch(ids);
	}
	
}
