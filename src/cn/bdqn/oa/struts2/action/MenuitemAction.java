package cn.bdqn.oa.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.bdqn.oa.base.BaseAction;
import cn.bdqn.oa.domain.Department;
import cn.bdqn.oa.domain.Menuitem;

import com.opensymphony.xwork2.ActionSupport;


@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction extends BaseAction<Menuitem> {


	private Collection<Menuitem> menuitemList;

	
//	@JSON(serialize = false)
//	public String getAllMenuitem() {
//		this.menuitemList = this.menuitemService.getAllMenuitem();
//		return SUCCESS;
//	}

	public Collection<Menuitem> getMenuitemList() {
		return menuitemList;
	}


	public void setMenuitemList(Collection<Menuitem> menuitemList) {
		this.menuitemList = menuitemList;
	}


	// 展示父节点
//	public String showMenuitemsByPid() {
//		this.menuitemList = this.menuitemService.getMenuitemBypid(this
//				.getModel().getPid());
//		return SUCCESS;
//	}

	//根据用户权限去显示它所拥有的菜单
	public String showMenuitemsByUser(){
		this.menuitemList = menuitemService.getAllMenuitem();
		return SUCCESS;
	}
}
