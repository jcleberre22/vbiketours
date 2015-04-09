<!-- checkout_infos section -->
<section id="checkout_details">
	<div class="container">
		<div class="row">
			<div class="sec-title text-center wow animated fadeInDown">
				<h2>Checkout Details</h2>
			</div>		
			<form name="checkout" method="post" class="checkout" action="index.php?page=checkout">
			
				<div id="customer_infos" class="col-xs-12 col-md-6 col-lg-6">
				<div id="customer_infos_title">
					<h3>Your Informations</h3>
				</div>
					<div class="customer_details">
						<table class="table table bordered">
							<tbody>
								<tr>
									<td>Country *</td>
									<td>
									<div class="bfh-selectbox bfh-countries" data-flags="true" data-country="VN"" data-name="customer_country" data-value="VN" data-filter="true" data-blank="false">
</div>
									
									<!--<select id="customer_country " name="customer_country" class="select">
								<option value="">Select a country;</option>
								<?php include 'tools/list_pays_select.php';?>
							</select>-->
							</td>
								</tr>
								<tr>
									<td>First Name *</td>
									<td><input type="text" name="customer_first_name" id="customer_first_name" class="input-text"  required/></td>
								</tr>
								
								<tr>
									<td>Last Name *</td>
									<td><input type="text" name="customer_last_name" id="customer_last_name" class="input-text"  required/></td>
								</tr>
								<tr>
									<td>Address *</td>
									<td><input type="text" name="customer_address_1" id="customer_address_1" class="input-text"  placeholder="Street address" required/></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="text" name="customer_address_2" id="customer_address_2" class="input-text"  placeholder="Apartment, suite, unit etc. (Optional)"/></td>
								</tr>
								<tr>
									<td>Town / City *</td>
									<td><input type="text" name="customer_city"	id="customer_city" class="input-text"  placeholder="Town/City" required/></td>
								</tr>
								<tr>
									<td>State / Country *</td>
									<td><input type="text" name="customer_state" id="customer_state" class="input-text"  placeholder="State/Country" required /></td>
								</tr>
								<tr>
									<td>Postcode / Zip *</td>
									<td><input type="number" name="customer_post_code"	id="customer_post_code" class="input-number"  pattern="[0-9]{5}" placeholder="Postcode/Zip (ex: 12345)" min="0" required/></td>
								</tr>
								<tr>
									<td>Email Address *</td>
									<td><input type="email" name="customer_email" id="customer_email" class="input-email" placeholder="ex: azerty@mail.com" required/></td>
								</tr>
								<tr>
									<td>Phone *</td>
									<td><input type="tel" name="customer_phone" id="customer_phone" placeholder='Phone number' class="input-tel" required/></td>
								</tr>
								
							</tbody>
						</table>

						
					</div>
					</div>	
					<div class="col-xs-12 col-md-6 col-lg-6">
					<div id="customer_infos_plus_title">

						<h3>Additional Informations</h3>
					</div>
					<div id="customer_infos_plus">
							<label>Pickup Location *</label>
							<textarea name="customer_pickup_location" id="customer_pickup_location" class="input-text "  placeholder="Pickup Location" rows="4" cols="5" required></textarea>
							<br><br>
							<label>Additional Infomation</label>
							<textarea name="customer_additional_infos" id="customer_additional_infos" class="input-text "  placeholder="Enter person name, email, phone for us to contact easily. (Optional)" rows="4" cols="5"></textarea>
					</div>
				</div>
			
			
			<div id='payment-options' class="col-xs-12 col-md-12 col-lg-12">
				<h3>Payment Option</h3>

					<div id='payment-option-full' class="payment_option payment_option_full">
						<input id='pay-full-amount' name='payment_type' type='radio' checked='checked' class='input-radio' value="full"/>
						<label for='pay-full-amount'>Pay full amount now</label>					
					</div>
					<div id='payment-option-cash'class="payment_option payment_option_cash">
						<input id='pay-cash' name='payment_type' type='radio' class='input-radio' value="cash"/>
							<label for='pay-cash'>Pay in cash on the day of the tour</label>
					</div>

			</div>
			<div class="col-xs-12 col-md-12 col-lg-12">
			<?php include 'View/sections/cart_section.php';?>
			</div>
			<div id="checkout_infos_payment" class="col-md-12 col-sm-12 col-xs-12">			

				<input id="payment_method_paypal"	type="radio" class="input-radio" name="payment_method" value="paypal" checked='checked'	data-order_button_text="Proceed to PayPal" />
				<label for="payment_method_paypal">PayPal 
				<img src="img/icons/paypal.png" alt="PayPal Acceptance Mark" />
				<a href="https://www.paypal.com/en/webapps/mpp/paypal-popup" class="about_paypal"
				   onclick="javascript:window.open('https://www.paypal.com/en/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=1060, height=700'); return false;"
				   title="What is PayPal?">What is PayPal?
				</a><br>
			</label>
			<div class="payment_box payment_method_paypal">
				<p>
					If you have any trouble for your paypal payment,
					please send us an email at <br> ( <a href="index.php#contact">vbiketourstest@gmail.com</a> ), 
					we&#8217;ll contact you shortly to confirm your booking.
				</p>
			</div>
			</div>		
			<div id="checkout_infos_submit">
				<button id="checkout_infos_submit" name="checkout_infos_submit" type="submit" class="btn-pink btn-effect col-xs-12 col-md-4">
					<div id="proceed">Proceed to PayPal</div>
					<div id="confirm" style="display: none;">Confirm your Order</div>
				</button>
			</div><br>
			<div id="sandbox_infos" class="col-xs-12"><br><br>
				<p>For the tests on PayPal sandbox (development API) use the followings identifiants:<br><br></p>
				<p>Login:    vbiketourstest-buyer@gmail.com<br>
				Password: 123vb123
				
				</p>
				
			</div>
		
	</form>
</div>
</div>
</section>
<!-- end checkout_infos section -->