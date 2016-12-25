package cn.bdqn.oa.domain;

import java.util.Date;

/*
 * 文件
 */
public class AccessoryFile {
	private Long id;
	private Long fileId;
	private String accessoryName;
	private Long accessorySize;
	private Long accessoryType;
	private Date createDate;
	private String accessoryPath;
	private FileType fileType;
	private FileInfo fileInfo;

	
	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getAccessoryName() {
		return accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}

	public Long getAccessorySize() {
		return accessorySize;
	}

	public void setAccessorySize(Long accessorySize) {
		this.accessorySize = accessorySize;
	}

	public Long getAccessoryType() {
		return accessoryType;
	}

	public void setAccessoryType(Long accessoryType) {
		this.accessoryType = accessoryType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAccessoryPath() {
		return accessoryPath;
	}

	public void setAccessoryPath(String accessoryPath) {
		this.accessoryPath = accessoryPath;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

}
