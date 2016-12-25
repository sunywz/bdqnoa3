package cn.bdqn.oa.util;

import cn.bdqn.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
 * 检查权限的拦截器
 */
public class CheckPrivilegeInterceptor extends AbstractInterceptor {
	// 256/100=2;
	// 256/10=25 %10=5
	// 256 %10=6

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取信息
		User user = (User) ActionContext.getContext().getSession().get("user");
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName;// 对应的权限URL

		// 如果未登陆
		if (user == null) {
			if (privUrl.startsWith("/user_login")) {// "/user_loginUI",
													// "/user_login"
				// 如果去登陆，就放行
				return invocation.invoke();
			} else {
				// 如果不是去登陆，就转到登陆页面
				return "loginUI";
			}
			// 如果已经登陆，就判断权限

		} else {
			if (user.hasPrivilegeByUrl(privUrl)) {
				// 如果有权限，就放行
				return invocation.invoke();
			} else {
				// 如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}
		}

	}

}
