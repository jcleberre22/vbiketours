<?php
$tour_dao=new TourDAO($db);
$tours_list=array();
$tours_list=$tour_dao->getList();
include 'View/welcome.php';
?> 