<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>カート</title>

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
			<h4 class="my-4 mx-auto font-weight-bold">ショッピングカート</h4>
		</div>
		<div class="row">
			<h5 class="mb-3 text-danger mx-auto font-weight-normal">${cartErrorMessage }</h5>
		</div>


		<form action="ItemDelete" method="post">
			<div class="row">
				<div class="col-lg-9">
					<table class="table">
						<thead>
							<tr class="text-center">
								<th scope="col">商品名</th>
								<th scope="col">価格</th>
								<th scope="col">数量</th>
								<th scope="col">削除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${cartItem }">
								<tr class="text-center">
									<td>${item.name }</td>
									<td>${item.price }円</td>
									<!-- 未実装：個数の変更 -->
									<td>1個</td>
									<td><input type="checkbox" name="delete_item_id" value="${item.id }"></td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>

				<div class="col-lg-3">
					<div class="card text-center">
						<div class="card-body">
							<a class="btn btn-primary  my-4" href="Buy" role="button">レジに進む</a>
							<button type="submit" class="btn btn-secondary">カートを更新</button>
						</div>
					</div>
				</div>
			</div>
		</form>
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
