package cn.bdqn.oa.service;

import cn.bdqn.oa.base.DaoSupport;
import cn.bdqn.oa.domain.User;

public interface UserService<T> extends DaoSupport<T>{

	public User findByLoginNameAndPassword(String loginName, String password);

}
