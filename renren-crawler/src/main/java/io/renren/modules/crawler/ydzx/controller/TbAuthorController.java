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

import io.renren.modules.crawler.ydzx.entity.TbAuthorEntity;
import io.renren.modules.crawler.ydzx.service.TbAuthorService;
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
@RequestMapping("tbauthor")
public class TbAuthorController {
	@Autowired
	private TbAuthorService tbAuthorService;

	/**
	 * 列表
	 */
	@RequestMapping("/author")
	@RequiresPermissions("tbauthor:author")
	public R requestAuthor(String authorUrl) {
		if (authorUrl == null || "".equals(authorUrl.trim())) {
			return R.error("您输入的连接为空或不为一点资讯作者的连接");
		}
		return tbAuthorService.crawlerAuthor(authorUrl);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tbauthor:list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<TbAuthorEntity> tbAuthorList = tbAuthorService.queryList(query);
		int total = tbAuthorService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(tbAuthorList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tbauthor:info")
	public R info(@PathVariable("id") Integer id) {
		TbAuthorEntity tbAuthor = tbAuthorService.queryObject(id);

		return R.ok().put("tbAuthor", tbAuthor);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tbauthor:save")
	public R save(@RequestBody TbAuthorEntity tbAuthor) {
		tbAuthorService.save(tbAuthor);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tbauthor:update")
	public R update(@RequestBody TbAuthorEntity tbAuthor) {
		tbAuthorService.update(tbAuthor);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tbauthor:delete")
	public R delete(@RequestBody Integer[] ids) {
		tbAuthorService.deleteBatch(ids);

		return R.ok();
	}

}
