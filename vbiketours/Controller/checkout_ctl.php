<?php

$customer_dao = new CustomerDAO($db);
$order_dao = new OrderDAO($db);

	if(isset($_POST['checkout_infos_submit'])){
		
		if (isset($_SESSION['cart'])){
			
			$cart=$_SESSION['cart'];

			$order_datas=array();
			$order_datas['id'] = count($order_dao->getList())+1;
			print_r($order_dao->getList());echo "<br><br>";
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

			print_r($customer_datas);echo "<br><br>";
			$customer = new Customer($customer_datas);
			print_r($customer);echo "<br><br>";
			$customer_dao -> add($customer);

			$order_datas['customer_id'] = $customer->get_customer_id();
			print_r($order_datas);echo "<br><br>";
			$order = new Order($order_datas);
			$order->set_payment_succes(0);
			print_r($order);echo "<br><br>";
			if($order_dao->add($order)) 	
				echo "added";
			else
				echo "pb!";
			
		}		
		include 'View/checkout.php';
	}else {
	header('location: index.php');
}
?>
