<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="list.css">
<title>list</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

</head>

<body>

 <c:if test="${userInfo == null}" >
	  <% response.sendRedirect("loginS"); %>
 </c:if>

	<p class="text-white bg-secondary userName">
		${userInfo.name}さん
		<A HREF="logoutS" class="text-danger">ログアウト</a>
	</p>

	<h1 class="list">ユーザ一覧</h1>

	<p>
		<A HREF="signUpS" class="regist">新規登録</a>
	</p>

	<div class=form-list>

	<p>
		<form class="form-inline" action = "listS" method = "post">
			<div class="form-group">
				<label for="inputPassword6">ログインID</label> <input type="text"
					name = "loginId" class="form-control mx-sm-3"
					aria-describedby="passwordHelpInline">
			</div>

	</p>

	<p>

			<div class="form-group">
				<label for="inputPassword6">ユーザ名&nbsp;&nbsp;&nbsp;</label> <input
					type="text" name="name" class="form-control mx-sm-3"
					aria-describedby="passwordHelpInline">
			</div>

	</p>


			<div>
				<div style="display: inline-flex">
					<label for="bday">生年月日</label> <input type="date"
						name="date"> 〜 <input type="date" name="day">
				</div>
			</div>



			<input type="submit" value="検索">
		</form>


	</div>

	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">ログインID</th>

					<th scope="col">ユーザ名</th>
					<th scope="col">生年月日</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>


				<c:if test="${userInfo.loginId == 'admin'}">
					<tr>
					 <c:forEach var="User" items="${UserList}">
					<tr>
						<td>${User.loginId}</td>
						<td>${User.name}</td>
						<td>${User.birthDate}</td>
						<td>
		                 	  <a class="btn btn-primary" href="dataS?id=${User.id}">詳細</a>
		                      <a class="btn btn-success" href="updateS?id=${User.id}">更新</a>
		                      <a class="btn btn-danger" href ="deleteS?id=${User.id}">削除</a>
			            </td>
					</tr>
					 </c:forEach>
					</tr>
				</c:if>


				<c:if test="${userInfo.loginId != 'admin'}">
					<tr>
					 <c:forEach var="User" items="${UserList}">
					<tr>
						<td>${User.loginId}</td>
						<td>${User.name}</td>
						<td>${User.birthDate}</td>
						<td>

							<c:if test="${userInfo.loginId == User.loginId}">
			                      <a class="btn btn-primary" href="dataS?id=${User.id}" >詳細</a>
			                      <a class="btn btn-success" href="updateS?id=${User.id}">更新</a>
			                </c:if>

							<c:if test="${userInfo.loginId != User.loginId}">
			                      <a class="btn btn-primary" href="dataS?id=${User.id}">詳細</a>

			                </c:if>
			           </td>
					</tr>
					 </c:forEach>
					</tr>
				</c:if>


			</tbody>
		</table>
	</div>


</body>

</html>