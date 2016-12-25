package cn.bdqn.oa.struts2.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.bdqn.oa.base.BaseAction;
import cn.bdqn.oa.domain.Department;
import cn.bdqn.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	private Long parentId;

	/** 列表 */
	public String list() throws Exception {
		List<Department> departmentList = null;
		if (parentId == null) {// 顶级部门列表//????????????????
			departmentList = departmentService.findTopList();
		} else {
			departmentList = departmentService.findChildren(parentId);
			Department parent = (Department) departmentService
					.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		departmentService.delete(this.getModel().getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		Department parent = (Department) this.departmentService
				.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		// 准备回显的数据
		Department department = (Department) departmentService.getById(model
				.getId());
		ActionContext.getContext().getValueStack().push(department);
		// ????????????????
		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		return "saveUI";
	}

	
	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库取出原对象
		Department department = (Department) departmentService.getById(model
				.getId());
		// 2，设置要修改的属性
		department.setDescription(model.getDescription());
		department.setParent((Department) departmentService.getById(parentId));// 设置所属的上级部门
		// 3，更新到数据库中
		departmentService.update(department);
		return "toList";
	}

	// ----

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
