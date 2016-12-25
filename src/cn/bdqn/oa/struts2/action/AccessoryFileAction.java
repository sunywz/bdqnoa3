package cn.bdqn.oa.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.bdqn.oa.base.BaseAction;
import cn.bdqn.oa.domain.AccessoryFile;
import cn.bdqn.oa.domain.Department;
import cn.bdqn.oa.domain.FileInfo;

@Controller
@Scope("prototype")
public class AccessoryFileAction extends BaseAction<AccessoryFile> {
	private Long parentId;
	private List<AccessoryFile> accessoryFileList = new ArrayList<AccessoryFile>();

	
	
	//根据文件夹的节点id查找附件
	public String findAcfByid(){
		accessoryFileList=accessoryFileService.findAcfById(parentId);
	ActionContext.getContext().put("accessoryFileList", accessoryFileList);
			return "list";
	}
	
	public String toLeft(){
		return "toleft";
		
	}
	public String tomain(){
		return "tomain";
		
	}
	
	public String list() {
		System.out.println(parentId);
		FileInfo fileInfo=(FileInfo) fileInfoService.getById(parentId);
		accessoryFileList=(List) fileInfo.getAccessoryFiles();
	//	accessoryFileList=(List) accessoryFileService.findChildren(parentId);
		System.out.println(accessoryFileList);
		return SUCCESS;

	}

	// --------------------


	public List getAccessoryFileList() {
		return accessoryFileList;
	}





	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setAccessoryFileList(List accessoryFileList) {
		this.accessoryFileList = accessoryFileList;
	}

}
