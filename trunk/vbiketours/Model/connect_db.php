<?php
//conection to the database

try
{
	$db = new PDO('mysql:host=localhost;dbname=vbiketours;charset=utf8', 'root', '');
}
catch (Exception $e)
{
        die('Erreur : ' . $e->getMessage());
}
?>
