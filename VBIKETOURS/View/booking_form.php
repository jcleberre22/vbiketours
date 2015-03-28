<div class="col-xs-9 col-md-6 col-lg-6">
	<form method="post" action="Controller/booking_ctl.php">
		
		<div id="booking_header">
			<?php 
				echo "$".$tour->get_price()." per person, childrens get -50%";
			?>
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
		<?php $_SESSION['tour']=$tour;?>
		<input id="submit_booking" name="submit_booking" type="submit" value="BOOK NOW">
		
	</form>
</div>