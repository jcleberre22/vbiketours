<?php
include $_SERVER['DOCUMENT_ROOT'].'VBIKETOURS/tools/classes_auto_load.php';
session_start();

//Connection to the MySQL DataBase
include $_SERVER['DOCUMENT_ROOT'].'VBIKETOURS/Model/connect_db.php';


// include controller if it exist
if (! empty ( $_GET ['page'] ) && is_file ( 'Controller/' . $_GET ['page'] . '_ctl.php' )) {
	include 'Controller/' . $_GET ['page'] . '.php';
} else {
	include 'Controller/tour_ctl.php';
}

?>
