<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>購入履歴詳細</title>

	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

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
		<div class="row mx-auto">
			<h4 class="my-4 mx-auto font-weight-bold">購入履歴詳細</h4>
		</div>

		<div class="row mb-5">
			<div class="card card-body">
				<table class="table table-borderless text-center">
					<thead>
						<tr>
							<th scope="col">購入日時</th>
							<th scope="col">配送方法</th>
							<th scope="col">合計金額</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${bdb.buyDate }</td>
							<td>${bdb.deliveryMethodName }</td>
							<td>${bdb.totalPrice + bdb.deliveryMethodPrice }円</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<table class="table text-center">
				<thead>
					<tr>
						<th scope="col">商品名</th>
						<th scope="col">価格</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${buyHistoryList }">
						<tr>
							<td>${item.name }</td>
							<td>${item.price }円</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
