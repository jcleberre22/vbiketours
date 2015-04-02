<?php
$tour_dao=new TourDAO($db);

if (isset($_SESSION['cart'])){
	$cart=$_SESSION['cart'];
	if(isset($_POST['checkout_infos_submit'])){
		foreach ($_POST as $input => $value){
			$$input = $value;
		}
	}
	include 'View/checkout.php';
}else {
	header('location: index.php');
}

?>