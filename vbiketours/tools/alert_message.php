<!-- if there is a message -->
<?php if (isset($_SESSION['msg']) && $_SESSION['msg']!=""){ ?>

	<!-- open a popup with the message -->
	<script type="text/javascript"> alert("<?php echo $_SESSION['msg']; ?>") </script>
	
<?php 
unset($_SESSION['msg']);
} ?>