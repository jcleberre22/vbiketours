
<!-- tours section -->
<section id="tours">
	<div class="container">
		<div class="row">

			<div class="sec-title text-center wow animated fadeInDown">
				<h2>OUR TOURS</h2>
			</div>
			<div id="list_tours">
			
<?php
foreach ( $tours_list as $tour ) {
?>
<a href="tour.php?tour_id=<?php echo $tour->get_id() ?>">
<?php	
	echo $tour->get_name () . '<BR/><BR/>';
?>
	
	</a>
<?php
	echo $tour->get_summary () . '<BR/><BR/>';
}
?>
			</div>
		</div>
	</div>
</section>
<!-- end tours section -->
