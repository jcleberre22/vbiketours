<?php
$paths[0]=$_SERVER['DOCUMENT_ROOT']."/vbiketours/Model/Classes/DAO/";
$paths[1]=$_SERVER['DOCUMENT_ROOT']."/vbiketours/Model/Classes/";

$classes=array();
foreach ($paths as $path){
	$classes=array_diff(scandir($path), array('..', '.','DAO'));
	foreach ($classes as $class)
		loadClass($path, $class);
}


function loadClass($path,$class)
{
 	include_once $path.$class; // include the class
}

//spl_autoload_register('loadClass'); // Record function loadClass into the autoload register
?>