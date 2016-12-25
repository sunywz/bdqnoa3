package cn.bdqn.oa.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.oa.domain.Privilege;
import cn.bdqn.oa.domain.User;



@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 执行安装
	 */
	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();

		// ==============================================================
		// 保存超级管理员用户
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin"));
		session.save(user); // 保存

		// ==============================================================
		// 保存权限数据
		Privilege menu, menu1, menu2, menu3, menu4, menu5;

		// --------------------
		menu = new Privilege("人事管理", null, null);
       		menu1 = new Privilege("机构管理", "/branch_list", menu);
		menu2 = new Privilege("部门管理", "/department_list", menu);
		menu3 = new Privilege("岗位管理", "/role_list", menu);
		menu4 = new Privilege("用户管理", "/user_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);

		session.save(new Privilege("机构列表", "/role_list", menu1));
		session.save(new Privilege("机构删除", "/role_delete", menu1));
		session.save(new Privilege("机构添加", "/role_add", menu1));
		session.save(new Privilege("机构修改", "/role_edit", menu1));

		session.save(new Privilege("岗位列表", "/role_list", menu3));
		session.save(new Privilege("岗位删除", "/role_delete", menu3));
		session.save(new Privilege("岗位添加", "/role_add", menu3));
		session.save(new Privilege("岗位修改", "/role_edit", menu3));

		session.save(new Privilege("部门列表", "/department_list", menu2));
		session.save(new Privilege("部门删除", "/department_delete", menu2));
		session.save(new Privilege("部门添加", "/department_add", menu2));
		session.save(new Privilege("部门修改", "/department_edit", menu2));

		session.save(new Privilege("用户列表", "/user_list", menu4));
		session.save(new Privilege("用户删除", "/user_delete", menu4));
		session.save(new Privilege("用户添加", "/user_add", menu4));
		session.save(new Privilege("用户修改", "/user_edit", menu4));
		session.save(new Privilege("初始化密码", "/user_initPassword", menu4));

		// --------------------

		menu = new Privilege("日程管理", null, null);
		menu1 = new Privilege("我的日程", "/forumManage_list", menu);
		menu2 = new Privilege("我的便签", "/forum_list", menu);
		menu3 = new Privilege("部门日程", "/forum_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		// -------------------- 
		menu = new Privilege("文档管理", null, null);
		menu1 = new Privilege("文档管理", "/processDefinition_list", menu);
		menu2 = new Privilege("回收站", "/template_list", menu);
		menu3 = new Privilege("文件搜索", "/flow_templateList", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		// -------------------- 
		menu = new Privilege("消息传递", null, null);
		menu1 = new Privilege("消息管理", "/processDefinition_list", menu);
		menu2 = new Privilege("信箱", "/template_list", menu);	
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
	// -------------------- 
		menu = new Privilege("系统管理", null, null);
       		menu1 = new Privilege("角色管理", "/branch_list", menu);
		menu2 = new Privilege("登录日志", "/department_list", menu);
		menu3 = new Privilege("操作日志", "/role_list", menu);
		menu4 = new Privilege("菜单排序", "/user_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
// -------------------- 
		menu = new Privilege("考勤管理", null, null);
       		menu1 = new Privilege("签到签退", "/branch_list", menu);
		menu2 = new Privilege("请假申请", "/department_list", menu);
		menu3 = new Privilege("加班申请", "/role_list", menu);
		menu4 = new Privilege("考勤查询", "/user_list", menu);
		menu5 = new Privilege("考勤统计", "/user_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);

		// -------------------- 
		menu = new Privilege("公共信息", null, null);
       		menu1 = new Privilege("公共通讯录", "/branch_list", menu);
		menu2 = new Privilege("组织架构", "/department_list", menu);
		menu3 = new Privilege("员工架构", "/role_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);


	// -------------------- 
		menu = new Privilege("新闻管理", null, null);
       		menu1 = new Privilege("浏览新闻", "/branch_list", menu);
		menu2 = new Privilege("新闻管理", "/department_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
	
	// -------------------- 
		menu = new Privilege("会议室管理", null, null);
       		menu1 = new Privilege("预定会议室", "/branch_list", menu);
		menu2 = new Privilege("会议室管理", "/department_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
     	// -------------------- 
menu = new Privilege("常用工具", null, null);
       		menu1 = new Privilege("万年历", "/branch_list", menu);
	
		session.save(menu);
		session.save(menu1);
	
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
}
