<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
function testAjax(){
	var url="${pageContext.request.contextPath}/test/testAjax.do";
	//window.alert("${pageContext.request.contextPath}");
   	$.post("test/testAjax.do",
			{id:1},
			function(result){
				if(result==true) window.alert("yes");
				else window.alert("no");
			}
	);   
	
/*   	$.ajax({
  		type:"post",
		url: "${pageContext.request.contextPath}/test/testAjax",
		dataType: 'jsonp',
		data:"id="+1,
		success:function(result){
			if(result==true) window.alert("yes");
			else window.alert("no");
		}
	});  */
/* 	 $.ajax({
	      url:'login',
	      type:'POST',
	      data:data, 
	      success:function(data, status){
	        if (status == 'success') {
	          location.href = 'home';
	          console.log('status = ' + status);
	          console.log('success');
	        }
	      },
	      error:function(data, status, e){
	        if (status == 'error') {
	          location.href = 'login';
	          console.log('status = ' + status);
	          console.log('error');
	        }
	      }
	    }); */
}

</script>
</head>
<body>
<h2>Hello World!</h2>
<a href="list">listAllStudent</a>
<a href='javascript:testAjax()'>testAjax</a>
<br>
<div id="p" class="easyui-panel" style="width:500px;height:200px;padding:10px;"
        title="My Panel" iconCls="icon-save" collapsible="true">
    The panel content
</div>

<br>
<input class="easyui-combobox" name="language"
        data-options="
            url:'combobox_data.json',
            valueField:'id',
            textField:'text',
            panelHeight:'auto',
            onSelect:function(record){
                alert(record.text)
            }">
<br>
<input id="email" class="easyui-validatebox" data-options="required:true,validType:'email'">
</body>
</html>
