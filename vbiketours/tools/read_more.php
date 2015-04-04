<?php
function read_more($string, $nbchar){
// strip tags to avoid breaking any html
	$string = strip_tags($string);

	if (strlen($string) > $nbchar) {

		// truncate string
		$stringCut = substr($string, 0, $nbchar);

		// make sure it ends in a word
		$string = substr($stringCut, 0, strrpos($stringCut, ' ')).'...';
	}
	return $string;
}
?>