<?php

$customer_dao = new CustomerDAO($db);
$order_dao = new OrderDAO($db);

	if(isset($_POST['checkout_infos_submit'])){
		
		if (isset($_SESSION['cart'])){
			
			$cart=$_SESSION['cart'];

			$order_datas=array();
			$order_datas['id'] = count($order_dao->getList())+1;
			$order_datas['cart'] = serialize($cart) ;

			$customer_datas['customer_id'] = count($customer_dao->getList())+1;
					
			foreach ($_POST as $input => $value){

				$$input=$value;
				if(is_string($value)){
					if (strpos($input,'id') === false)
					$$input = htmlspecialchars ( stripcslashes ($value) );
				}
				if (strpos($input,'customer') !== false){
					if (strpos($input,'id') === false)
						$customer_datas[$input]=$$input;
				}else 
					if (strpos($input,'submit') === false)
						$order_datas[$input]=$$input;
			}

			echo "<br><br><br><br><br><br>";


			$customer = new Customer($customer_datas);
			print_r($customer);echo "<br><br>";
			$customer_dao -> add($customer);
			
			$order_datas['payment_succes'] = 0;
			$order_datas['customer_id'] = $customer->get_customer_id();
			$order = new Order($order_datas);
			$_SESSION['order']=$order;
			$_SESSION['description']=$description;

			$order_dao->add($order);
			
			$list_booking = $cart->get_booking_list ();
			$tourDAO = new TourDAO($db);
			$last_item = count($list_booking)-1;
			$description="";
			foreach ($list_booking as $item => $booking){
				$tour_id=$booking->get_tour_id();
				$tour=$tourDAO->get($tour_id);

				if ($item != $last_item)
					$description .= $tour->get_name()." - ";
				else 
					$description .= $tour->get_name();
			}
			
		}		

	if ($payment_type == "full")
		include 'tools/payment.php';
	else {
		
		header('location: index.php?page=reservation');
		
	}
	
	}else {
	header('location: index.php');
}
?>
