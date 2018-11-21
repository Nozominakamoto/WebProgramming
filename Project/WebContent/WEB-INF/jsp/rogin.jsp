<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="rogin.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>rogin</title>
</head>

<body>

	<h1 class="rogin">ログイン画面</h1>

	<div class=form-login>

		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">ログインID</label> <input type="password"
				id="inputPassword6" class="form-control mx-sm-3" aria-describedby="passwordHelpInline">
			</div>
		</form>

		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">パスワード</label> <input type="password"
					id="inputPassword6" class="form-control mx-sm-3"
					aria-describedby="passwordHelpInline">
			</div>
		</form>

		<form class="form-inline">
			<button type="button" class="btn btn-outline-dark login-btn">ログイン</button>
		</form>

	</div>

</body>
</html>