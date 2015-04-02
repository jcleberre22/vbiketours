<?php
$customer_dao=new Customer_DAO($db);
 
if (isset($_SESSION['cart'])){
	$cart=$_SESSION['cart'];
	if(isset($_POST['checkout_infos_submit'])){
		foreach ($_POST as $input => $value){
			$$input=$value;
			if(is_string($value)){
				$$input = htmlspecialchars ( stripcslashes ($value) );
			}
			if (strpos($input,'customer') !== false)
				$customer_datas[$input]=$$input;
		}
		echo "<br><br><br><br><br><br>";
		if (isset($customer_datas))
			$customer = new Customer($customer_datas);
			$customer_dao = new Customer_DAO($db);
			$customer_dao -> add($customer);
			
	include 'View/checkout.php';
	}else {
		header('location: index.php');
	}
}

?>