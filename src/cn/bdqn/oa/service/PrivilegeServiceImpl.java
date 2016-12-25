package cn.bdqn.oa.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.oa.base.DaoSupportImpl;
import cn.bdqn.oa.domain.Privilege;
import cn.bdqn.oa.service.impl.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements
		PrivilegeService<Privilege> {

	@Override
	public List<Privilege> findTopList() {
		// TODO Auto-generated method stub
		return getSession().createQuery(
				"FROM Privilege p WHERE p.parent IS NULL")//
				.list();
	}

	public Collection<String> getAllPrivilegeUrls() {
		return getSession()
				.createQuery(
						"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")//
				.list();
	}

}
