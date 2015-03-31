<?php
$directory="Model/Classes/";
$paths[1]="/vbiketours/$directory";
$paths[2]="/vbiketours/$directory";
$classes=list_folder($directory);

foreach ($paths as $path){
	$classes=list_folder($directory);
	foreach ($classes as $class)
		loadClass($path, $class);
}

function loadClass($path,$class)
{
  include_once $_SERVER['DOCUMENT_ROOT'].$path.$class; // include the class
}

//spl_autoload_register('loadClass'); // Record function loadClass into the autoload register
?>