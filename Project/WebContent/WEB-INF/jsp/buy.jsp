<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Buy</title>

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
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">

					<!-- 管理画面はadminアカウントでサインインしている時だけ表示 -->
					<li class="nav-item"><a class="nav-link" href="administrator.html">管理画面</a></li>
					<li class="nav-item"><a class="nav-link" href="userdata.html">ユーザ名</a></li>
					<li class="nav-item"><a class="nav-link" href="cart.html">カート</a></li>
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
		<div class="row center">
			<h4 class="my-4 mx-auto font-weight-bold">注文内容の確認</h4>
		</div>

		<div class="row">
			<div class="col-lg-9">
				<table class="table">
					<thead>
						<tr class="text-center">
							<th scope="col">商品名</th>
							<th scope="col">価格</th>
							<th scope="col">数量</th>
						</tr>
					</thead>
					<!-- 表示テスト用 -->
					<tbody>
						<tr class="text-center">
							<td>Echo Dot</td>
							<td>5980円</td>
							<td>1個</td>
						</tr>
						<tr class="text-center">
							<td>Fire TV</td>
							<td>8980円</td>
							<td>1個</td>
						</tr>
						<tr class="text-center">
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>

				</table>
			</div>

			<div class="col-lg-3">
				<div class="card text-center">
					<div class="card-body">
						<h4 class="card-title">合計：15460円</h4>
						<p>商品の小計：14960円</p>
						<p>送料：500円</p>
						<a class="btn btn-primary" href="buycomplete.html" role="button">購入する</a>
					</div>
				</div>

			</div>
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
