<?php
	// include controller only if it exist
	if (! empty ( $_GET ['page'] ) && is_file ( 'Controller/' . $_GET ['page'] . '_ctl.php' )) {
		include 'Controller/' . $_GET ['page'] . '.php';
	} else {
		include 'Controller/cart_ctl.php';
	}	
?>