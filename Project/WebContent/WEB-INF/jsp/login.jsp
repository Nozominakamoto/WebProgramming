<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>login</title>
	<link href="css/original/common.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/UserManagement/css/login.css">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	<script src="js/bootstrap.min.js"></script>
</head>

<body>

   <c:if test="${userInfo != null}" >
	    <% response.sendRedirect("listS"); %>
   </c:if>

	<form class="form-inline" action="/UserManagement/loginS" method="post">

		<c:if test="${errMsg != null}" >
	    	<div class="alert alert-danger" role="alert">
		 	 	${errMsg}
			</div>
		</c:if>

		<h1 class="rogin">ログイン画面</h1>

		<div  class=form-login  >
			ログインID<input type = "text" name = "id"><br>
			パスワード<input type = "password" name = "pass"><br>
			<input type="submit" value="ログイン">
		</div>

	</form>
</body>
</html>