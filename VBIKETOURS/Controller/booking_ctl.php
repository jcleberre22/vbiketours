<?php
	include $_SERVER['DOCUMENT_ROOT'].'VBIKETOURS/tools/classes_auto_load.php';
	session_start();
	//get the values from the form	
	$booking_date=$_POST['booking_date'];
	$booking_nb_adults=$_POST['booking_nb_adults'];
	$booking_nb_childrens=$_POST['booking_nb_childrens'];
	$tour=$_SESSION['tour'];
	//$tour=$_SESSION['tour'];
	print_r($tour);
	$booking_tour_id=$tour->get_id();
	$booking_price=$tour->get_price();
	
	//create a booking_list for the cart
	$booking_list=array();
	
	//Able to test if the booking is already in the cart or not
	$booking_exist=false;
	
	//if there is no cart in the session yet
	if (!isset($_SESSION['cart'])){
		$booking=new Booking(1, $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price);	
		$booking_list[0]=$booking;
		$_SESSION['cart']=new Cart($booking_list, $booking->get_price());
	
	//if a cart already exist in the session
	}else {
		$booking_list=$_SESSION['cart']->get_booking_list();
		foreach ($booking_list as $datas){
			if (($datas->get_date()==$booking_date)&&($datas->get_tour_id()==$booking_tour_id)){
				$booking_exist=true;
				$msg="this booking is already in your cart!";
				$_SESSION['msg']=$msg;
				header('location: ../tour.php?tour_id='.$booking_tour_id);
				break;
				die();
			}
		}
		if ($booking_exist==false){
		$nb_bookings=count($booking_list);
		$booking=new Booking($nb_bookings+1, $booking_date, $booking_nb_adults, $booking_nb_childrens, $booking_tour_id, $booking_price);
		$booking_list[$nb_bookings]=$booking;
		$_SESSION['cart']->set_booking_list($booking_list);
		$msg="the booking was added to your cart!";
		$_SESSION['msg']=$msg;
		header('location: ../cart.php');
		}
	}
	
?>