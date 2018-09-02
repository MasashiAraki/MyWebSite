<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ユーザ情報更新</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/common/shop-homepage.css" rel="stylesheet">
    <!-- Custom styles Footer CSS -->
    <link href="css/common/footer.css" rel="stylesheet">
   	<!-- Original CSS -->
    <link href="css/common/common.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand Bold text" href="Administrator">Coffee Specialty Shop</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">

					<li class="nav-item"><a class="nav-link" href="Index">一般に戻る</a>
					<li class="nav-item"><a class="nav-link" href="UserData">
						<c:out value="${udb_userInfo.name }"></c:out> </a>
					</li>
					<li class="nav-item">
						<c:choose>
							<c:when test="${udb_userInfo == null }"><a class="nav-link" href="Signin">サインイン</a></c:when>
							<c:otherwise><a class="nav-link" href="Signout">サインアウト</a></c:otherwise>
						</c:choose>
					</li>
				</ul>
			</div>
		</div>
    </nav>
	<!-- Page Content -->
	<div class="container">
		<div class="formdata">
		<form action="Admin_UserDataUpdate" method="post">
			<h3 class="mb-3 font-weight-normal">ユーザ情報の変更</h3>
			<h5 class="mb-3 text-danger font-weight-normal">${errorMessage }</h5>

			<div class="form-group row">
				<label for="name" class="col-sm-3 col-form-label">名前</label>
				<div class="col-sm-9">
					<input type="text" name="name" value="${udd.name }" class="form-control" required autofocus>
				</div>
			</div>

			<div class="form-group row">
				<label for="postCode" class="col-sm-3 col-form-label">郵便番号</label>
				<div class="col-sm-9 text-left">
					<input type="text" name="postCode" value="${udd.postcode }" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');">
				</div>
			</div>

			<div class="form-group row">
				<label for="address" class="col-sm-3 col-form-label">住所</label>
				<div class="col-sm-9">
					<input type="text" name="address" value="${udd.address }" class="form-control" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="staticLoginId" class="col-sm-3 col-form-label">ログインID</label>
				<div class="col-sm-9">
					<input type="text" readonly name="loginId" value="${udd.loginId }" class="form-control-plaintext" placeholder="tokyo">
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-3 col-form-label">パスワード</label>
				<div class="col-sm-9">
					<input type="password" name="password" class="form-control" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-3 col-form-label">パスワード <br>（確認）</label>
				<div class="col-sm-9">
					<input type="password" name="confirmPassword" class="form-control" required>
				</div>
			</div>

			<input type="hidden" name="id" value="${udd.id }">
			<button class="btn btn-lg btn-success btn-block" type="submit">更新</button>
			<hr>
			<a href="Administrator" >戻る</a>

		</form>
		</div>
	</div>
	<!-- /.container -->

    <!-- Footer -->
    <footer class="footer">
      <div class="container">
        <span class="text-white">Copyright &copy; My Website 2018</span>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

	<!-- Auto input address  https://github.com/ajaxzip3/ajaxzip3.github.io -->
	<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
</body>
</html>
