package cn.bdqn.oa.service;

import java.util.List;

import cn.bdqn.oa.base.DaoSupport;
import cn.bdqn.oa.domain.Department;

public interface DepartmentService<T> extends DaoSupport<T>{

	List<Department> findTopList();

	List<Department> findChildren(Long parentId);

}
