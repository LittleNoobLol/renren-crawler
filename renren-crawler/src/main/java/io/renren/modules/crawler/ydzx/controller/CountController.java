package io.renren.modules.crawler.ydzx.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.crawler.ydzx.entity.CountEntity;
import io.renren.modules.crawler.ydzx.service.CountService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-11 19:55:33
 */
@RestController
@RequestMapping("count")
public class CountController {
	@Autowired
	private CountService countService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("count:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CountEntity> countList = countService.queryList(query);
		int total = countService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(countList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("count:info")
	public R info(@PathVariable("id") Long id){
		CountEntity count = countService.queryObject(id);
		
		return R.ok().put("count", count);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("count:save")
	public R save(@RequestBody CountEntity count){
		countService.save(count);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("count:update")
	public R update(@RequestBody CountEntity count){
		countService.update(count);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("count:delete")
	public R delete(@RequestBody Long[] ids){
		countService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
