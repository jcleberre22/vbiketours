
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
				<li>Our Tours</li>
				<p><br/></p>
				<?php
					foreach ( $tours_list as $tour ) {
				?>
				<li><a href="tour.php?tour_id=<?php echo $tour->get_id() ?>">
				<?php	
					echo $tour->get_name () ;
				?>
				</a></li>
				<?php }?>
			</ul>
		</div>
		
		<div class="col-lg-3 col-md-4 col-xs-10">
					<ul class="footer_list">
				<li>Our Tours</li>
				<p><br/></p>
				<?php
					foreach ( $tours_list as $tour ) {
				?>
				<li><a href="tour.php?tour_id=<?php echo $tour->get_id() ?>">
				<?php	
					echo $tour->get_name () ;
				?>
				</a></li>
				<?php }?>
			</ul>
		</div>
		
		<div class="col-lg-3 col-md-8 col-xs-10">
					<ul class="footer_list">
				<li>Our Tours</li>
				<p><br/></p>
				<?php
					foreach ( $tours_list as $tour ) {
				?>
				<li><a href="tour.php?tour_id=<?php echo $tour->get_id() ?>">
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



<!-- Essential jQuery Plugins
		================================================== -->
<!-- Main jQuery -->
<script src="/VBIKETOURS/js/jquery-1.11.1.min.js"></script>
<!-- Twitter Bootstrap -->
<script src="/VBIKETOURS/js/bootstrap.min.js"></script>
<!-- Single Page Nav -->
<script src="/VBIKETOURS/js/jquery.singlePageNav.min.js"></script>
<!-- jquery.fancybox.pack -->
<script src="/VBIKETOURS/js/jquery.fancybox.pack.js"></script>
<!-- Owl Carousel -->
<script src="/VBIKETOURS/js/owl.carousel.min.js"></script>
<!-- jquery easing -->
<script src="/VBIKETOURS/js/jquery.easing.min.js"></script>
<!-- Fullscreen slider -->
<script src="/VBIKETOURS/js/jquery.slitslider.js"></script>
<script src="/VBIKETOURS/js/jquery.ba-cond.min.js"></script>
<!-- onscroll animation -->
<script src="/VBIKETOURS/js/wow.min.js"></script>
<!-- Custom Functions -->
<script src="/VBIKETOURS/js/main.js"></script>
<!-- gallery plugin -->
<script src="/VBIKETOURS/js/jquery.collagePlus.min.js"></script>
</body>
</html>
