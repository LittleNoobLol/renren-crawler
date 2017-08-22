package io.renren.modules.crawler.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.crawler.entity.PagesEntity;
import io.renren.modules.crawler.service.PagesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-08-16 15:32:12
 */
@RestController
@RequestMapping("pages")
public class PagesController {
	@Autowired
	private PagesService pagesService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pages:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PagesEntity> pagesList = pagesService.queryList(query);
		int total = pagesService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pagesList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pages:info")
	public R info(@PathVariable("id") Long id){
		PagesEntity pages = pagesService.queryObject(id);
		
		return R.ok().put("pages", pages);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pages:save")
	public R save(@RequestBody PagesEntity pages){
		pagesService.save(pages);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pages:update")
	public R update(@RequestBody PagesEntity pages){
		pagesService.update(pages);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pages:delete")
	public R delete(@RequestBody Long[] ids){
		pagesService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
