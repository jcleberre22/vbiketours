<?php
if (isset($_SESSION['msg'])){
	$booking_msg=$_SESSION['msg'];
	?>
<script type="text/javascript">alert("<?php echo $booking_msg; ?>")</script>
<?php }

// include controller if it exist
if (! empty ( $_GET ['page'] ) && is_file ( 'Controller/' . $_GET ['page'] . '_ctl.php' )) {
	include 'Controller/' . $_GET ['page'] . '.php';
} else {
	include 'Controller/cart_ctl.php';
}

?>