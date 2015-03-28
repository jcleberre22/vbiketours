<?php
$tour_dao=new TourDAO($db);
$id_tour=$_GET['tour_id'];
$tour=$tour_dao->get($id_tour);
$tours_list=array();
$tours_list=$tour_dao->getList();
include 'View/tour.php';
?>