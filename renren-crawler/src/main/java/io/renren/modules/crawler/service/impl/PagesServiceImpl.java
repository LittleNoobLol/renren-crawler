package io.renren.modules.crawler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.crawler.dao.PagesDao;
import io.renren.modules.crawler.entity.PagesEntity;
import io.renren.modules.crawler.service.PagesService;



@Service("pagesService")
public class PagesServiceImpl implements PagesService {
	@Autowired
	private PagesDao pagesDao;
	
	@Override
	public PagesEntity queryObject(Long id){
		return pagesDao.queryObject(id);
	}
	
	@Override
	public List<PagesEntity> queryList(Map<String, Object> map){
		return pagesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return pagesDao.queryTotal(map);
	}
	
	@Override
	public void save(PagesEntity pages){
		pagesDao.save(pages);
	}
	
	@Override
	public void update(PagesEntity pages){
		pagesDao.update(pages);
	}
	
	@Override
	public void delete(Long id){
		pagesDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		pagesDao.deleteBatch(ids);
	}

	@Override
	public PagesEntity queryNoyetPage() {
		return pagesDao.queryNoyetPage();
	}
	
}
