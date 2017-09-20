package io.renren.modules.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.wp.dao.PostsDao;
import io.renren.modules.wp.entity.PostsEntity;
import io.renren.modules.wp.service.PostsService;



@Service("postsService")
public class PostsServiceImpl implements PostsService {
	@Autowired
	private PostsDao postsDao;
	
	@Override
	public PostsEntity queryObject(Long id){
		return postsDao.queryObject(id);
	}
	
	@Override
	public List<PostsEntity> queryList(Map<String, Object> map){
		return postsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return postsDao.queryTotal(map);
	}
	
	@Override
	public void save(PostsEntity posts){
		postsDao.save(posts);
	}
	
	@Override
	public void update(PostsEntity posts){
		postsDao.update(posts);
	}
	
	@Override
	public void delete(Long id){
		postsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		postsDao.deleteBatch(ids);
	}

	@Override
	public void publish(TbDetailsEntity detail) {
		System.out.println("进入service");
		PostsEntity posts =new PostsEntity();
		posts.setPostContent(detail.getContextHtml());
		System.out.println("页面内容:"+detail.getContextHtml()+"之后:"+posts.getPostContent());
		posts.setPostTitle(detail.getTitle());
		System.out.println("页面内容:"+detail.getTitle()+"之后:"+posts.getPostTitle());
		int queryMaxId = queryMaxId()+1;
		posts.setPostName(detail.getTitle());
		posts.setGuid("http://wp.personalloansearchs.com/?p="+queryMaxId);
		save(posts);
	}

	@Override
	public int queryMaxId() {
		return postsDao.queryMaxId();
	}
	
}
