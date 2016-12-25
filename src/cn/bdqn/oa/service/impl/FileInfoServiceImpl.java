package cn.bdqn.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.oa.base.DaoSupportImpl;
import cn.bdqn.oa.domain.Department;
import cn.bdqn.oa.domain.FileInfo;
import cn.bdqn.oa.service.FileInfoService;

@Service("fileInfoService")
@Transactional
public class FileInfoServiceImpl extends DaoSupportImpl<FileInfo> implements
		FileInfoService<FileInfo> {
	@Resource
	private SessionFactory sessionFactory;

	public List<FileInfo> findTopList() {
		return getSession().createQuery(
				"from FileInfo p where p.parent is null").list();
	}

	public List<FileInfo> findChildren(Long parentId) {
		return sessionFactory.getCurrentSession().createQuery(//
				"FROM FileInfo d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}
	
}
