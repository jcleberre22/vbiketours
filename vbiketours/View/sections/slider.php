<!--
Home Slider
==================================== -->

<section id="home-slider">

<noscript> <div style="display:none"> </noscript>
	
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

				<div class="bg-img" style="height:100%; background-image: url(./<?php echo $directory; echo $image;?>);"></div>

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

	<noscript></div><div class="sl-slider-wrapper" style="background-image: url(./img/uploads/slider/1.jpg);"> </noscript>
	
</section>

<!--
End Home SliderEnd
==================================== -->