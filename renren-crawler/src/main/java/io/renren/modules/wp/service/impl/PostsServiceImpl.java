package io.renren.modules.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
		PostsEntity posts =new PostsEntity();
		posts.setPostContent(detail.getContextHtml());
		posts.setPostTitle(detail.getTitle());
		int queryMaxId = queryMaxId()+1;
		posts.setPostName(detail.getTitle());
		posts.setGuid("http://wp.personalloansearchs.com/?p="+queryMaxId);
		save(posts);
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s1="潮鞋丨「小白鞋」卷土重来，这9款百搭、吸睛还新潮";
		String iso = new String(s1.getBytes("utf-8"), "iso-8859-1"); 
		
		String encode = URLEncoder.encode(s1, "UTF-8").toLowerCase();

		String s2="%e6%bd%ae%e9%9e%8b%e4%b8%a8%e3%80%8c%e5%b0%8f%e7%99%bd%e9%9e%8b%e3%80%8d%e5%8d%b7%e5%9c%9f%e9%87%8d%e6%9d%a5%ef%bc%8c%e8%bf%999%e6%ac%be%e7%99%be%e6%90%ad%e3%80%81%e5%90%b8%e7%9d%9b%e8%bf%98%e6%96%b0";
		String iso2 = new String(s1.getBytes(), "utf-8"); 
		
		System.out.println(iso2);
		
		System.out.println(encode);
		String string = new String(encode.getBytes(), "utf-8");
		System.out.println(string);
	}

	@Override
	public int queryMaxId() {
		return postsDao.queryMaxId();
	}
	
}
