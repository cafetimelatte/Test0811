<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$('#logout').click(function(){
		alert('�α׾ƿ� �Ǿ����ϴ�');
		location.href('/');
	});
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
</head>
<body>
	<div style="float: left;">
	<h1>���� ������</h1>
	</div>
	<div style="margin-left: 500px;">
		${param.id }�� �ȳ��ϼ���. <button id="logout" onclick=""><a href="logout">�α׾ƿ�</a></button><br/>
		����Ʈ : ${param.point }��
	</div>
	
	<hr/>
	
	<div style="padding: 50px;">
	<p>������ �������� �����ϼ���.</p>
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
			<td>100,000����Ʈ</td>
			<td>500,000����Ʈ</td>
			<td>300,000����Ʈ</td>
		</tr>
	</table>
	</div>
	
	<img src="resources/img/korea_it.png">
</body>
</html>