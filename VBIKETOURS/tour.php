<?php

if (isset($_SESSION['msg'])){
	$booking_msg=$_SESSION['msg'];
	?>
<script type="text/javascript">alert("<?php echo $booking_msg; ?>")</script>
<?php }

//Connection to the MySQL DataBase
include $_SERVER['DOCUMENT_ROOT'].'VBIKETOURS/Model/connect_db.php';
include $_SERVER['DOCUMENT_ROOT'].'VBIKETOURS/tools/classes_auto_load.php';

// include controller if it exist
if (! empty ( $_GET ['page'] ) && is_file ( 'Controller/' . $_GET ['page'] . '_ctl.php' )) {
	include 'Controller/' . $_GET ['page'] . '.php';
} else {
	include 'Controller/tour_ctl.php';
}

?>
