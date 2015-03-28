<!-- tours section -->
<section id="tour">
	<div class="container">
		<div class="row">

			<div class="sec-title text-center wow animated fadeInDown">
				<h2> <?php echo $tour -> get_name();?> </h2>
			</div>
			<div id="description_tour" class="col-xs-9 col-md-6 col-lg-6">			
				<?php
					echo "<b>".$tour->get_summary ()."</b><BR/><BR/>";
					echo str_replace("- ","<BR/><BR/>- ", $tour->get_description ())."<BR/><BR/>";

				?>
			</div>
				<div id="image_tour" class="col-xs-9 col-md-6 col-lg-6">
					<img 	id="image_tour"	
							alt="<?php echo $tour->get_picture();?>" 
							src="img/uploads/tours/<?php echo $tour->get_name ();?>/<?php echo $tour->get_picture ();?>"
					/>	
				</div>
				<div class="col-xs-12 col-md-12 col-lg-12"><p><br></p></div>
				<?php include 'View/tour_infos.php';?>
				<?php include 'View/booking_form.php';?>
		</div>
	</div>
</section>
<!-- end tours section -->