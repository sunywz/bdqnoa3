package cn.bdqn.oa.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * 文件类型
 */
public class FileType {
	private Long id;
	private String fileTypeName;
	private String fileTypeImage;
	private String fileTypeSuffix;
	private Set<FileInfo> fileInfos = new HashSet<FileInfo>();
	private Set<AccessoryFile> accessoryFiles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileTypeName() {
		return fileTypeName;
	}

	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}

	public String getFileTypeImage() {
		return fileTypeImage;
	}

	public void setFileTypeImage(String fileTypeImage) {
		this.fileTypeImage = fileTypeImage;
	}

	public String getFileTypeSuffix() {
		return fileTypeSuffix;
	}

	public void setFileTypeSuffix(String fileTypeSuffix) {
		this.fileTypeSuffix = fileTypeSuffix;
	}



	public Set<FileInfo> getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(Set<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}

	public Set<AccessoryFile> getAccessoryFiles() {
		return accessoryFiles;
	}

	public void setAccessoryFiles(Set<AccessoryFile> accessoryFiles) {
		this.accessoryFiles = accessoryFiles;
	}

}
