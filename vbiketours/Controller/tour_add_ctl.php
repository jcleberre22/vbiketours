<?php
require '../Model/connect_db.php';
require '../tools/classes_auto_load.php';

	if(isset($_POST[''])){
		foreach ($_POST as $input => $value){
			if (is_string($value))
				$$input = htmlspecialchars ( stripcslashes ($value) );
			$tour_datas[$input]=$$input;
		}
	}
	
	try {
		$tour = new Tour ( $tour_datas );
		$tour_dao = new TourDAO ( $db );
		$tour_dao->add ( $tour );
	} catch ( Exception $e ) {
		$error = "Database insertion probleme - error: " . $e;
		header ( 'location: formaddtour_ctl.php?$error=' . $error );
		die();
	}
?>