package io.renren.modules.wp.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.wp.entity.PostsEntity;
import io.renren.modules.wp.service.PostsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-18 10:39:55
 */
@RestController
@RequestMapping("wp")
public class PostsController {
	@Autowired
	private PostsService postsService;
	
	
	/****
	 * 发布文章
	 * @param tbDetails
	 * @return
	 */
	public R publish(@RequestBody TbDetailsEntity tbDetails){
		
		
		
		return R.ok();
	}
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("posts:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PostsEntity> postsList = postsService.queryList(query);
		int total = postsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(postsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("posts:info")
	public R info(@PathVariable("id") Long id){
		PostsEntity posts = postsService.queryObject(id);
		
		return R.ok().put("posts", posts);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("posts:save")
	public R save(@RequestBody PostsEntity posts){
		postsService.save(posts);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("posts:update")
	public R update(@RequestBody PostsEntity posts){
		postsService.update(posts);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("posts:delete")
	public R delete(@RequestBody Long[] ids){
		postsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
