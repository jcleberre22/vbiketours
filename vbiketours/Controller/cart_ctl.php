<?php
$tour_dao=new TourDAO($db);
if (!isset($_POST['submit_booking'])){
	$cart=$_SESSION['cart'];
	include 'View/cart.php';
}else {
//get booking values from the form
$booking_date 			= $_POST['booking_date'];
$booking_nb_adults		= $_POST['booking_nb_adults'];
$booking_nb_childrens 	= $_POST['booking_nb_childrens'];
$booking_tour_id		= $_POST['booking_tour_id'];
$booking_price 			= $_POST['booking_price'];

//if there is no cart in the session yet
if (!isset($_SESSION['cart'])){
	//create a Booking object
	$booking=new Booking(1, $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price);
	
	//create attributes for the cart
	$cart_booking_list=array();
	$cart_price=0;
	
	//create a new Cart
	$cart=new Cart($cart_booking_list, $cart_price);


//if there is already a cart in the session
}else{
	$cart=$_SESSION['cart']	;
	//if the booking is already in the cart
	$cart_booking_list=$cart->get_booking_list();
	//create a Booking object
	$booking=new Booking(count($cart_booking_list)+1, $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price);
	
	foreach ($cart_booking_list as $cart_booking){
		
		if ( ($cart_booking->get_date() == $booking->get_date()) && ($cart_booking->get_tour_id() == $booking->get_tour_id()) ){
			
			//send the error message and go to the cart page
			$msg="this booking is already in your cart!";
			header('location: index.php?page=tour&tour_id='.$booking->get_tour_id().'&msg='.$msg);
			die(); //end of script

		}
	}	
}

	//add the booking to the cart
	$cart->add_booking($booking);
	
	//save the cart in the session
	$_SESSION['cart']=$cart;
	
	//send confirmation message and go to the cart page
	$msg="the booking was added to your cart!";
	include 'View/cart.php';
}
?>
