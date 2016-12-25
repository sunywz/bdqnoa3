package cn.bdqn.oa.service.impl;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.oa.base.DaoSupportImpl;
import cn.bdqn.oa.domain.Menuitem;
import cn.bdqn.oa.service.MenuitemService;


@Service("menuitemService")
public class MenuitemServiceImpl extends DaoSupportImpl<Menuitem> implements MenuitemService {
	
	public Collection<Menuitem> getAllMenuitem() {
		// TODO Auto-generated method stub
		return findAll();
	}


}
