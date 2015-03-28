<!-- carts section -->
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
						print_r($cart);
					}
				?>
			<div>
			
			</div>
			
		</div>
	</div>
</section>
<!-- end carts section -->
