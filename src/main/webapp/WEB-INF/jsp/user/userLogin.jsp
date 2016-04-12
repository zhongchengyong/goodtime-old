<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>欢迎登陆GoodTime</title>
	<script src="${pageContext.request.contextPath}/resources/js/userLogin.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<h2 style="text-align:center">欢迎登陆GoodTime</h2>
	<div style="margin:90px 0;"></div>
	<div class="easyui-panel" title="进入我的GoodTime" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:10px">
			<input id="username" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input id="password" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>记住我</span>
		</div>
		<div>
			<a href="javascript:userLogin()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
				<span style="font-size:14px;">登陆</span>
			</a>
		</div>
		<div id="dd" >   </div>  

	<a href="user/testRestful.do/1">测试restful</a>
	<a href="user/testMap.do">测试map</a>
	<a href="user/testTransaction.do">测试transaction</a>
	</div>
	<div>
	<form action="user/testFileupload.do" method="POST" enctype="multipart/form-data">
	file:<input type="file" name="file"/>
	<br>
	desc:<input type="text" name="desc"/>
	<br>
	<input type="submit" value="Submit"></input>
	</form>
	</div>
	<br><br><br>
	<div>
	<a href="user/testFileDownload">测试文件下载</a>
	</div>
</body>
</html>