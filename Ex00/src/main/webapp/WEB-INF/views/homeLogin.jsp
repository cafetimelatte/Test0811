<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>

<%
	if(request.getAttribute("msg")!=null){
%>
	<script>alert('${msg}');</script>
<%
	}
%>

<html>
<head>
	<title>로그인</title>
</head>
<body>
	<form action="LoginAction" method="post">
		ID : <input type="text" name="id" placeholder="아이디 입력"/><br/>
		PW : <input type="password" name="pw" placeholder="비밀번호 입력"/><br/>
		<input type="submit" value="로그인"/>
		<button><a href="register">회원가입</a></button>
	</form>
</body>
</html>
