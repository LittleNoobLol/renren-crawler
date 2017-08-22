package io.renren.modules.crawler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.crawler.dao.ForeigninfoDao;
import io.renren.modules.crawler.entity.ForeigninfoEntity;
import io.renren.modules.crawler.service.ForeigninfoService;



@Service("foreigninfoService")
public class ForeigninfoServiceImpl implements ForeigninfoService {
	@Autowired
	private ForeigninfoDao foreigninfoDao;
	
	@Override
	public ForeigninfoEntity queryObject(Long id){
		return foreigninfoDao.queryObject(id);
	}
	
	@Override
	public List<ForeigninfoEntity> queryList(Map<String, Object> map){
		return foreigninfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return foreigninfoDao.queryTotal(map);
	}
	
	@Override
	public void save(ForeigninfoEntity foreigninfo){
		foreigninfoDao.save(foreigninfo);
	}
	
	@Override
	public void update(ForeigninfoEntity foreigninfo){
		foreigninfoDao.update(foreigninfo);
	}
	
	@Override
	public void delete(Long id){
		foreigninfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		foreigninfoDao.deleteBatch(ids);
	}

	@Override
	public List<ForeigninfoEntity> queryNoyetInfo() {
		return foreigninfoDao.queryNoyetInfo();
	}
	
}
