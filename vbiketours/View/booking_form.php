<div id="booking" class="col-xs-12 col-md-11 col-lg-6">
	<form method="post" action="index.php?page=cart&action=add">
		
		<div id="booking_header">
	
			$<?php echo $tour->get_price()?> per person, childrens get -50%

		</div>
		
		<div id="booking_box">
			Choose date: <input id="booking_date" name="booking_date" type="date"/><br><br>
			Number of adults: 
			<select id="booking_nb_adults" name="booking_nb_adults">
				<?php for ($nb_pers = 1; $nb_pers <= 50; $nb_pers ++){?>
				<option><?php echo $nb_pers;?></option><?php }?>
			</select><br><br>
			Number of childrens:
			<select id="booking_nb_childrens" name="booking_nb_childrens">
				<?php for ($nb_child = 0; $nb_child <= 50; $nb_child ++){?>
				<option><?php echo $nb_child;?></option><?php }?>
			</select>
			&nbsp;(under 10 years old)
			<br>
		</div>
		
		<div id="booking_validation">
			Total :<?php echo " $".$tour->get_price()?>
		</div>
		<input id="booking_tour_id" name="booking_tour_id" type="hidden" value="<?php echo $tour->get_id();?>">
		<input id="booking_price" name="booking_price" type="hidden" value="<?php echo $tour->get_price();?>">
		<input id="submit_booking" name="submit_booking" type="submit" class=" btn-pink col-xs-12 col-sm-offset-8 col-sm-4 col-md-offset-8 col-md-4 col-lg-offset-8 col-lg-4" value="BOOK NOW">
		
	</form>
</div>