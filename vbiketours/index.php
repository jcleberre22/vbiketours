<?php
include 'tools/list_folder.php';
include 'tools/classes_auto_load.php';
session_start ();

// OCOnnection to the MySQL DataBase
include 'Model/connect_db.php';


// include controller if it exist
if (! empty ( $_GET ['page'] ) && is_file ( 'Controller/' . $_GET ['page'] . '_ctl.php' )) {
	$page=$_GET['page'];
	include 'Controller/' . $_GET ['page'] . '_ctl.php';
} else {
	header('location: index.php?page=welcome');
}

?>
