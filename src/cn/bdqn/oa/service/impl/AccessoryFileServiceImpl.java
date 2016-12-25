package cn.bdqn.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.oa.base.DaoSupportImpl;
import cn.bdqn.oa.domain.AccessoryFile;
import cn.bdqn.oa.domain.Department;
import cn.bdqn.oa.domain.FileInfo;
import cn.bdqn.oa.service.AccessoryFileService;

@Service("accessoryFileService")
@Transactional
public class AccessoryFileServiceImpl extends DaoSupportImpl<AccessoryFile>
		implements AccessoryFileService<AccessoryFile> {
	@Resource
	private SessionFactory sessionFactory;
	FileInfo fileInfo = new FileInfo();
	AccessoryFile accessoryFile = new AccessoryFile();


	// 根据文件夹节点id查找下面的附件
	public List<AccessoryFile> findAcfById(Long fileinfoId) {

		// return
		// sessionFactory.getCurrentSession().createQuery("from AccessoryFile as f where f.fileInfo.fileinfoId="+fileinfoId).list();
		return sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"select * from bdqn_AccessoryFile where fileinfoId="
								+ fileinfoId).addEntity(AccessoryFile.class)
				.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
