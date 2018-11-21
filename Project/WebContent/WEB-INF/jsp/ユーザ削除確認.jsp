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

	<p class="text-white bg-secondary userName">
		ユーザ名さん&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A HREF="jump.html" class="text-danger">ログアウト</a>
	</p>

	<div class="form-delete">
		<h1 class="title">ユーザ削除確認</h1>

		<h5 class="contens">ログインID:id0001<br>
							を本当に削除してよろしいでしょうか。</h5>

		<div class="btn-toolbar">
		<form class="form-inline">
			<button type="button" class="btn btn-outline-dark login-btn">キャンセル</button>
		</form>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<form class="form-inline">
			<button type="button" class="btn btn-outline-dark login-btn">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OK&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
		</form>
		</div>

	</div>

</body>
</html>