<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>学生列表</h4>
<tbody>
<div class="container-wrap">
    <table class="table table-hover">
        <tr class="active">
            <td><strong>学号</strong></td>
            <td><strong>姓名</strong></td>
            <td><strong>性别</strong></td>
            <td><strong>生日</strong></td>
            <td><strong>班级</strong></td>
            <td><strong>操作</strong></td>
        </tr>
        <c:forEach var="student" items="${list}">
            <tr>
                <td>${student.number}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${student.gradeId}</td>
                <td><a href="${ctx}/update-view?id=${student.studentId}">
                	<span class="glyphicon glyphicon-pencil"></span></a>&nbsp; &nbsp;<a
                        href="javascript:if(confirm('确实要删除该条记录吗？'))location='${ctx}/deleteStudent?id=${student.studentId}'"
                        style="cursor: pointer"><span
                        class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
    </table>

</div>
</tbody>
</body>
</html>