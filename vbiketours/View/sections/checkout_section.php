<!-- checkout section -->
<section id="checkout">
	<div class="container">
		<div class="row">
			<div class="sec-title text-center wow animated fadeInDown">
				<h2>CHECKOUT</h2>
			</div>
			<?php 
			print_r($customer);
			echo "<br><br>";
			foreach ($customer_datas as $property => $value){
				echo $property.": ".$value."<br><br>";
			}
			
			?>
		</div>
	</div>
</section>