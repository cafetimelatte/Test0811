<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	if(request.getAttribute("msg")!=null){
%>
	<script>alert('${msg}');</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="registerAction" method="post">
		ID : <input type="text" name="id" placeholder="아이디 입력"/><br/>
		PW : <input type="password" name="pw" placeholder="비밀번호 입력"/><br/>
		NAME : <input type="text" name="name" placeholder="이름 입력"/><br/>
		<input type="submit" value="입력 완료"/>
	</form>
</body>
</html>