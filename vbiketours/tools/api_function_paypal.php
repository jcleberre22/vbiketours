<?php

/******  TESTS  ******/

$paypal_server = "https://www.sandbox.paypal.com/webscr&cmd=_express-checkout&token=";


function build_url_paypal() {

	$api_paypal = 'https://api-3t.sandbox.paypal.com/nvp?'; // Website of PayPal API
	
	$version = 121; // API version
	$user = 'vbiketourstest-facilitator_api1.gmail.com';
	$pass = 'GM8CCLH84K3HTK9Z';
	$signature = 'AFcWxV21C7fd0v3bYYYRCpSSRl31ALj55S82pTPPwNAB2TRZ4MSzPsiB';
	
	$api_paypal = $api_paypal . 'VERSION=' . $version . '&USER=' . $user . '&PWD=' . $pass . '&SIGNATURE=' . $signature; // Add all parameters

	return $api_paypal; // Return the string with all parameters
}

function get_paypal_parameters($result_paypal){

	$parameters_list = explode("&",$result_paypal);

	if (isset($parameters_list)){
		foreach($parameters_list as $param_name => $param_paypal){
			list($name, $value) = explode("=", $param_paypal);

			$list_param_paypal[$name]=urldecode($value);
		}
		/*if (isset($list_param_paypal)){
			echo "<pre>";
			print_r($list_param_paypal);
			echo "</pre>";
		}*/
	
		return $list_param_paypal;
	}	
	return false;
}
?>