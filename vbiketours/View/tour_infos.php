
<div id="tour_infos" class="col-xs-12 col-md-11 col-lg-6">

	<div>
		<table id="table_infos_tour" class="table table-bordered">
			<thead>
				<th colspan="2">Tour start at <?php echo $tour->get_start_time();?></th>
			</thead>

			<tbody>
				<tr>
					<td>Fitness :</td>
					<td><?php echo $tour->get_fitness ();?></td>
				</tr>
				<tr>
					<td>Vehicle :</td>
					<td><?php echo $tour->get_vehicle ();?></td>
				</tr>
				<tr>
					<td>Duration :</td>
					<td><?php echo $tour->get_duration ();?></td>
				</tr>
				<tr>
					<td>Route:</td>
					<td><?php echo $tour->get_route ();?></td>
				</tr>
				<tr>
					<td>Maximum Passengers :</td>
					<td><?php
					
					if ($tour->get_nb_passenger_max () != 0)
						echo $tour->get_nb_passenger_max ();
					else
						echo "Unlimited";?>
					
					</td>
				</tr>
				<tr>
					<td>Style :</td>
					<td><?php echo $tour->get_style ();?></td>
				</tr>
				<tr>
					<td>Price :</td>
					<td><?php echo "$".$tour->get_price ();?></td>
				</tr>
				<tr>
					<td>Validity :</td>
					<td><?php echo $tour->get_validity_start () . " - " . $tour->get_validity_end ();?></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>