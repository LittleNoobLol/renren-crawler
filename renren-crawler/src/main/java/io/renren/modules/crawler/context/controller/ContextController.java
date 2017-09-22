package io.renren.modules.crawler.context.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.crawler.context.entity.ContextEntity;
import io.renren.modules.crawler.context.service.ContextService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-22 14:45:30
 */
@RestController
@RequestMapping("/context")
public class ContextController {
	@Autowired
	private ContextService contextService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ContextEntity> contextList = contextService.queryList(query);
		int total = contextService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(contextList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		ContextEntity context = contextService.queryObject(id);
		
		return R.ok().put("context", context);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ContextEntity context){
		contextService.save(context);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ContextEntity context){
		contextService.update(context);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		contextService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
