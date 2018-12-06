<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Data.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Data</title>
</head>

<body>

<c:if test="${userInfo == null}" >
	  <% response.sendRedirect("loginS"); %>
 </c:if>

<p class="text-white bg-secondary userName">
		${userInfo.name}さん&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A HREF="logoutS" class="text-danger">ログアウト</a> </p>
<h1 class="title">ユーザ情報詳細参照</h1>



<div class="data" style="white-space:pre-wrap;">



	ログインID ${UserData.loginId}

	ユーザ名   ${UserData.name}

	生年月日   ${UserData.birthDate}

	登録日時   ${UserData.createDate}

	更新日時   ${UserData.updateDate}




<A HREF="listS">戻る</a>
</div>




</body>
</html>