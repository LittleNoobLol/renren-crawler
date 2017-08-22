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

import io.renren.modules.crawler.entity.ForeigninfoEntity;
import io.renren.modules.crawler.service.ForeigninfoService;
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
@RequestMapping("foreigninfo")
public class ForeigninfoController {
	@Autowired
	private ForeigninfoService foreigninfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("foreigninfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ForeigninfoEntity> foreigninfoList = foreigninfoService.queryList(query);
		int total = foreigninfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(foreigninfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("foreigninfo:info")
	public R info(@PathVariable("id") Long id){
		ForeigninfoEntity foreigninfo = foreigninfoService.queryObject(id);
		
		return R.ok().put("foreigninfo", foreigninfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("foreigninfo:save")
	public R save(@RequestBody ForeigninfoEntity foreigninfo){
		foreigninfoService.save(foreigninfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("foreigninfo:update")
	public R update(@RequestBody ForeigninfoEntity foreigninfo){
		foreigninfoService.update(foreigninfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("foreigninfo:delete")
	public R delete(@RequestBody Long[] ids){
		foreigninfoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
