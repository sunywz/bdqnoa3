package cn.bdqn.oa.service;

import java.util.List;

import cn.bdqn.oa.base.DaoSupport;
import cn.bdqn.oa.domain.AccessoryFile;

public interface AccessoryFileService<T> extends DaoSupport<T>{
	public List<AccessoryFile> findAcfById(Long fileinfoId);
	}
