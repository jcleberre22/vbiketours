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

						<div class="col-xs-4 col-md-4 col-lg-4">
							<label>Country</label>
							<label for="customer_first_name">First Name *</label><br>
							<label for="customer_last_name">Last Name *</label><br>
							<label for="customer_address_1">Address *</label><br>
							<label for="customer_address_2"></label><br>
							<label for="customer_city">Town / City *</label><br>
							<label for="customer_state">State / Country *</label><br>
							<label for="customer_postcode">Postcode / Zip *</label><br>
							<label for="customer_email">Email Address *</label><br>
							<label for="customer_phone">Phone *</label>
						</div>	
						
						<div class="col-xs-8 col-md-8 col-lg-8">				
							<select id="countries " name="countries">
								<option value="">Select a country&hellip;</option>
								<?php include 'tools/list_pays_select.php';?>
							</select>
							<input type="text" class="input-text" name="customer_first_name" id="customer_first_name"/>
							<input type="text" class="input-text" name="customer_last_name" id="customer_last_name"/>
							<input type="text" class="input-text" name="customer_address_1" id="customer_address_1" placeholder="Street address"/>
							<input type="text" class="input-text" name="customer_address_2" id="customer_address_2" placeholder="Apartment, suite, unit etc. (optional)"/>	
							<input type="text" class="input-text" name="customer_city"	id="customer_city" placeholder="Town / City"/>
							<input type="text" class="input-text" name="customer_state" id="customer_state" placeholder="State / Country" />
							<input type="text" class="input-text" name="customer_postcode"	id="customer_postcode" placeholder="Postcode / Zip"/>	
							<input type="text" class="input-text" name="customer_email" id="customer_email"/>
							<input type="text" class="input-text" name="customer_phone" id="customer_phone"/>
						</div>	
						
					</div>
					</div>	
					<div class="col-xs-12 col-md-6 col-lg-6">
					<div id="customer_infos_plus_title">

						<h3>Additional Informations</h3>
					</div>
					<div id="customer_infos_plus">
							<label for="pickup_location">Pickup Location *</label>
							<textarea name="pickup_location" class="input-text " id="pickup_location" placeholder="Pickup Location" rows="2" cols="5"></textarea>
						
							<label for="customer_detail">Additional Infomation</label>
							<textarea name="customer_detail" class="input-text " id="customer_detail" placeholder="Enter person name, email, phone for us to contact easily." rows="2" cols="5"></textarea>
					</div>
				</div>
			
			
			<div id='payment-options-form' class="col-xs-12 col-md-12 col-lg-12">
				<h3 class="widget-box-header">Payment Option</h3>
				<ul class="payment_options">
					<li id='payment-option-full' class="payment_option payment_option_full">
						<input id='pay-full-amount' name='payment-radio' type='radio' checked='checked' class='input-radio'/>
						<label for='pay-full-amount'>Pay full amount now </label>					
					</li>
					<li id='payment-option-partial'class="payment_option payment_option_later">
						<input id='pay-payment' name='payment-radio' type='radio' class='input-radio'/>
							<label for='pay-payment'>Pay in cash on the day of the tour</label>
					</li>
				</ul>
			</div>
			<div class="col-xs-12 col-md-12 col-lg-12">
			<?php include 'View/sections/cart_section.php';?>
			</div>
			<div id="checkout_infos_payment" class="col-md-12 col-sm-12 col-xs-12">			
					<ul class="payment_methods methods">
						<li class="payment_method_paypal">
							<input id="payment_method_paypal"	type="radio" class="input-radio" name="payment_method" value="paypal" checked='checked'	data-order_button_text="Proceed to PayPal" />
							<label for="payment_method_paypal">PayPal 
								<img src="/img/icons/paypal.png" alt="PayPal Acceptance Mark" />
								<a href="https://www.paypal.com/en/webapps/mpp/paypal-popup" class="about_paypal"
							   		onclick="javascript:window.open('https://www.paypal.com/en/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=1060, height=700'); return false;"
							   		title="What is PayPal?">What is PayPal?
								</a>
							</label>
							<div class="payment_box payment_method_paypal">
								<p>
									<strong>Please be sure to click 
										<img width="120" src="img/paypal_button.jpg" alt="PayPal Checkout Button"/>
										button on the paypal confirmation page after booking 
										<a href="img/paypal_help.jpg">(Click to View Picture)</a>
									</strong><br>
									so that you can return and view your booking details. Also, in
									case you have trouble making your paypal payment please send us
									an email<br> ( <a href="mailto:mail@vbiketours.com">mail@vbiketours.com</a>
									) and we&#8217;ll contact you to shortly to confirm your
									booking.
								</p>
							</div>
						</li>
					</ul>
				
					<div id="checkout_infos_submit">		
							<input type="submit" name="checkout_infos_submit" id="checkout_infos_submit" class="btn-pink" value="Proceed to Paypal" data-value="infos_submit" />
					</div>
			</div>
		</form>
	</div>
</div>
</section>
<!-- end checkout_infos section -->