<!-- carts section -->
<?php
	if (isset($_SESSION['msg'])){
		if (($booking_msg=$_SESSION['msg'])!=""){
?>

<script type="text/javascript">alert("<?php echo $booking_msg; ?>")</script>

<?php 
	$_SESSION['msg']="";
		}
	}
?>
<section id="cart_section">
	<div class="container">
		<div class="row">
			<div class="sec-title text-center wow animated fadeInDown">
				<h2> YOUR CART </h2>
			</div>
			
			<?php if ($cart_empty){ ?>
			<div id="cart_empty">				
				Your cart is empty!<br><br>
				<a href="index.php">Back to the Main Page</a>
			</div>
	
			<?php }else { ?>						
		<div id="cart" class="col-xs-12 col-md-12 col-lg-offset-1 col-lg-10">
			<table id="cart_table" class="col-xs-12 col-md-12 col-lg-12">
			<thead>
				<tr id="cart_table_header">
					<th></th>
					<th></th>
					<th>Product</th>
					<th>Price (USD)</th>
				</tr>
			</thead>
			<tbody>	
					<?php
						$boooking_list=$_SESSION['cart']->get_booking_list();						
						foreach ($boooking_list as $booking){
							$booked_tour=$tour_dao->get($booking->get_tour_id());
					?>
					<tr id="cart_table_row">
						<td id="cart_table_delete" class="cart_table_row"><img id="cart_icon_delete"title="delete" src="img/icons/trash.png"></td>
						<td id="cart_table_picture" class="cart_table_row"><img id="cart_image_tour" src="img/uploads/tours/<?php echo str_replace(" ", "_",$booked_tour->get_name());?>/<?php echo $booked_tour->get_picture()?>"></td>
						<td id="cart_table_booking" class="cart_table_row">
							<?php echo "<br><b>".$booked_tour->get_name()."</b><br><br>";?>
							<?php echo "Date: ".$booking->get_date()."<br>Start time: ".$booked_tour->get_start_time()."<br><br>";?>
							<?php echo "Adults: ".$booking->get_nb_adults()."<br><br>";?>
							<?php echo "Childrens: ".$booking->get_nb_childrens()."<br><br>";?>
						</td>
						<td id="cart_table_price" class="cart_table_row">
							<?php echo "<br>".$booking->get_price()."$<br>";?>
						</td >
					</tr>
					<?php }?>
					</tbody>
					<tfoot>
						<tr id="cart_table_header">
							<th colspan="1">TOTAL:</th>
							<th colspan="2"></th>
							<th id="cart_price" colspan="1"><?php echo $cart->get_price()."$";?></th>
						</tr>
					</tfoot>
			</table>
		</div>
<?php }?>	
	</div>
</div>
</section>
<!-- end carts section -->
