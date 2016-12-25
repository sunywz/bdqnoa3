package cn.bdqn.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.oa.base.DaoSupportImpl;
import cn.bdqn.oa.domain.Department;
import cn.bdqn.oa.domain.Forum;
import cn.bdqn.oa.service.DepartmentService;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements
		DepartmentService<Department> {
	@Resource
	private SessionFactory sessionFactory;

	// parentid==null，就说明只有顶级菜单
	// Unable to resolve path [d.parent], unexpected token [d] [from
	// cn.bdqn.oa.domain.Department where d.parent is null]
	@Override
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery("from Department d where d.parent is null").list();
	}

	public List<Department> findChildren(Long parentId) {
		return sessionFactory.getCurrentSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}
}
