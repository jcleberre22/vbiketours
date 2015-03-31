<?php
	if (isset($_SESSION['msg'])){
		if (($booking_msg=$_SESSION['msg'])!=""){
?>

<script type="text/javascript">alert("<?php echo $booking_msg; ?>")</script>

<?php 
	$_SESSION['msg']="";
		}
	}
?>