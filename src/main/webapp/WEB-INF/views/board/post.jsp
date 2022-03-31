<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>
<html>
<head>
<title>게시글 상세 화면</title>
</head>
<body>
	<h1>게시글 상세 화면</h1>

	<input type="hidden" value="${board.id}" />
	
	<h2>
		제목 :
		<c:out value="${board.title}" />
	</h2>
	내용
	<br />
	<textarea rows="13" style="background-color: white;" readonly><c:out value="${board.content}" /></textarea> <br /><br />
	<a type="button" href="/board/write?boardId=${board.id}">수정하기</a>
	<a href="/">메인으로 돌아가기</a>

</body>
</html>