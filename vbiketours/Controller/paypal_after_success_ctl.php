<?php
include("tools/api_function_paypal.php");
$request = build_url_paypal();
$request = $request."&METHOD=GetExpressCheckoutDetails".
			"&TOKEN=".htmlentities($_GET['token'], ENT_QUOTES);

$ch = curl_init($request);
curl_setopt($ch, CURLOPT_VERBOSE,1);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$result_paypal = curl_exec($ch);

if (!$result_paypal) {
	{echo "<p>Error</p><p>".curl_error($ch)."</p>";}
}else{
	include 'view/paypal_after_success.php';
	$list_param_paypal = get_paypal_parameters($result_paypal);
		unset($_SESSION['cart']);
		curl_close($ch);
		echo "<pre>";
		print_r($list_param_paypal);
		echo "</pre>";			
		die();
}
?>