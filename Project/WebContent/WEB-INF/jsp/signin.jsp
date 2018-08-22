<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>サインイン</title>

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
			<a class="navbar-brand Bold text" href="Index">Coffee Specialty Shop</a>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="formdata">
			<h3 class="mb-3 font-weight-normal">サインイン</h3>
			<h5 class="mb-3 text-danger font-weight-normal">${errorMessage }</h5>

			<form action="Signin" method="post">
				<div class="form-group row">
					<label for="inputLoginId" class="col-sm-3 col-form-label">ログインID</label>
					<div class="col-sm-9">
						<input type="text" name="loginId" class="form-control" required autofocus>
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-3 col-form-label">パスワード</label>
					<div class="col-sm-9">
						<input type="password" name="password" class="form-control" required>
					</div>
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">サインイン</button>
			</form>

				<hr>
				<a href="Register">アカウントを作成</a>
		</div>
	</div>
	<!-- /.container -->

    <!-- Footer -->
    <footer class="footer">
      <div class="container">
        <span class="text-white">Copyright &copy; Coffee Specialty Shop</span>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>
