<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Admin Item Update</title>

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
				<h1 class="h3 mb-3 font-weight-normal">商品情報の変更</h1>

				<div class="form-group row">
					<label for="inputItemFile" class="col-sm-3 col-form-label">商品ID</label>
					<div class="col-sm-9">
						<input type="number" readonly id="itemId" class="form-control" placeholder="1">
					</div>
				</div>

				<div class="form-group row align-middle">
					<label for="inputItemFile" class="col-sm-3 col-form-label">商品名</label>
					<div class="col-sm-9">
						<input type="text" id="itemName" class="form-control" placeholder="アイスコーヒーブレンド">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputCategory" class="col-sm-3 col-form-label">カテゴリ</label>
					<div class="col-sm-9">
						<input type="text" id="category" class="form-control" placeholder="コーヒー豆">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPrice" class="col-sm-3 col-form-label">単価</label>
					<div class="col-sm-9">
						<input type="number" id="price" min="1" class="form-control" placeholder="1080">
					</div>
				</div>

				<div class="form-group row">
					<label for="inptCount" class="col-sm-3 col-form-label">個数</label>
					<div class="col-sm-9">
						<input type="number" id="count" min="1" class="form-control" placeholder="10">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputItemDetail" class="col-sm-3 col-form-label">商品詳細</label>
					<div class="col-sm-9 text-left">
						<textarea id="itemDetail" rows="5" class="form-control" placeholder="すっきりした苦みの中に、深いコクと甘みを感じるタリーズコーヒーのアイスコーヒーブレンド。ブラックでお召し上がりいただくと、豆そのものが持つ力強い風味をお楽しみいただけます。"></textarea>
					</div>
				</div>

				<button class="btn btn-lg btn-success btn-block" type="submit">変更</button>
				<hr>
				<a href="administrator.html">戻る</a>

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
