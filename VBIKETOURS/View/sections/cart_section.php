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
<section id="cart">
	<div class="container">
		<div class="row">

			<div class="sec-title text-center wow animated fadeInDown">
				<h2> YOUR CART </h2>
			</div>
			
<?php 
	if ($cart_empty){
	echo "your cart is empty";
	}else {
?>						
			<table>
				<tr>
					<th></th>
					<th></th>
					<th>Product</th>
					<th>Total Price</th>
					</tr>
					<?php
						$boooking_list=$_SESSION['cart']->get_booking_list();						
						foreach ($boooking_list as $booking){
							$booked_tour=$tour_dao->get($booking->get_tour_id());
					?>
					<tr>
						<td></td>
						<td></td>
						<td>
							<?php echo "<br>".$booked_tour->get_name()."<br>";?>
							<?php echo "Tour Date: ".$booking->get_date().", start at ".$booked_tour->get_start_time()."<br><br>";?>
							<?php echo "Adults: ".$booking->get_nb_adults()."<br><br>";?>
							<?php echo "Childrens: ".$booking->get_nb_childrens()."<br><br>";?>
						</td>
						<td>
							<?php echo "<br>".$booking->get_price()."<br>";?>
						</td>
					</tr>
					<?php }?>
			</table>
<?php }?>	
		</div>
	</div>
</section>
<!-- end carts section -->
