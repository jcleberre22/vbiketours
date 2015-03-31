
</main>
<!-- Footer -->
<footer id="footer">
<div class="container">
	<div class="row" >

		<div class="sec-title text-center wow animated fadeInDown">
			<h2>SITE MAP</h2>
		</div>

		<div class="col-lg-3 col-md-3 col-xs-3">
			<iframe id=fb_frame
				src="//www.facebook.com/plugins/likebox.php?href=https://www.facebook.com/pages/Vbiketours/1468819633364888?fref=ts;width=270&amp;height=235&amp;colorscheme=light&amp;show_faces=true&amp;header=true&amp;stream=false&amp;show_border=true&amp;appId=359340147575210"></iframe>
		</div>
		
		<div class="col-lg-3 col-md-4 col-xs-10">
			<ul class="footer_list">
				<li>Navigation</li>
					<p><br/></p>
					<li><a href="index.php#about">About us</a></li>
					<li><a href="index.php#tours">Tours</a></li>
					<li><a href="index.php#news">News</a></li>
					<li><a href="index.php#gallery">Gallery</a></li>
					<li><a href="index.php#faq">Faq</a></li>
					<li><a href="index.php#press">Press</a></li>
					<li><a href="index.php#testimonials">Testimonial</a></li>
					<li><a href="index.php#contact">Contact</a></li>
					<?php if (isset($_SESSION['cart'])){?>
					<li><a href="index.php?page=cart">My cart (<?php echo count($_SESSION['cart']->get_booking_list());?>)</a></li>
					<?php }?>
			</ul>
		</div>
		
		<div class="col-lg-3 col-md-4 col-xs-10">
					<ul class="footer_list">
				<li>Our Tours</li>
				<p><br/></p>
				<?php
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
			</ul>
		</div>
		
		<div class="col-lg-3 col-md-8 col-xs-10">
					<ul class="footer_list">
				<li>News</li>
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
			</ul>
		</div>
		
		<div id="separator" class="col-lg-12 col-md-12 col-xs-12">
		<p><br/></p>
		</div>
		
		<div class="col-lg-12 col-md-12 col-xs-12" id="follow_us" >
		<br/>Follow Us On
		<a><img alt="" src=""/></a>
		</div>
		
	</div>
</div>
</footer>
<!-- end Footer -->



<!-- jQuery Plugins
	 ================================================== -->

 <!-- Main jQuery -->
<script src="js/jquery-2.0.2.min.js"></script>
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
<!-- NavBar links fix -->
<script src="js/navbar_links_fix.js"></script>
<!-- Parallax -->
<script src="js/jquery.parallax-1.1.3.js"></script>
<!-- End jQuery Plugins
	 ====================================================== -->

</body>
</html>
