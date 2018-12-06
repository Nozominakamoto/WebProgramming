<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="update.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>update</title>
</head>

<body>

<c:if test="${userInfo == null}" >
	  <% response.sendRedirect("loginS"); %>
 </c:if>

	<p class="text-white bg-secondary userName">
		${userInfo.name}さん&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A HREF="logoutS" class="text-danger">ログアウト</a>
	</p>
	<h1 class="title">ユーザ情報更新</h1>


	<div class=form-login >
		<form class=form-inline action="/UserManagement/updateS" method="post">
		<input type="hidden" name="Id" value="${Id}">

		<c:if test="${errMsg != null}" >
	    	<div class="alert alert-danger" role="alert">
		 	 	${errMsg}
			</div>
		</c:if>

		<div  class=form-signUp  >
			ログインID:${UpDataId.loginId}<br>
			パスワード:<input type = "password" name = "pass" ><br>

			パスワード(確認):<input type = "password" name = "confirmPass"><br>

			ユーザ名:<input type = "text" name = "name" value = "${UpDataId.name}"><br>
			生年月日:<input type = "date" name = "birthday" value = "${UpDataId. birthDate}"><br>

			<input type="submit" value="更新">
		</div>

	</form>
		<A HREF="listS">戻る</a>
	</div>

</body>
</html>