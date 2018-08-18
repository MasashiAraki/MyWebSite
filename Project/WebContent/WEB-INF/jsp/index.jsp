<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>index</title>

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
        <a class="navbar-brand Bold text" href="index.html">Coffee Shop</a>
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

			<!-- 新商品やおすすめなどの画像を表示する -->
			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide mt-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="img/banners/img_recommend.jpg"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="img/banners/img_newItem.jpg"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="img/banners/img_2018kessansale.jpg"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<!-- 商品をランダムに表示する -->
				<div class="row">

					<div class="col-lg-4 col-md-6 mt-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/coffee/kenya_king.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="item.html">ケニヤ キング</a>
								</h4>
								<h5>1,230円</h5>
								<p class="card-text">シトラスやマンゴーを思わせる印象的なアロマ、さらに完熟フルーツのような甘みと、明るくいきいきとした酸味が特徴です。</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mt-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/coffee/pike_place.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="item.html">パイクプレイス ロースト</a>
								</h4>
								<h5>1,140円</h5>
								<p class="card-text">ココアや煎ったナッツのようなほのかな香ばしさに、バランスのとれたなめらかな口あたりが特徴のコーヒー。一日を通して、また毎日でもお楽しみいただけます。</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mt-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/coffee/bird_friendly_blend.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="item.html">バードフレンドリー ブレンド</a>
								</h4>
								<h5>999円</h5>
								<p class="card-text">渡り鳥が休息する森で生まれたバードフレンドリー(R)認証コーヒーのみでブレンドした柔らかな口あたりと甘い余韻が特徴のコーヒーです。</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mt-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/coffee/iced_coffee_blend.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="item.html">アイスコーヒー ブレンド</a>
								</h4>
								<h5>1,080円</h5>
								<p class="card-text">すっきりした苦みの中に、深いコクと甘みを感じるタリーズコーヒーのアイスコーヒーブレンド。ブラックでお召し上がりいただくと、豆そのものが持つ力強い風味をお楽しみいただけます。</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mt-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/coffee/colombia.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="item.html">コロンビア</a>
								</h4>
								<h5>1,140円</h5>
								<p class="card-text">ナッツを感じさせる風味が特徴のすっきりとしたバランスのとれたコーヒー。秘峰アンデス山脈の高地で栽培されたコーヒーです。</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mt-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/coffee/decaf_ethiopia.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="item.html">デカフェ エチオピア</a>
								</h4>
								<h5>1,280円</h5>
								<p class="card-text">エチオピアのコーヒー豆らしい、華やかな香りとフルーティーな味わいをお楽しみいただけます。滑らかな甘みが、心地よい余韻となって口の中に広がります。</p>
							</div>
						</div>
					</div>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

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
