<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Signin Form</title>

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
			<a class="navbar-brand Bold text" href="index.html">Shop Name</a>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="formdata">
			<form>
				<h1 class="h3 mb-3 font-weight-normal">サインイン</h1>

				<div class="form-group row">
					<label for="inputLoginId" class="col-sm-3 col-form-label">ログインID</label>
					<div class="col-sm-9">
						<input type="text" id="loginId" class="form-control" required autofocus>
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-3 col-form-label">パスワード</label>
					<div class="col-sm-9">
						<input type="password" id="password" class="form-control" required>
					</div>
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">サインイン</button>
				<hr>
				<a href="register.html">アカウントを作成</a>
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

</body>
</html>
