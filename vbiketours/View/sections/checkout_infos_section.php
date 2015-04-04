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
							<label>First Name *</label><br>
							<label>Last Name *</label><br>
							<label>Address *</label><br>
							<label><br><br></label>
							<label>Town / City *</label><br>
							<label>State / Country *</label><br>
							<label>Postcode / Zip *</label><br>
							<label>Email Address *</label><br>
							<label>Phone *</label>
						</div>	
						
						<div class="col-xs-8 col-md-8 col-lg-8">				
							<select id="customer_country " name="customer_country" class="select">
								<option value="">Select a country;</option>
								<?php include 'tools/list_pays_select.php';?>
							</select>
							<input type="text" name="customer_first_name" id="customer_first_name" class="input-text" />
							<input type="text" name="customer_last_name" id="customer_last_name" class="input-text" />
							<input type="text" name="customer_address_1" id="customer_address_1" class="input-text"  placeholder="Street address"/>
							<input type="text" name="customer_address_2" id="customer_address_2" class="input-text"  placeholder="Apartment, suite, unit etc. (optional)"/>	
							<input type="text" name="customer_city"	id="customer_city" class="input-text"  placeholder="Town/City"/>
							<input type="text" name="customer_state" id="customer_state" class="input-text"  placeholder="State/Country" />
							<input type="number" name="customer_post_code"	id="customer_post_code" class="input-number"  pattern="[0-9]{5}" placeholder="Postcode/Zip (ex: 12345)"/>	
							<input type="email" name="customer_email" id="customer_email" class="input-email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="ex: azerty@mail.com" required/>
							<input type="tel" name="customer_phone" id="customer_phone" pattern='[\+]\d{2}[\(]\d{2}[\)]\d{4}[\-]\d{4}' placeholder='Format: +99(99)9999-9999' class="input-tel"/>
						</div>	
						
					</div>
					</div>	
					<div class="col-xs-12 col-md-6 col-lg-6">
					<div id="customer_infos_plus_title">

						<h3>Additional Informations</h3>
					</div>
					<div id="customer_infos_plus">
							<label>Pickup Location *</label>
							<textarea name="customer_pickup_location" id="customer_pickup_location" class="input-text "  placeholder="Pickup Location" rows="4" cols="5"></textarea>
							<br><br>
							<label>Additional Infomation</label>
							<textarea name="customer_additional_infos" id="customer_additional_infos" class="input-text "  placeholder="Enter person name, email, phone for us to contact easily." rows="4" cols="5"></textarea>
					</div>
				</div>
			
			
			<div id='payment-options' class="col-xs-12 col-md-12 col-lg-12">
				<h3>Payment Option</h3>
				<ul class="payment_options_list">
					<li id='payment-option-full' class="payment_option payment_option_full">
						<input id='pay-full-amount' name='payment_type' type='radio' checked='checked' class='input-radio' value="full"/>
						<label for='pay-full-amount'>Pay full amount now </label>					
					</li>
					<li id='payment-option-cash'class="payment_option payment_option_cash">
						<input id='pay-cash' name='payment_type' type='radio' class='input-radio' value="cash"/>
							<label for='pay-cash'>Pay in cash on the day of the tour</label>
					</li>
				</ul>
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
					<strong>Please be sure to click 
						<img width="120" src="img/paypal_button.jpg" alt="PayPal Checkout Button"/>
						button on the paypal confirmation page after the operation. 
						<a href="img/paypal_help.jpg">(Click to View Picture)</a>
					</strong><br>
					So you could view your booking details.If you have any trouble for your paypal payment,
					please send us an email at <br> ( <a href="mailto:mail@vbiketours.com">mail@vbiketours.com</a> ), 
					we&#8217;ll contact you shortly to confirm your booking.
				</p>
			</div>		
			<div id="checkout_infos_submit">
				<button id="checkout_infos_submit" name="checkout_infos_submit" type="submit" class="btn-pink btn-effect col-xs-12 col-md-4">Proceed to PayPal</button>
			</div>
		</div>
	</form>
</div>
</div>
</section>
<!-- end checkout_infos section -->