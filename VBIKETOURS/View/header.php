<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7">
<!--<![endif]-->
<head>
<!-- meta character set -->
<meta charset="utf-8">
<!-- Always force latest IE rendering engine or request Chrome Frame -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" href="img/favorite.png">
<title>VBIKETOURS - Discover Vietnam on Motorbikes</title>
<!-- Meta Description -->
<meta name="description" content="Motorbike tours in Vietnam">
<meta name="keywords"
	content="Vietnam saigon motorbike vbiketours mekong delta cuchi tunnel">
<meta name="author"
	content="Jean-Christophe LE BERRE - jcleberre22@gmail.com">

<!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS
	 ================================================== -->

<!-- Fontawesome Icon font -->
<!-- <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' type='text/css'> -->
<!-- Fontawesome Icon font -->
<link rel="stylesheet" href="view/css/font-awesome.min.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="view/css/jquery.fancybox.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="view/css/bootstrap.min.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="view/css/owl.carousel.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="view/css/slit-slider.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="view/css/animate.css">
<!-- Main Stylesheet -->
<link rel="stylesheet" href="view/css/main.css">
<!-- Tours Stylesheet -->
<link rel="stylesheet" href="view/css/tour.css">
<!-- Booking_form Stylesheet -->
<link rel="stylesheet" href="view/css/booking_form.css">
<!-- Cart Stylesheet -->
<link rel="stylesheet" href="view/css/cart.css">
<!-- Cart Stylesheet -->
<link rel="stylesheet" href="view/css/checkout_infos.css">
<!-- End CSS
	 ==================================================== -->

</head>
<body id="body" onload="_fixNavbarIssue()_">

	<!-- preloader -->
<!-- 	<div id="preloader"> -->
<!-- 		<div class="loader-box"> -->
<!-- 			<div class="battery"></div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<!-- end preloader -->

	<!--
        Fixed Navigation
        ==================================== -->
	<header id="navigation"
		class="navbar-inverse navbar-fixed-top animated-header">
		<div class="container">
			<div class="navbar-header">
				<!-- responsive nav button -->
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- /responsive nav button -->

				<!-- logo -->
				<p class="navbar-brand">
					<a href="index.php#home-slider"><img src="img/logo.png"></a>
				</p>
				<!-- /logo -->
			</div>

			<!-- main nav -->
			<nav class="collapse navbar-collapse navbar-right" role="navigation">
				<ul id="nav" class="nav navbar-nav">
					<li><a href="index.php#about">ABOUT US</a></li>
					<li><a href="index.php#tours">TOURS</a></li>
					<li><a href="index.php#news">NEWS</a></li>
					<li><a href="index.php#gallery">GALLERY</a></li>
					<li><a href="index.php#faq">FAQ</a></li>
					<li><a href="index.php#press">PRESS</a></li>
					<li><a href="index.php#testimonials">TESTIMONIAL</a></li>
					<li><a href="index.php#contact">CONTACT</a></li>
					<?php if (isset($_SESSION['cart'])){?>
					<li><a href="index.php?page=cart">My cart (<?php echo count($_SESSION['cart']->get_booking_list());?>)</a></li>
					<?php }?>
				</ul>
			</nav>
			<!-- /main nav -->

		</div>
	</header>
	<!--
        End Fixed Navigation
        ==================================== -->
	<main class="site-content" role="main">