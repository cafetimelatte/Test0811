<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$('#logout').click(function(){
		alert('로그아웃 되었습니다');
		location.href('/');
	});
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인페이지</title>
</head>
<body>
	<div style="float: left;">
	<h1>메인 페이지</h1>
	</div>
	<div style="margin-left: 500px;">
		${param.id }님 안녕하세요. <button id="logout" onclick=""><a href="logout">로그아웃</a></button><br/>
		포인트 : ${param.point }점
	</div>
	
	<hr/>
	
	<div style="padding: 50px;">
	<p>구입할 컨텐츠를 선택하세요.</p>
	<table>
		<tr>
			<td>
				<img src="resources/img/Intro_350_408.png">
			</td>
			<td>
				<img src="resources/img/Java_350_408.png">
			</td>
			<td>
				<img src="resources/img/Cpp_350_408.png">
			</td>
		</tr>
		<tr>
			<td>100,000포인트</td>
			<td>500,000포인트</td>
			<td>300,000포인트</td>
		</tr>
	</table>
	</div>
	
	<img src="resources/img/korea_it.png">
</body>
</html>