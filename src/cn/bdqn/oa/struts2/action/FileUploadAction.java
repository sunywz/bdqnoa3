package cn.bdqn.oa.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


public class FileUploadAction extends ActionSupport {
private String finame;
private String description;
private String fileLocation;
private String sex;
	
	
	private File[] file;
	private String[] filePath;
	private String[] fileFileName;
	// 提交过来的file的MIME类型
	private String fileContentType;

	/** 添加页面 */
	public String addUI() throws Exception {

		return "saveUI";
	}

	public String uploadFile() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		File file = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
		if (!file.exists()) {
			file.mkdir();
		}
		try {
			if (this.file != null) {
				File f[] = this.getFile();
				filePath = new String[f.length];
				for (int i = 0; i < f.length; i++) {
					String fileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
					String name = fileName + fileFileName[i]; // 保存在硬盘中的文件名

					FileInputStream inputStream = new FileInputStream(f[i]);
					FileOutputStream outputStream = new FileOutputStream(path
							+ "\\" + name);
					byte[] buf = new byte[1024];
					int length = 0;
					while ((length = inputStream.read(buf)) != -1) {
						outputStream.write(buf, 0, length);
					}
					inputStream.close();
					outputStream.flush();
					// 文件保存的完整路径
					// 比如：D:\tomcat6\webapps\struts_ajaxfileupload\\upload\a0be14a1-f99e-4239-b54c-b37c3083134a.png
					filePath[i] = "\\" + name;
					System.out.println(filePath[i]);
					System.out.println(name);
					System.out.println(finame);
					System.out.println(description);

					System.out.println(fileLocation);
					System.out.println(sex);


				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String[] getFilePath() {
		return filePath;
	}

	public void setFilePath(String[] filePath) {
		this.filePath = filePath;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}



	public String getFiname() {
		return finame;
	}

	public void setFiname(String finame) {
		this.finame = finame;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
