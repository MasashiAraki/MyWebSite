<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>管理画面</title>

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
			<a class="navbar-brand Bold text" href="Administrator">Coffee Specialty Shop</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">

					<li class="nav-item"><a class="nav-link" href="Index">一般に戻る</a>
					<li class="nav-item"><a class="nav-link" href="UserData">
						<c:out value="${udb_userInfo.name }"></c:out> </a>
					</li>
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
		<div class="row mt-4">
			<div class="col-2">
				<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<a class="nav-link ${ isUserNavActive }" id="v-pills-customer-tab" data-toggle="pill" href="#v-pills-customer" role="tab" aria-controls="v-pills-customer"aria-selected=true>顧客情報</a>
					<a class="nav-link ${ isItemNavActive }" id="v-pills-item-tab" data-toggle="pill" href="#v-pills-item" role="tab" aria-controls="v-pills-item" aria-selected="true">商品一覧</a>
				</div>
				<hr>
				<a class="btn btn-outline-primary" href="Admin_ItemAdd" role="button">商品追加</a>
			</div>

			<div class="col-10">
				<div class="tab-content" id="v-pills-tabContent">
					<div class="tab-pane fade ${ isUserTabActive }" id="v-pills-customer"
						role="tabpanel" aria-labelledby="v-pills-customer-tab">
						<form action="Admin_UserSearch" method="get">
							<div class="form-row">
								<div id="form-group col-lg-3">
									<select class="custom-select" name="searchUserCategoryId">
										<option value="1" ${ isLoginIdActive }>ログインID</option>
										<option value="2" ${ isNameActive }>ユーザ名</option>
									</select>
								</div>
								<div class="form-group col-lg-7">
									<input type="text" name="searchWord" class="form-control">
								</div>
								<div class="col-lg-2">
									<button class="btn btn-primary btn-block" type="submit">検索</button>
								</div>
							</div>
						</form>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">ログインID</th>
									<th scope="col">ユーザ名</th>
									<th scope="col">住所</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${userList }">
								<c:if test="${user.loginId != 'admin' }">
									<tr>
										<td scope="row" class="align-middle">${user.loginId }</td>
										<td class="align-middle">${user.name }</td>
										<td class="align-middle">${user.address }</td>
										<td>
											<div class="btn-group" role="group" aria-label="基本のボタングループ">
												<a class="btn btn-primary" href="Admin_UserDataDetail?user_id=${user.id }">詳細</a>
												<a class="btn btn-success" href="Admin_UserDataUpdate?user_id=${user.id }">更新</a>
												<a class="btn btn-danger" href="Admin_UserDataDelete?user_id=${user.id }">削除</a>
											</div>
										</td>
									</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="tab-pane fade ${ isItemTabActive }" id="v-pills-item"
						role="tabpanel" aria-labelledby="v-pills-item-tab">
						<form action="Admin_ItemSearch" method="get">
							<div class="form-row">
								<div id="form-group col-lg-3">
									<select class="custom-select" name="searchItemCategoryId">
										<option value="1">商品名</option>
									</select>
								</div>
								<div class="form-group col-lg-7">
									<input type="text" name="searchWord" class="form-control">
								</div>
								<div class="col-lg-2">
									<button class="btn btn-primary btn-block" type="submit">検索</button>
								</div>
							</div>
						</form>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">商品ID</th>
									<th scope="col">商品名</th>
									<th scope="col">カテゴリ</th>
									<th scope="col">単価</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${itemList }">
									<tr>
										<td scope="row" class="align-middle">${item.id }</td>
										<td class="align-middle">${item.name }</td>
										<td class="align-middle">${item.categoryName }</td>
										<td class="align-middle">${item.price }円</td>
										<td>
											<div class="btn-group" role="group" aria-label="基本のボタングループ">
												<a class="btn btn-primary" href="Admin_ItemDetail?item_id=${item.id }">詳細</a>
												<a class="btn btn-success" href="Admin_ItemUpdate?item_id=${item.id }">更新</a>
												<a class="btn btn-danger" href="Admin_ItemDelete?item_id=${item.id }">削除</a>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
