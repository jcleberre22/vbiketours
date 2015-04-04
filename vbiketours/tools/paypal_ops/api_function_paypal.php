<?php

 $paypal_server = "https://www.paypal.com/webscr&cmd=_express-checkout&token=";

function build_url_paypal() {
	$api_paypal = 'https://api-3t.paypal.com/nvp?'; // Website of PayPal API
	$version = 121; // API version
	
	$user = 'vbiketours@gmail.com';
	$pass = ' ';
	$signature = ' ';
	
	$api_paypal = $api_paypal . 'VERSION=' . $version . '&USER=' . $user . '&PWD=' . $pass . '&SIGNATURE=' . $signature; // Add all parameters
	
	return $api_paypal; // Return the string with all parameters
}

function get_paypal_parameters($result_paypal){
	
	$parameters_list = explode("&",$result_paypal);

	foreach($parameters_list as $param_paypal){
		list($name, $value) = explode("=", $param_paypal);

	$list_param_paypal[$name]=urldecode($value);
	}

	echo "<pre>";
	print_r($list_param_paypal);
	echo "</pre>";

	return $list_param_paypal;
}
?>