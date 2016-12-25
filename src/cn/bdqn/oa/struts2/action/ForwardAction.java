package cn.bdqn.oa.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport {
	public String index(){
		return "index";
	}
	
	public String left() {
		return "left";
	}

	public String right() {
		return "right";
	}

	
}
