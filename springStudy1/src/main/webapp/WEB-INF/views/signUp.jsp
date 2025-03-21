<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원가입
	<form method="post" action="/signUp">
		<input type="hidden" name="id">
		<input type="text" name="userId" placeholder="아이디"> <br>
		<input type="password" name="userPw" placeholder="비밀번호"> <br>
		<input type="email" name="userEmail" placeholder="이메일"> <br>
		<input type="text" name="userAddr" placeholder="주소"> <br>
		<input type="text" name="userJob" placeholder="직업"> <br>
		<input type="text" name="userLike" placeholder="좋아하는 것"> <br>
		<button>회원가입</button>
	</form>
</body>
</html>