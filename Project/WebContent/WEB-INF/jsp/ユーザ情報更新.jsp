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
	<p class="text-white bg-secondary userName">
		ユーザ名さん&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A HREF="jump.html" class="text-danger">ログアウト</a>
	</p>
	<h1 class="title">ユーザ情報更新</h1>


	<div class=form-login >

		<p>ログインID<p/>

		<p>
		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">パスワード&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="password" id="inputPassword6"
					class="form-control mx-sm-3" aria-describedby="passwordHelpInline">
			</div>
		</form>
		<p/>

		<p>
		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">パスワード(確認)&nbsp;</label> <input
					type="password" id="inputPassword6" class="form-control mx-sm-3"
					aria-describedby="passwordHelpInline">
			</div>
		</form>
		<p/>

		<p>
		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">ユーザ名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="password" id="inputPassword6"
					class="form-control mx-sm-3" aria-describedby="passwordHelpInline">
			</div>
		</form>
		<p/>

		<p>
		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">生年月日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="password" id="inputPassword6"
					class="form-control mx-sm-3" aria-describedby="passwordHelpInline">
			</div>
		</form>
		<p/>

		<form class="form-inline">
			<button type="button" class="btn btn-outline-dark login-btn">更新</button>
		</form>
		<A HREF="jump.html">戻る</a>
	</div>

</body>
</html>