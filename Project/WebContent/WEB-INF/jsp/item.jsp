<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Item</title>

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
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
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

		<div class="row">
			<div class="col-lg-3">
				<form action="itemsearchresult.html" >
					<input class="form-control my-5" type="text" placeholder="商品を検索">
				</form>

				<div class="list-group">
					<a href="item_coffee.html" class="list-group-item">コーヒー豆</a>
					<a href="item_cuptumbler.html" class="list-group-item">マグ&タンブラー</a>
					<a href="item_coffeeappliance.html" class="list-group-item">抽出器具</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="card mt-4">
					<img class="card-img-top img-fluid"
						src="img/coffee/kenya_king.jpg" alt="">
					<div class="card-body">
						<h3 class="card-title">ケニヤ キング</h3>
						<h4>1,230円</h4>
						<p class="card-text">シトラスやマンゴーを思わせる印象的なアロマ、さらに完熟フルーツのような甘みと、明るくいきいきとした酸味が特徴です。</p>
						<form>
							<div class="form-group">
								<a class="btn btn-primary" href="cart.html">カートに追加</a>
							</div>
						</form>
					</div>
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

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
