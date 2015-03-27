<?php
require '../Model/connect_db.php';
require '../tools/classes_auto_load.php';

// if(isset($_POST['validate']))
// {
// $keyname;
// foreach ($_POST as $key => $value) {
// 	if (empty( $_POST[$value])) {
// 		$keyname = $key;
// 		break;
// 	}
// }
// if (isset($keyname)) {
// 	header ( 'location: formaddtour_ctl.php?$keyname=' . $keyname);
// 	die();
// } else {
	$tour_datas ['name'] = htmlspecialchars ( stripcslashes ( $_POST ['name'] ) );
	$tour_datas ['summary'] = htmlspecialchars ( stripcslashes ( $_POST ['summary'] ) );
	$tour_datas ['description'] = htmlspecialchars ( stripcslashes ( $_POST ['description'] ) );
	$tour_datas ['fitness'] = htmlspecialchars ( stripcslashes ( $_POST ['fitness'] ) );
	$tour_datas ['vehicle'] = htmlspecialchars ( stripcslashes ( $_POST ['vehicle'] ) );
	$tour_datas ['duration'] = htmlspecialchars ( stripcslashes ( $_POST ['duration'] ) );
	$tour_datas ['style'] = htmlspecialchars ( stripcslashes ( $_POST ['style'] ) );
	$tour_datas ['route'] = htmlspecialchars ( stripcslashes ( $_POST ['route'] ) );
	$tour_datas ['nb_passenger_max'] = htmlspecialchars ( stripcslashes ( $_POST ['nb_passenger_max'] ) );
	$tour_datas ['price'] = htmlspecialchars ( stripcslashes ( $_POST ['price'] ) );
	$tour_datas ['start_time'] = $_POST ['start_time'];
	$tour_datas ['validity_start'] = $_POST ['validity_start'];
	$tour_datas ['validity_end'] = $_POST ['validity_end'];
	$tour_datas ['picture'] = htmlspecialchars ( stripcslashes ( $_POST ['picture'] ) );
	
	try {
		$tour = new Tour ( $tour_datas );
		$tour_dao = new TourDAO ( $db );
		$tour_dao->add ( $tour );
	} catch ( Exception $e ) {
		$error = "Database insertion probleme - error: " . $e;
		header ( 'location: formaddtour_ctl.php?.$error=' . $error );
		die();
	}?>
	<script type="text/javascript">alert("the tour: ".<?php $tour_datas['name'] ?>." was succesfully added to the database.")</script>
	<?php
	//header ( 'location: formaddtour_ctl.php');
// }
// }else{
// 	$error="gros probleme";
// 	header ( 'location: formaddtour_ctl.php?.$error=' . $error );
// 	die();
// }
?>