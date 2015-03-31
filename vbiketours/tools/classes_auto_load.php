<?php
include 'tools/list_folder.php';

$directory="Model/Classes/";
foreach (list_folder($directory) as $class){
	require $_SERVER['DOCUMENT_ROOT'].'/vbiketours/'.$directory.$class; // include the class
}

// function loadClass($class)
// {
//  	
// }

// spl_autoload_register('loadClass'); // Record function loadClass into the autoload register
// ?>