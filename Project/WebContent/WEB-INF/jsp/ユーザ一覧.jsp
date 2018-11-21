<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="list.css">
<title>list</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>

<body>

	<p class="text-white bg-secondary userName">
		ユーザ名さん&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A HREF="jump.html"
			class="text-danger">ログアウト</a>
	</p>

	<h1 class="list">ユーザ一覧</h1>

	<p class="regist">
		<A HREF="jump.html">新規登録</a>
	</p>

	<div class=form-list>

		<p>
		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">ログインID</label> <input type="password"
					id="inputPassword6" class="form-control mx-sm-3"
					aria-describedby="passwordHelpInline">
			</div>
		</form>
		</p>

		<p>
		<form class="form-inline">
			<div class="form-group">
				<label for="inputPassword6">ユーザ名&nbsp;&nbsp;&nbsp;</label> <input
					type="password" id="inputPassword6" class="form-control mx-sm-3"
					aria-describedby="passwordHelpInline">
			</div>
		</form>
		</p>

		<form>
			<div>
				<div style="display: inline-flex">
					<label for="bday">生年月日</label> <input type="date" id="bday"
						name="bday">〜 <input type="date" id="bday" name="bday">
				</div>
			</div>
		</form>

		<form class="search">
			<button type="button" class="btn btn-outline-dark login-btn">検索</button>
		</form>


	</div>

	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">ログインID</th>
					<th scope="col">ユーザID</th>
					<th scope="col">生年月日</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">id0001</th>
					<td>田中太郎</td>
					<td>1989年04月26日</td>
					<td><a class="btn btn-primary" href="#" role="button">詳細</a> <a
						class="btn btn-success" href="#" role="button">更新</a> <a
						class="btn btn-danger" href="#" role="button">削除</a></td>
				</tr>
				<tr>
					<th scope="row">id0002</th>
					<td>佐藤二郎</td>
					<td>2001年11月12日</td>
					<td><a class="btn btn-primary" href="#" role="button">詳細</a> <a
						class="btn btn-success" href="#" role="button">更新</a> <a
						class="btn btn-danger" href="#" role="button">削除</a></td>
				</tr>
				<tr>
					<th scope="row">id0003</th>
					<td>佐川真司</td>
					<td>2000年01月01日</td>
					<td><a class="btn btn-primary" href="#" role="button">詳細</a> <a
						class="btn btn-success" href="#" role="button">更新</a> <a
						class="btn btn-danger" href="#" role="button">削除</a></td>
				</tr>
			</tbody>
		</table>
	</div>


</body>

</html>