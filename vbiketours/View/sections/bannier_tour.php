<!--
BANNIER TOUR
==================================== -->

<section id="home-slider">
	<div id="slider" class="sl-slider-wrapper">

		<div class="sl-slider">
<?php
$directory="img/uploads/slider/";
$list_img = list_folder($directory);

foreach ( $list_img as $image ) {
	?>
			<div class="sl-slide" data-orientation="vertical"
				data-slice1-rotation="-25" data-slice2-rotation="-25"
				data-slice1-scale="2" data-slice2-scale="2">

				<div class="bg-img" style="background-image: url(./<?php echo $directory; echo $image;?>);"></div>

				<div class="slide-caption">
					<div class="caption-content">
						<h2>DISCOVER VIETNAM ON MOTORBIKES</h2>
						<span>Come in and find out the best tour for you</span>
					</div>
				</div>

			</div>
<?php }?>
		</div>
	</div>
</section>

<!--
End BANNIER_TOUR
==================================== -->