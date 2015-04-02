<?php
$tour_dao = new TourDAO ( $db );

if (! isset ( $_POST ['submit_booking'] )) {
	
	if (isset ( $_GET ['action'] ) && $_GET ['action'] == "delete") {
		
		if (isset ( $_SESSION ['cart'] ) && isset ( $_GET ['booking_id'] )) {
			if ($_SESSION ['cart']->remove_booking ( $_GET ['booking_id'] )) {
				$_SESSION ['cart'] = $cart = null;
				
			}
		}
	}
	$cart = $_SESSION ['cart'];
	
} else {
	if (isset ( $_GET ['action'] ) && $_GET ['action'] == "add") {
		
		// get booking values from the form
		$booking_date = $_POST ['booking_date'];
		$booking_nb_adults = $_POST ['booking_nb_adults'];
		$booking_nb_childrens = $_POST ['booking_nb_childrens'];
		$booking_tour_id = $_POST ['booking_tour_id'];
		$booking_price = $_POST ['booking_price'];
		
		// if there is no cart in the session yet
		if (! isset ( $_SESSION ['cart'] )) {
			// create a Booking object
			$booking = new Booking ( 0, $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price );
			
			// create attributes for the cart
			$cart_booking_list = array ();
			$cart_price = 0;
			
			// create a new Cart
			$cart = new Cart ( $cart_booking_list, $cart_price );
			$msg = "the booking was added to your cart!";
			$_SESSION ['msg'] = $msg;
			// if there is already a cart in the session
		} else {
			$cart = $_SESSION ['cart'];
			
			$cart_booking_list = $cart->get_booking_list ();
			// create a Booking object
			$booking = new Booking ( count ( $cart_booking_list ), $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price );
			
			foreach ( $cart_booking_list as $cart_booking ) {
				// if the booking is already in the cart
				if (($cart_booking->get_date () == $booking->get_date ()) && ($cart_booking->get_tour_id () == $booking->get_tour_id ())) {
					
					// send the error message and go to the cart page
					$msg = "this booking is already in your cart!";
					$_SESSION ['msg'] = $msg;
					header ( 'location: index.php?page=tour&tour_id=' . $booking->get_tour_id () );
					die (); // end of script
				}
			}
			$msg = "the booking was added to your cart!";
			$_SESSION ['msg'] = $msg;
		}
		// add the booking to the cart
		$cart->add_booking ( $booking );
	}
}

// save the cart in the session
$_SESSION ['cart'] = $cart;
//print_r($cart);

// send confirmation message and go to the cart page

include 'View/cart.php';
include 'tools/alert_message.php';

?>
