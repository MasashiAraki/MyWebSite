<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Admin User Data Update</title>

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
        <a class="navbar-brand Bold text" href="administrator.html">Shop Name【管理者】</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">

					<li class="nav-item"><a class="nav-link" href="index.html">一般に戻る</a>
					<li class="nav-item"><a class="nav-link" href="userdata.html">ユーザ名</a></li>
					<li class="nav-item">
						<!-- サインイン時は「サインアウト」に表記が変わるようにする -->
						<a class="nav-link" href="signin.html">サインイン</a>
					</li>
				</ul>
			</div>
		</div>
    </nav>

	<!-- Page Content -->
	<div class="container">
		<div class="formdata">
		<form>
			<h1 class="h3 mb-3 font-weight-normal">ユーザ情報の変更</h1>

			<div class="form-group row">
				<label for="name" class="col-sm-3 col-form-label">名前</label>
				<div class="col-sm-9">
					<input type="text" id="name" class="form-control" placeholder="東京都庁" required autofocus>
				</div>
			</div>

			<div class="form-group row">
				<label for="postCode" class="col-sm-3 col-form-label">郵便番号</label>
				<div class="col-sm-9 text-left">
					<input type="text" id="postCode" placeholder="1638001" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');">
				</div>
			</div>

			<div class="form-group row">
				<label for="address" class="col-sm-3 col-form-label">住所</label>
				<div class="col-sm-9">
					<input type="text" name="addr11" id="address" class="form-control" placeholder="東京都新宿区西新宿２丁目８−１" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="staticLoginId" class="col-sm-3 col-form-label">ログインID</label>
				<div class="col-sm-9">
					<input type="text" readonly id="itemId" class="form-control-plaintext" placeholder="tokyo">
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-3 col-form-label">パスワード</label>
				<div class="col-sm-9">
					<input type="password" id="password" class="form-control" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-3 col-form-label">パスワード <br>（確認）</label>
				<div class="col-sm-9">
					<input type="password" id="password" class="form-control" required>
				</div>
			</div>

			<button class="btn btn-lg btn-success btn-block" type="submit">更新</button>
			<hr>
			<a href="administrator.html" >戻る</a>

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
