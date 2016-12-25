package cn.bdqn.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
 * 文件夹
 */
public class FileInfo implements java.io.Serializable {

	private Long id;
	private String name;
	private String remark;
	private String fileOwner;
	private Date createDate;
	private FileType fileType;
	private String filePath;
	private Long ifDelete;
	private FileInfo parent;
	private Set<FileInfo> children;
	private Set<AccessoryFile> accessoryFiles = new HashSet<AccessoryFile>();
	private User user;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFileOwner() {
		return fileOwner;
	}

	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getIfDelete() {
		return ifDelete;
	}

	public void setIfDelete(Long ifDelete) {
		this.ifDelete = ifDelete;
	}

	public FileInfo getParent() {
		return parent;
	}

	public void setParent(FileInfo parent) {
		this.parent = parent;
	}

	public Set<FileInfo> getChildren() {
		return children;
	}

	public void setChildren(Set<FileInfo> children) {
		this.children = children;
	}

	public Set<AccessoryFile> getAccessoryFiles() {
		return accessoryFiles;
	}

	public void setAccessoryFiles(Set<AccessoryFile> accessoryFiles) {
		this.accessoryFiles = accessoryFiles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}