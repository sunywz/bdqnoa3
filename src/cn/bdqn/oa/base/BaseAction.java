package cn.bdqn.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import cn.bdqn.oa.service.AccessoryFileService;
import cn.bdqn.oa.service.DepartmentService;
import cn.bdqn.oa.service.FileInfoService;
import cn.bdqn.oa.service.ForumService;
import cn.bdqn.oa.service.MenuitemService;
import cn.bdqn.oa.service.RoleService;
import cn.bdqn.oa.service.UserService;
import cn.bdqn.oa.service.impl.PrivilegeService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	// =============== ModelDriven的支持 ==================

	protected T model;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// =============== Service实例的声明 ==================
	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected FileInfoService fileInfoService;
	@Resource
	protected AccessoryFileService accessoryFileService;
	@Resource
	protected MenuitemService menuitemService;
}
