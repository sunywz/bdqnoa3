<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>文档管理</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}
/* 两列右侧自适应布局 */
.left-fixed_right-auto {
	width: 100%;
	height: 200px;
	clear: both;
	display: inline-block;
	margin-top: 20px;
}

.left {
	position: relative;
	float: left;
	width: 200px; /* 数值核心1 */
	height: 100%;
	margin-right: -200px; /* 数值核心2 */
	background: whilte;
}

.right {
	float: right;
	width: 100%;
	height: 100%;
	background: whilte;
}

.right-content {
	margin-left: 200px; /* 数值核心3 */
	height: 100%;
	background: whilte;
}
</style>
<script language="JavaScript" src="js/jquery-ztree-2.5.js"></script>
<script language="JavaScript" src="js/menu.js"></script>
<link rel="stylesheet" href="zTreeStyle/zTreeStyle.css" type="text/css">

<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<body>

	<div class="left-fixed_right-auto">
		<div class="left">
			<%@ include file="left.jsp"%>
		</div>
		<div class="right">
			<div class="right-content">
				<!--页面标题-->
				<%-- 	<div id="Title_bar">
					<div id="Title_bar_Head">
						<div id="Title_Head"></div>
						<div id="Title">
							
							<img border="0" width="13" height="13"
								src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
							文档管理
						</div>
						<div id="Title_End"></div>
					</div>
				</div>
 --%>

				<div id="MainArea" align="right">
					<table cellspacing="0" cellpadding="0" class="TableStyle">

						<!-- 表头-->
						<thead>
							<tr align=center valign=middle id=TableTitle>
								<td width="100">文件名称</td>
								<td width="100">类型</td>
								<td width="100">备注</td>
								<td width="100">所有者</td>
								<td width="100">创建日期</td>

								<td width="100">操作</td>


							</tr>
						</thead>


						<tbody id="TableData" class="dataContainer" datakey="userList">

							<s:iterator value="#accessoryFileList">
								<tr class="TableDetail1 template">
									<td>${accessoryName}&nbsp;</td>
									<td>${accessoryType}</td>
									<td>${accessoryType}</td>

									<td>${accessoryType}</td>

									<td>${createDate}&nbsp;</td>



									<td><s:a action="user_delete?id=%{id}"
											onclick="return delConfirm()">删除</s:a> <s:a
											action="user_editUI?id=%{id}">下载</s:a>
									</td>
								</tr>
							</s:iterator>

						</tbody>
					</table>

					<!-- 其他功能超链接 -->
					<div id="TableTail">
						<div id="TableTail_inside">
							<s:a action="user_addUI">
								<img
									src="${pageContext.request.contextPath}/style/images/createNew.png" />
							</s:a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>









</body>
</html>
