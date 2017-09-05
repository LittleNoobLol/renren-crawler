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

import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-09-05 10:17:11
 */
@RestController
@RequestMapping("tbdetails")
public class TbDetailsController {
	@Autowired
	private TbDetailsService tbDetailsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tbdetails:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TbDetailsEntity> tbDetailsList = tbDetailsService.queryList(query);
		int total = tbDetailsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tbDetailsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tbdetails:info")
	public R info(@PathVariable("id") Long id){
		TbDetailsEntity tbDetails = tbDetailsService.queryObject(id);
		
		return R.ok().put("tbDetails", tbDetails);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tbdetails:save")
	public R save(@RequestBody TbDetailsEntity tbDetails){
		tbDetailsService.save(tbDetails);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tbdetails:update")
	public R update(@RequestBody TbDetailsEntity tbDetails){
		tbDetailsService.update(tbDetails);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tbdetails:delete")
	public R delete(@RequestBody Long[] ids){
		tbDetailsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
