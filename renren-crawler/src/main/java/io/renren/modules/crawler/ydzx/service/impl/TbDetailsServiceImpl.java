package io.renren.modules.crawler.ydzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.crawler.ydzx.dao.TbDetailsDao;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;

@Service("tbDetailsService")
public class TbDetailsServiceImpl implements TbDetailsService {
	@Autowired
	private TbDetailsDao tbDetailsDao;

	@Value("${image.ydzxreplace}")
	private String ydzxReplace;

	@Value("${image.myself}")
	private String myself;

	@Override
	public TbDetailsEntity queryObject(Long id) {
		return tbDetailsDao.queryObject(id);
	}

	@Override
	public List<TbDetailsEntity> queryList(Map<String, Object> map) {
		return tbDetailsDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return tbDetailsDao.queryTotal(map);
	}

	@Override
	public boolean save(TbDetailsEntity tbDetails) {
		if(tbDetails.getContextHtml()==null || tbDetails.getContextHtml().trim().equals("")){
			return false;
		}
		// 查询数据库是否有值
		// int exts = tbDetailsDao.queryIdExsts(tbDetails.getId());
		// 做更新或者新增
		//if (exts == 1) {
			//tbDetailsDao.update(tbDetails);
		//} else {
		String contextHtml = tbDetails.getContextHtml();
		contextHtml=contextHtml.replace(ydzxReplace, myself);
		tbDetails.setContextHtml(contextHtml);
			tbDetailsDao.save(tbDetails);
			return true;
		//}
	}
	
	@Override
	public void update(TbDetailsEntity tbDetails) {
		tbDetailsDao.update(tbDetails);
	}

	@Override
	public void delete(Long id) {
		tbDetailsDao.delete(id);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		tbDetailsDao.deleteBatch(ids);
	}

	@Override
	public int queryMaxId() {
		return tbDetailsDao.queryMaxId();
	}

}
