<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'tree.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.get("dept.action", function(json){
			$("#resultDiv").html(json.str1);
			$("#tree").tree({
				data:json.itemsList,
				onClick:function(node){
					loadGrid(node.id);
				}
			});
		});
		
	});
	
	function loadGrid(currentId){
		$("#mytable").datagrid({
			url:"searchAllACCByPno.action?parentId="+currentId,
					columns:[ [ {
						field : 'accessoryName',
						title : 'accessoryName',
						width : 100
					}, {
						field : 'accessoryType',
						title : 'accessoryType',
						width : 100
					}, {
						field : 'createDate',
						title : 'createDate',
						width : 100
					}, {
						field : 'accessoryPath',
						title : 'accessoryPath',
						width : 100
					} ] ],
					pagination : true,
					pageNumber : 1,
					pageSize : 5,
					pageList : [ 5, 10 ],
					//singleSelect:true,
					rownumbers : true
			
		});
	}	
</script>
</head>

<body>
	<h2>easy ui tree</h2>
	<div align="left"  style="width:120px;">
		<ul id="tree"></ul>
	</div>
	<div id="mytable"></div>
	
</body>
</html>
