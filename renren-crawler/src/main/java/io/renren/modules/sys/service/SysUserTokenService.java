package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.SysUserTokenEntity;
import io.renren.common.utils.R;

/**
 * 用户Token
 * 
 */
public interface SysUserTokenService {

	SysUserTokenEntity queryByUserId(Long userId);

	void save(SysUserTokenEntity token);
	
	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
