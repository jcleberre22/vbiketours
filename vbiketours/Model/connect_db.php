<?php
//conection to the database

try
{
	$db = new PDO('mysql:host=mysql55-29.perso;dbname=jcleberrvlbdd;charset=utf8', 'jcleberrvlbdd', 'Qbikes22');
}
catch (Exception $e)
{
        die('Error : ' . $e->getMessage());
}
?>
