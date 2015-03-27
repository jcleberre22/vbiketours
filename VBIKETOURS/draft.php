<?php
function add_tour(){
try {

$req=$bdd->prepare('INSERT INTO `tour`(`name`, `summary`, `description`, `fitness`, `vehicle` , `duration`, `style`, `route`, `nb_passenger_max`, `price`, `start_time`, `validity_start`, `validity_end`, `picture`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)');
$req->execute(array(
	$_POST['name'],
	$_POST['summary'],
	$_POST['description'],
	$_POST['fitness'],
	$_POST['vehicle'],
	$_POST['duration']." ".$_POST['duration_type'],
	$_POST['style'],
	$_POST['route'],
	$_POST['nb_passenger_max'],
	$_POST['price'],
	$_POST['start_time'],
	$_POST['validity_start'],
	$_POST['validity_end'],
	$_POST['picture']
	));
	
} catch (Exception $e) {
	die('Error : ' . $e->getMessage());
}
echo 'The tour: "' . $_POST['name'] . '" was succesfully added !';
}
?>

-------------------------------------------------------------------------------------------------------------------------------------------------------------

$(document).ready(function(){
	$("#form_tour").validate({
		rules: {}
	        checkinput:{
	            required: true
	        }
	   		
	   		checktextarea:{
	   			required: true
	   		}
       		checkint:{
       			required: true  
       		}
	   
       		checkdate:{
       			required: true
       		}
	   
	   		checktime:{
	   			required: true
	   		}
	   
	   		checkfile:{
	   			required: true    
	   		}
	    });
    ();
});