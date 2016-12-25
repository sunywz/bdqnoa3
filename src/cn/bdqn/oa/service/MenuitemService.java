package cn.bdqn.oa.service;

import java.util.Collection;
import java.util.Set;

import cn.bdqn.oa.domain.Menuitem;



public interface MenuitemService {
//	public Collection<Menuitem> getAllMenuitem();
//
//	public Collection<Menuitem> getMenuitemBypid(Long pid);
// 用于根据mids这个数组，查询出这些菜单，作为一个set集合，然后返回给PrivilegeAction，用于保存权限
	public Collection<Menuitem> getAllMenuitem();
}
