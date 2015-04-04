<?php

/******  TESTS  ******/
$paypal_server = "https://www.sandbox.paypal.com/webscr&cmd=_express-checkout&token=";

/**
 * **** PRODUCTION *****
 */
// $paypal_server = "https://www.paypal.com/webscr&cmd=_express-checkout&token=";
function build_url_paypal() {
	$api_paypal = 'https://api-3t.sandbox.paypal.com/nvp?'; // Website of PayPal API
	$version = 57.0; // API version
	
	$user = 'vbiketourstest-facilitator_api1.gmail.com';
	$pass = 'GM8CCLH84K3HTK9Z';
	$signature = 'AFcWxV21C7fd0v3bYYYRCpSSRl31ALj55S82pTPPwNAB2TRZ4MSzPsiB';
	
	$api_paypal = $api_paypal . 'VERSION=' . $version . '&USER=' . $user . '&PWD=' . $pass . '&SIGNATURE=' . $signature; // Add all parameters
	
	return $api_paypal; // Return the string with all parameters
}

function get_param_paypal($paypal_result) {
	$parameters_list = explode ( "&", $paypal_result ); // Create a parameters array
	foreach ( $parameters_list as $param_paypal )
		list ( $name, $value ) = explode ( "=", $param_paypal ); // Separate name and value
	$param_paypal_list [$name] = urldecode ( $value ); // Create the final array
}
return $param_paypal_list; // Return the array

?>