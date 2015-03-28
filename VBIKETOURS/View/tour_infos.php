
<div id="tour_infos" class="col-xs-9 col-md-6 col-lg-6">
	
	<div id="tour_infos_title" class="col-xs-5 col-md-5 col-lg-5">
		Fitness : <BR /><BR />
		Vehicle : <BR /><BR />
		Duration : <BR /><BR />
		Style : <BR /><BR />
		Route: <BR /><BR />
		Maximum Passengers : <BR /><BR />
		Price : <BR /><BR />
		Validity : <BR />
	</div>

	<div id="tour_infos_values" class="col-xs-7 col-md-7 col-lg-7">
		<?php
			echo $tour->get_fitness () . "<BR/><BR/>";
			echo $tour->get_vehicle () . "<BR/><BR/>";
			echo $tour->get_duration () . "<BR/><BR/>";
			echo $tour->get_style () . "<BR/><BR/>";
			echo $tour->get_route () . "<BR/><BR/>";
			echo $tour->get_nb_passenger_max () . "<BR/><BR/>";
			echo $tour->get_price () . "<BR/><BR/>";
			echo $tour->get_validity_start () . " - " . $tour->get_validity_end () . "<BR/><BR/>";
		?>				
	</div>

</div>