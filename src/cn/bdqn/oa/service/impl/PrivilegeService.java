package cn.bdqn.oa.service.impl;

import java.util.Collection;
import java.util.List;

import cn.bdqn.oa.base.DaoSupport;
import cn.bdqn.oa.domain.Privilege;

public interface PrivilegeService<T> extends DaoSupport<T>{

	public List<Privilege> findTopList();
	public Collection<String> getAllPrivilegeUrls();

}
