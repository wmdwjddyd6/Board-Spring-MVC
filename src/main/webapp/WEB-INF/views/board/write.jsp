<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>
<html>
<head>
<title>글쓰기</title>
</head>
<body>
	<h1>글쓰기 화면</h1>

	<form>
		제목 <br />
		<input size="120" type="text" id="title" name="title" value="${board.title}" /> <br /> <br />
		내용 <br />
		<textarea cols="100" rows="13" id="content" name="content"><c:out value="${board.content}"></c:out></textarea>
		<button type="button" id="write_btn">작성</button>
	</form>

	<a href="/">메인으로 돌아가기</a>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="/resources/js/write.js"></script>
	
</body>
</html>