<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>signUp</title>
	<link href="css/original/common.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/UserManagement/css/signUp.css">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	<script src="js/bootstrap.min.js"></script>
</head>

<body>

<c:if test="${userInfo == null}" >
	  <% response.sendRedirect("loginS"); %>
 </c:if>

	<p class="text-white bg-secondary userName">
		${userInfo.name}さん&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A HREF="logoutS" class="text-danger">ログアウト</a>
	</p>
	<h1 class="title">ユーザ新規登録</h1>

	<form class=form-inline action="/UserManagement/signUpS" method="post">

		<c:if test="${errMsg != null}" >
	    	<div class="alert alert-danger" role="alert">
		 	 	${errMsg}
			</div>
		</c:if>

		<div  class=form-signUp  >
			ログインID<input type = "text" name = "loginId"><br>
			パスワード<input type = "password" name = "pass"><br>
			パスワード(確認)<input type = "password" name = "confirmPass"><br>
			ユーザ名<input type = "text" name = "name"><br>
			生年月日<input type = "date" name = "birthday"><br>

			<input type="submit" value="登録">
		</div>

	</form>
		<A HREF="listS">戻る</a>


</body>
</html>