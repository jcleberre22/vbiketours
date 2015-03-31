<?php

$tour_dao=new TourDAO($db);
$tours_list=array();
$tours_list=$tour_dao->getList();
$cart_empty=true;

if (isset($_SESSION['cart'])){
	$cart=$_SESSION['cart'];
	$cart_empty=false;
}
	
include 'View/cart.php';
?>