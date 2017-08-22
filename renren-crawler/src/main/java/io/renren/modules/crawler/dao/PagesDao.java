package io.renren.modules.crawler.dao;

import io.renren.modules.crawler.entity.PagesEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-08-16 15:32:12
 */
@Mapper
public interface PagesDao extends BaseDao<PagesEntity> {
	PagesEntity queryNoyetPage();
}
