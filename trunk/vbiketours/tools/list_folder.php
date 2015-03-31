<?php
function list_folder($directory)
{
	$scanned_directory = array_diff(scandir($directory), array('..', '.'));
	return $scanned_directory;
}
?>