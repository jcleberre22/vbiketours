<!-- carts section -->
<?php 
include 'tools/alert_message_session.php'; 

$cart_page=false;
if ($_GET['page']=='cart'){
	$cart_page=true;
}
?>

<section id="cart_section">
	<div class="container">
		<div class="row">
			<div class="sec-title text-center wow animated fadeInDown">
				<h2> <?php if (!$cart_page)echo "YOUR ORDER";
						   else echo "YOUR CART";
			  ?></h2>
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
					<?php if ($cart_page) echo"<th></th>"; ?>
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
					<?php if ($cart_page) 
						echo"<td id=\"cart_table_delete\" class=\"cart_table_row\">
								<img id=\"cart_icon_delete\"title=\"delete\" src=\"img/icons/trash.png\">
							</td>"; ?>
						<td id="cart_table_picture" class="cart_table_row">
							<img id="cart_image_tour" src="img/uploads/tours/<?php echo str_replace(" ", "_",$booked_tour->get_name());?>/<?php echo $booked_tour->get_picture()?>">
						</td>
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
							<th>TOTAL:</th>
							<?php if ($cart_page) echo"<th colspan=\"2\"></th>";
							else echo "<th></th>";?>
							<th id="cart_price"><?php echo $cart->get_price()."$";?></th>
						</tr>
					</tfoot>
			</table>
		</div>
		<?php if ($cart_page) echo "<a href=\"index.php?page=checkout_infos\">Proceed Checkout</a>";		 
		}?>	
	</div>
</div>
</section>
<!-- end carts section -->
