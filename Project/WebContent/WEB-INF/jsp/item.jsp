<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.name }</title>

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
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">

					<!-- 管理画面はadminアカウントでサインインしている時だけ表示 -->
					<li class="nav-item">
						<c:if test="${udb_userInfo.loginId == 'admin' }">
							<a class="nav-link" href="Administrator">管理画面</a></c:if>
					</li>
					<li class="nav-item"><a class="nav-link" href="UserData">
						<c:out value="${udb_userInfo.name }"></c:out> </a>
					</li>
					<li class="nav-item"><a class="nav-link" href="Cart">カート</a></li>
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

		<div class="row">
			<div class="col-lg-3">
			<!-- 未実装：検索機能 -->
				<form action="ItemSearchResult" >
					<input class="form-control my-5" type="text" placeholder="商品を検索">
				</form>

				<div class="list-group">
					<a href="Item_Coffee" class="list-group-item">コーヒー豆</a>
					<a href="Item_Cuptumbler" class="list-group-item">マグ&タンブラー</a>
					<a href="Item_Coffeeappliance" class="list-group-item">抽出器具</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="card mt-4">
					<img class="card-img-top img-fluid"
						src="img/coffee/${item.fileName }" alt="">
					<div class="card-body">
						<h3 class="card-title">${item.name }</h3>
						<h4>${item.price }円</h4>
						<p class="card-text">${item.detail }</p>
						<form action="ItemAdd" method="post">
							<div class="form-group">
								<input type="hidden" name="item_id" value="${item.id }">
								<button type="submit" class="btn btn-primary">カートに追加</button>
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
        <span class="text-white">Copyright &copy; Coffee Specialty Shop</span>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

</body>

</html>
