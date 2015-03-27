
<!-- tours section -->
<section id="tours">
<div class="container">
<div class="row">

<div class="sec-title text-center wow animated fadeInDown">
<h2> OUR TOURS</h2>
</div>

<?php

foreach ($tours_list as $tour){

	echo $tour->get_name().'<BR/><BR/>';
	echo $tour->get_summary().'<BR/><BR/>';
	echo str_replace("- ", "<BR/><BR/>- ", $tour->get_description()).'<BR/>';

}
?>

		</div>
	</div>
</section>
<!-- end tours section -->
