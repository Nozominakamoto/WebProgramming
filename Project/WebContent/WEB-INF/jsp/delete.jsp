<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="delete.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>delete</title>
</head>
<body>

<c:if test="${userInfo == null}" >
	  <% response.sendRedirect("loginS"); %>
 </c:if>

	<p class="text-white bg-secondary userName">
		${userInfo.name}さん&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A HREF="logoutS" class="text-danger">ログアウト</a>
	</p>

	<div class="form-delete">
		<h1 class="title">ユーザ削除確認</h1>

		<h5 class="contens">ログインID:${UserData.loginId}<br>
							を本当に削除してよろしいでしょうか。</h5>

		<div class="btn-toolbar">


				<a class="cancel" href="listS">キャンセル</a>

			<form action = "/UserManagement/deleteS" method = "post">
				<input type="hidden" name="id" value="${id}">
				<input type="submit" value = "OK">
			</form>
		</div>

	</div>

</body>
</html>