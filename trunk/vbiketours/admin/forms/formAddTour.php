<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
	<script type="text/javascript" src="../../js/jquery-2.0.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery-validate/dist/jquery.validate.js"></script>
    <script type="text/javascript" src="../../js/jquery-validate/dist/additional-methods.js"></script>
    <script type="text/javascript" src="../../js/validate.js"></script>
</head>
<body>
	<form id="form_tour" action="../../Controller/tour_add_ctl.php" method="post">
		<p>
			<BR /> name:				<input id="name" type="text" name="name" />  <?php if (isset($name)){ echo $name;}?><BR /> 
			<BR /> summary:				<input id="summary" class="checkinput"type="text" name="summary" /><?php if (isset($summary)){ echo $summary;}?><BR />
			<BR /> description:			<textarea id="description"  class="checktextarea"name="description" ></textarea><?php if (isset($description)){ echo $description;}?><BR />
			<BR /> fitness:				<input id="fitness" class="checkinput"type="text" name="fitness" /><?php if (isset($fitness)){ echo $fitness;}?><BR />
			<BR /> vehicle:				<input id="vehicle" class="checkinput"type="text" name="vehicle" /><?php if (isset($vehicle)){ echo $vehicle;}?><BR />
			<BR /> duration:			<input id="duration" class="checkinput"type="text" name="duration" /> 
										<select id="duration_type" name="duration_type">
											<option selected="selected">Hours</option>
											<option>Days</option>
										</select><?php if (isset($duration)){ echo $duration;}?><BR />
			<BR /> style:				<input id="style" class="checkinput"type="text" name="style" /><?php if (isset($style)){ echo $style;}?><BR />
			<BR /> route:				<input id="route" class="checkinput"type="text" name="route" /><?php if (isset($route)){ echo $route;}?><BR />
			<BR /> nb_passenger_max:	<input id="nb_passenger_max" class="checkint"type="number" name="nb_passenger_max" /><?php if (isset($nb_passenger_max)){ echo $nb_passenger_max;}?><BR />
			<BR /> price:				<input id="price" class="checkinput"type="text" name="price" /><?php if (isset($price)){ echo $price;}?><BR />
			<BR /> start_time:			<input id="start_time" class="checktime"type="time" name="start_time" /><?php if (isset($start_time)){ echo $start_time;}?><BR />
			<BR /> validity_start:		<input id="validity_start" class="checkdate"type="date" name="validity_start" /><?php if (isset($validity_start)){ echo $validity_start;}?><BR />
			<BR /> validity_end:		<input id="validity_end" class="checkdate"type="date" name="validity_end" /><?php if (isset($validity_end)){ echo $validity_end;}?><BR />
			<BR /> picture:				<select id="picture"  name="picture">
											<option >select from existing</option>
<?php 
include '../../tools/list_folder.php';
$directory="../../img/uploads/";
$list_img = list_folder($directory);
foreach ( $list_img as $image ) {
	?>
											<option><?php echo $image; ?></option>
<?php }?>
										</select> or upload a new picture: <input class="checkfile" type="file"><?php if (isset($picture)){ echo $picture;}?><BR />
			<BR /> 						<input id="validate" name="validate" type="submit" value="Add the tour" />
		</p>
	</form>
</body>
</html>