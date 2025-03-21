<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인
	<form method="post" action="/signIn">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" placeholder="아이디"/>
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" id="pw" placeholder="비밀번호"/>
		<button>로그인</button>
	</form>
</body>
</html>