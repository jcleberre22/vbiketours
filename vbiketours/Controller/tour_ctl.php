<?php
$tour_dao=new TourDAO($db);
$id_tour=$_GET['tour_id'];
$tour=$tour_dao->get($id_tour);
include 'View/tour.php';
?>