package cn.bdqn.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.oa.base.DaoSupportImpl;
import cn.bdqn.oa.domain.Role;
import cn.bdqn.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService<Role>{

}
