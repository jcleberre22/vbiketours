<section style="padding-top: 140px;">
	<div class="container">
		<div class="row">
			<div class="sec-title text-center wow animated fadeInDown">
				<h2>Payment confirmation</h2>
			</div>		
	<div style="text-align: center;">
	All the informations for your order are now completed!<br><br>
	Do you want to confirm the payment for the following order?
	<?php include 'view/sections/cart_section.php';?>
	<div class="col-xs-12" style="margin-top: 15px;">
	<div class="col-xs-12 col-md-6">
		<a  href="index.php?page=paypal_after_success&token=<?php echo $_GET['token'];?>" >
			<div style="width:100%;><button id="submit_confirm_payment" name="submit_confirm_payment" type="submit" class="btn-pink btn-effect col-xs-12 col-md-4">Confirm payment</button></div>
		</a>
		</div>
		<div class="col-xd-12 col-md-6" style="padding-left: 10px;">
		<a " href="index.php?page=paypal_cancel">
			<div style="width:100%;><button id="submit_cancel_payment" name="submit_cancel_payment" type="submit" class="btn-pink btn-effect col-xs-12 col-md-4">Cancel payment</button></div>
		</a>
		</div>
		</div>
	</div>
	</div>
	</div>
</section>