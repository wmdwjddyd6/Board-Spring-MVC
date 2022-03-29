<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>
<html>
<head>
<title>목록</title>
</head>
<body>
	<h1>게시글 목록</h1>

	<table border="1">
		<caption>List</caption>
		<thead>
			<tr align="center" bgcolor="white">
				<th>No</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="board" items="${boards}">
				<tr align="center" bgcolor="white">
					<td><c:out value="${board.id}"/></td>
					<td><c:out value="${board.title}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${board.createDate}"/></td>
					<td><c:out value="${board.views}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br />
	<a href="/">메인으로 돌아가기</a>

</body>
</html>