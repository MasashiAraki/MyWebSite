<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${udb_userInfo.name }さんの管理画面</title>

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
			<h4 class="my-4 mx-auto font-weight-bold">ユーザ情報</h4>
		</div>

		<div class="card card-body col-lg-7 mx-auto">
			<div class="row">
				<div class="col-lg-3">
					<small>ログインID</small>
					<p>${udb_userInfo.loginId }</p>
				</div>
				<div class="col-lg-9">
					<small>名前</small>
					<p>${udb_userInfo.name }</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3">
					<small>郵便番号</small>
					<p>${udb_userInfo.postcode }</p>
				</div>
				<div class="col-lg-9">
					<small>住所</small>
					<p>${udb_userInfo.address }</p>
				</div>
			</div>
			<div class="row">
				<a href="UserDataUpdate" class="btn btn-secondary my-4 mx-auto">ユーザ情報を変更</a>
			</div>
		</div>

		<div class="row mx-auto">
			<h4 class="my-4 mx-auto font-weight-bold">購入履歴</h4>
		</div>

		<div class="row">
			<table class="table table-hover text-center col-lg-9 mx-auto">
				<thead>
					<tr>
						<th scope="col">購入日時</th>
						<th scope="col">配送方法</th>
						<th scope="col">合計金額</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${buyDataList }">
					<tr data-href="BuyHistoryDetail?buy_id=${item.id }">
						<td>${item.buyDate }</td>
						<td>${item.deliveryMethodName }</td>
						<td>${item.totalPrice + item.deliveryMethodPrice }円</td>
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
        <span class="text-white">Copyright &copy; Coffee Specialty Shop</span>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

	<!-- adding_link_column https://www.webantena.net/javascriptjquery/jquery-tr-data-href/ -->
	<script>
		jQuery(function($) {
			$('tbody tr[data-href]').addClass('clickable').click(function() {
				window.location = $(this).attr('data-href');
			}).find('a').hover(function() {
				$(this).parents('tr').unbind('click');
			}, function() {
				$(this).parents('tr').click(function() {
					window.location = $(this).attr('data-href');
				});
			});
		});
	</script>
</body>

</html>
