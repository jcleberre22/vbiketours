
<!-- tours section -->
<section id="tours_section">
	<div class="container">
		<div class="row">

			<div class="sec-title text-center wow animated fadeInDown">
				<h2>OUR TOURS</h2>
			</div>
			<div id="list_tours" class="col-xs-12 col-md-12 col-lg-12">
			
			<?php foreach ( $tours_list as $tour ) {?>
				<div id="tours" class="col-xs-12 col-md-6 col-lg-3">
 					<a href="index.php?page=tour&tour_id=<?php echo $tour->get_id() ?>">
 						<div id="tours_name">
							<?php echo $tour->get_name () . '<BR/><BR/>'; ?>
 						</div>
 						<div id="tours_summary" style="background-image: url(./<?php echo "img/uploads/tours/".str_replace(" ", "_",$tour->get_name())."/".$tour->get_picture();?>)">	
						 	<div id="tours_summary_overlay">
								<?php echo $tour->get_summary () . '<BR/><BR/>'; ?>
 							</div>
 						</div>
 					</a>
				</div>
				<?php }?>
			</div>
		</div>
	</div>
</section>
<!-- end tours section -->
