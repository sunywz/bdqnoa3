package cn.bdqn.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.oa.base.DaoSupportImpl;
import cn.bdqn.oa.domain.Forum;
import cn.bdqn.oa.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements
		ForumService {
	// 保存
	public void save(Forum forum) {
		super.save(forum);
		forum.setPosition(forum.getId().intValue());

	}

	@SuppressWarnings("unchecked")
	public List<Forum> findAll() {
		return getSession().createQuery("FROM Forum f order by f.position")
				.list();
	}

	/*
	 * 上移(non-Javadoc)
	 * 
	 * @see cn.bdqn.oa.service.ForumService#moveUp(java.lang.Long)
	 */
	@Override
	public void moveUp(Long id) {
		// 找出相关Forum
		Forum xia = getById(id);// 当前要移动的Forum
		Forum shang = (Forum) getSession()// 我上面的那个
				.createQuery(
						"from Forum f where f.position<? order by f.position DESC")//
				.setParameter(0, xia.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		// 最上面的不能移动
		if (shang == null) {
			return;
		}
		// 交换position的值
		int shangTemp = shang.getPosition();// xia
		shang.setPosition(xia.getPosition());
		xia.setPosition(shangTemp);
		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		getSession().update(shang);
		getSession().update(xia);
	}

	/*
	 * 下移(non-Javadoc)
	 */
	@Override
	public void moveDown(Long id) {
		// 找出相关Forum
		Forum shang = getById(id);// 当前要移动的。上面的
		// 下面的
		Forum xia = (Forum) getSession()
				.createQuery(
						"from Forum f where f.position>? order by f.position asc")//
				.setParameter(0, shang.getPosition()).setFirstResult(0)//
				.setMaxResults(1)//
				//
				.uniqueResult();
		if (xia == null) {
			return;
		}
		int temp = shang.getPosition();
		shang.setPosition(xia.getPosition());
		xia.setPosition(temp);

		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		getSession().update(shang);
		getSession().update(xia);
	}

}
