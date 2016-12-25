package cn.bdqn.oa.struts2.action;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.bdqn.oa.base.BaseAction;
import cn.bdqn.oa.domain.FileInfo;
import cn.bdqn.oa.domain.FileInfo;
import cn.bdqn.oa.service.FileInfoService;
import cn.bdqn.oa.util.FileInfoUtils;
import cn.bdqn.oa.util.FileInfoUtils;

@Controller
@Scope("prototype")
public class FileInfoAction extends BaseAction<FileInfo> {
	private Long parentId;
	private Collection<FileInfo> fileInfoList;
	@Resource
	private FileInfoService fileInfoService;

	/** 列表 */
	public String showFileInfos() throws Exception {
	this.fileInfoList=this.fileInfoService.findAll();
	ActionContext.getContext().put("fileInfoList", fileInfoList);
		return SUCCESS;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Collection<FileInfo> getFileInfoList() {
		return fileInfoList;
	}

	public void setFileInfoList(Collection<FileInfo> fileInfoList) {
		this.fileInfoList = fileInfoList;
	}

	public FileInfoService getFileInfoService() {
		return fileInfoService;
	}

	public void setFileInfoService(FileInfoService fileInfoService) {
		this.fileInfoService = fileInfoService;
	}

}
