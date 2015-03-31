<?php
	
	include $_SERVER['DOCUMENT_ROOT'].'VBIKETOURS/tools/classes_auto_load.php';
	
	session_start();
	
	//get the values from the form	
	$booking_date=$_POST['booking_date'];
	$booking_nb_adults=$_POST['booking_nb_adults'];
	$booking_nb_childrens=$_POST['booking_nb_childrens'];
	$tour=$_SESSION['tour'];
	$booking_tour_id=$tour->get_id();
	$booking_price=$tour->get_price();
	
	//create a booking_list for the cart
	$booking_list=array();
	
	//if there is no cart in the session yet
	if (!isset($_SESSION['cart'])){
		$booking=new Booking(1, $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price);	
		$booking_list[0]=$booking;
		$_SESSION['cart']=new Cart($booking_list, $booking->get_price());
		$msg="the booking was added to your cart!";
		$_SESSION['msg']=$msg;
		header('location: ../index.php?page=cart');
	
	//if a cart already exist in the session
	}else {
		$booking_list=$_SESSION['cart']->get_booking_list(); //get the list of booking in the cart
		
		foreach ($booking_list as $bookingOBJ){
			//if the booking is already in the cart
			if (($bookingOBJ->get_date()==$booking_date)&&($bookingOBJ->get_tour_id()==$booking_tour_id)){

				$msg="this booking is already in your cart!";
				$_SESSION['msg']=$msg;
				header('location: ../index.php?page=tour&tour_id='.$booking_tour_id);
				die(); //end of script

			}
		}
		
		$booking=new Booking($nb_bookings+1, $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price);
		$nb_bookings=count($booking_list);
		//add the booking to the list
		$booking_list[$nb_bookings]=$booking;
		//set the new list in the cart
		$_SESSION['cart']->set_booking_list($booking_list);
		$msg="the booking was added to your cart!";
		$_SESSION['msg']=$msg;
		header('location: ../index.php?page=cart');
	}		
?>