package cn.bdqn.oa.struts2.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {

	/*private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownloadFileName(){
		String name=getFileName();
		try {
			URLEncoder.encode(name,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return name;
	}*/
	public String getDownloadFileName(){
		String name="朱艺璇。.txt";
		try {
			name=URLEncoder.encode(name,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public InputStream getDownloadFile(){
		return ServletActionContext.getServletContext().getResourceAsStream("file/朱艺璇。.txt");
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
