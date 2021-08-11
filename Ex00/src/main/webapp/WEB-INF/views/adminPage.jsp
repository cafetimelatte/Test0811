<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <script>
	$('#delet').click(function(){
		alert('삭제되었습니다');
		location.reload();
	});
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<style>
	table,tr,td{
	border:1px solid;
	}
</style>
<body>
	<table>
		<tr>
			<td>
				아이디
			</td>
			<td>
				이름
			</td>
			<td>
				포인트
			</td>
			<td>
				수정
			</td>
			<td>
				삭제
			</td>
		</tr>
		<c:forEach items="${memberList }" var="memberList">
		
		<tr>
			<td>
				${memberList.id}
			</td>
			<td>
				${memberList.name }
			</td>
			<td>
				1000
			</td>
			<td>
				<button><a href="update">수정하기</a></button>
			</td>
			<td>
				<button><a href="delete">삭제하기</a></button>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<button><a href="start">스케줄러(20초마다 포인트 1증가)실행 시작</a></button>
	<button id="delete"><a href="end">스케줄러 실행종료</a></button><br/>
	
</body>
</html>