<!-- if there is a message -->
<?php if (isset($_GET['msg'])){ ?>

	<!-- open a popup with the message -->
	<script type="text/javascript"> alert("<?php echo $booking_msg; ?>") </script>
	
<?php } ?>