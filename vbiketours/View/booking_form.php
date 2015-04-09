<div id="booking" class="col-xs-12 col-md-11 col-lg-6">
	<form method="post" action="index.php?page=cart&action=add">

		<div>
			<table id="table_booking_tour" class="table table-bordered">
				<thead>
					<th colspan="2">$<?php echo $tour->get_price()?> per person, children get -50%</th>
				</thead>

				<tbody>
					<tr>
						<td>Choose date:</td>
						<td><input id="booking_date" name="booking_date" type="date" required="required" value="<?php echo date("Y-m-d");?>" min="<?php echo date("Y-m-d");?>" max="2099-12-31"/></td>
					</tr>
					<tr>
						<td>Number of adults:</td>
						<td><input type="number" id="booking_nb_adults" name="booking_nb_adults" value="1" min="1" max="50" required="required"> </td>
					</tr>
					<tr>
						<td>Number of children:</td>
						<td><input type="number" id="booking_nb_children" name="booking_nb_children" value="0" min="0" max="50"> &nbsp;(under 10 years old)</td>
					</tr>
				</tbody>

				<tfoot>
					<th id="validation_booking" colspan="2">Total :<?php echo " $".$tour->get_price()?></th>
				</tfoot>
			</table>
		</div>

		<input id="booking_tour_id" name="booking_tour_id" type="hidden"
			value="<?php echo $tour->get_id();?>"> <input id="booking_price"
			name="booking_price" type="hidden"
			value="<?php echo $tour->get_price();?>">
		<button id="submit_booking" name="submit_booking" type="submit"
			class=" btn-pink btn-effect col-xs-12 ">BOOK
			NOW</button>
	</form>
</div>