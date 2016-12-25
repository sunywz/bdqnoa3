package cn.bdqn.oa.util;

import java.util.ArrayList;
import java.util.List;

/*
 * 用于辅助拼接HQL
 */
public class QueryHelper {
	/*
	 * private String fromClause; // FROM子句 private String whereClause = ""; //
	 * Where子句 private String orderByClause = ""; // OrderBy子句
	 * 
	 * private List<Object> parameters = new ArrayList<Object>(); // 参数列表
	 */
	private String fromClause;// FROM
	private String whereClause = "";
	private String orderByClause = "";
	private List<Object> parameters = new ArrayList<Object>();// 参数列表

	/**
	 * 生成From子句
	 * 
	 * @param clazz
	 * @param alias
	 *            别名
	 */

	public QueryHelper(Class clazz, String alias) {
		fromClause = "FROM" + clazz.getSimpleName() + " " + alias;
	}

}
