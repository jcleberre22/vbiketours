<?php include 'tools/read_more.php';?>
<!-- tours section -->
<section id="tours_section">
	<div class="container">
		<div class="row">

			<div class="sec-title text-center wow animated fadeInDown">
				<h2>OUR TOURS</h2>
			</div>
			<div id="list_tours" class="col-xs-12 col-md-12 col-lg-12">
			
			<?php foreach ( $tours_list as $tour ) {?>
				<div id="tours" class="col-xs-12 col-md-6 col-lg-4">
 					
 					<a href="index.php?page=tour&tour_id=<?php echo $tour->get_id() ?>">
 						<div id="tours_name" class="col-xs-12 col-md-12 col-lg-12">
							<b><?php echo $tour->get_name () . '<BR/><BR/>'; ?></b>
 						</div>
 					
 						<div id="tours_summary" class="col-xs-12 col-md-12 col-lg-12" style="background-image: url(./<?php echo "img/uploads/tours/".str_replace(" ", "_",$tour->get_name())."/".$tour->get_picture();?>)">	
						 	<div id="tours_summary_overlay">
								<b><?php	echo $tour->get_summary() . '<BR/><BR/>'; ?></b>
								<p style="text-align: justify;"> <?php 	echo read_more($tour->get_description(), 300); ?></p>
								
								
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
