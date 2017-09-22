package io.renren.modules.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.wp.dao.UsersDao;
import io.renren.modules.wp.entity.UsersEntity;
import io.renren.modules.wp.service.UsersService;



@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public UsersEntity queryObject(Long id){
		return usersDao.queryObject(id);
	}
	
	@Override
	public List<UsersEntity> queryList(Map<String, Object> map){
		return usersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return usersDao.queryTotal(map);
	}
	
	@Override
	public void save(UsersEntity users){
		usersDao.save(users);
	}
	
	@Override
	public void update(UsersEntity users){
		usersDao.update(users);
	}
	
	@Override
	public void delete(Long id){
		usersDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		usersDao.deleteBatch(ids);
	}
	
}
