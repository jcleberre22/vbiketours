<?php
$tour_dao=new TourDAO($db);

if (isset($_SESSION['cart'])){
		$cart=$_SESSION['cart'];	
	include 'View/checkout_infos.php';
}else {
	header('location: index.php');
}
?>