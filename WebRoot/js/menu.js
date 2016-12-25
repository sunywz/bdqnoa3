var menu = {
	setting : {
		zTree : '',
		pNode : '',
		isSimpleData : true,
		treeNodeKey : "mid",
		treeNodeParentKey : "pid",
		showLine : true,
		root : {
			isRoot : true,
			nodes : []
		},
		callback : {
			click : zTreeOnClick
		},

	},

	loadMenuTree : function() {
		/*aaa
		 * 这是登陆成功后的菜单js，它不用传递参数，因为dao直接获取session里面的user，再根据user进行显示
		 */
		$.post("menuitemAction_showMenuitemsByUser.action", null,
				function(data) {
			menu.zTree =$("#menuTree").zTree(menu.setting, data.menuitemList);
			menu.zTree.expandAll(true);		
		});
	}
};

function zTreeOnClick(event, treeId, treeNode) {
	menu.pNode = treeNode;
	
	
	window.location = 'accessory_findAcfByid.action?parentId='+menu.pNode.mid;
};

$().ready(function() {
	menu.loadMenuTree();
	
	

});
