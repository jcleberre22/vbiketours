
</main>
<!-- Footer -->
<footer id="footer">

<section id="follow_us_section">
		<div class="container">
			<div class="row" >
				<div class="sec-title text-center wow animated fadeInDown">
					<h2> Follow Us On</h2>
				</div>
		
				<div id="footer-social" class="footer-social">
					<ul class="footer_list">
						<li class="wow animated zoomIn"><a href="#"><i class="fa fa-thumbs-up fa-3x"></i></a></li>
						<li class="wow animated zoomIn" data-wow-delay="0.4s"><a href="#"><i class="fa fa-twitter fa-3x"></i></a></li>
						<li class="wow animated zoomIn" data-wow-delay="0.8s"><a href="#"><i class="fa fa-skype fa-3x"></i></a></li>
						<li class="wow animated zoomIn" data-wow-delay="1.2s"><a href="#"><i class="fa fa-youtube fa-3x"></i></a></li>
				</ul>
			</div>		
</section>

<section id="site_map_section" class="parallax">
<div class="container">
	<div class="row" >

		<div class="sec-title text-center wow animated fadeInDown">
			<h2>SITE MAP</h2>
		</div>
		
		<div id="tourlinks" class="links col-lg-4 col-md-4 col-xs-12">

				<li><a href="index.php#tours_section" style="text-decoration: underline; color: #feec02;">Our Tours</a></li>
				<p><br/></p>
				<?php
					$tour_dao = new TourDAO($db);
					$tours_list=array();
					$tours_list=$tour_dao->getList();
					foreach ( $tours_list as $tour ) {
				?>
				<li><a href="index.php?page=tour&tour_id=<?php echo $tour->get_id() ?>">
				<?php	
					echo $tour->get_name () ;
				?>
				</a></li>
				<?php }?>

		</div>
		
		<div id="navlinks"class="links col-lg-4 col-md-4 col-xs-12">

			<li><a href="#" style="text-decoration: underline; color: #feec02;">Navigation</a></li>
			<p><br/></p>
			<li><a href="index.php#about">About us</a></li>
			<li><a href="index.php#tours_section">Tours</a></li>
			<li><a href="index.php#news">News</a></li>
			<li><a href="index.php#gallery">Gallery</a></li>
			<li><a href="index.php#faq">Faq</a></li>
			<li><a href="index.php#press">Press</a></li>
			<li><a href="index.php#testimonials">Testimonial</a></li>
			<li><a href="index.php#contact">Contact</a></li>
			<?php if (isset($_SESSION['cart'])){?>
			<li><a href="index.php?page=cart">My cart (<?php echo count($_SESSION['cart']->get_booking_list());?>)</a></li>
			<?php }?>

		</div>
		
		<div id="newslinks"class="links col-lg-4 col-md-4 col-xs-12">

				<li><a href="index.php#news" style="text-decoration: underline; color: #feec02;">News</a></li>
				<p><br/></p>
				<?php
					foreach ( $tours_list as $tour ) {
				?>
				<li><a href="index.php?page=tour&tour_id=<?php echo $tour->get_id() ?>">
				<?php	
					echo $tour->get_name () ;
				?>
				</a></li>
				<?php }?>

		</div>
					
	</div>
</div>
</section>

</footer>
<!-- end Footer -->



<!-- jQuery Plugins
	 ================================================== -->

<!-- Modernizer Script for old Browsers -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Single Page Nav -->
<script src="js/jquery.singlePageNav.min.js"></script>
<!-- jquery.fancybox.pack -->
<script src="js/jquery.fancybox.pack.js"></script>
<!-- Owl Carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- jquery easing -->
<script src="js/jquery.easing.min.js"></script>
<!-- Fullscreen slider -->
<script src="js/jquery.slitslider.js"></script>
<script src="js/jquery.ba-cond.min.js"></script>
<!-- onscroll animation -->
<script src="js/wow.min.js"></script>
<!-- Custom Functions -->
<script src="js/main.js"></script>
<!-- gallery plugin -->
<script src="js/jquery.collagePlus.min.js"></script>
<!-- Parallax -->
<script src="js/jquery.parallax-1.1.3.js"></script>

<script src="js/bootstrap-formhelpers.min.js"></script>

<!-- End jQuery Plugins
	 ====================================================== -->

</body>
</html>
