<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원정보 수정
	<form method="post" action="/memberModify">
		<input type="text" name="id" placeholder="아이디"> <br>
		<input type="password" name="pw" placeholder="비밀번호"> <br>
		<input type="email" name="email" placeholder="이메일"> <br>
		<input type="text" name="addr" placeholder="주소"> <br>
		<input type="text" name="job" placeholder="직업"> <br>
		<input type="text" name="like" placeholder="좋아하는 것"> <br>
		<button>정보수정</button>
	</form>
</body>
</html>