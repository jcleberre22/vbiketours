<?php
include("tools/api_function_paypal.php");

$request = build_url_paypal();
$request = $request."&METHOD=SetExpressCheckout".
			"&CANCELURL=".urlencode("http://127.0.0.1/vbiketours/index.php?page=paypal_cancel").
			"&RETURNURL=".urlencode("http://127.0.0.1/vbiketours/index.php?page=paypal_succes").
			"&AMT=".$order->get_price().
			"&CURRENCYCODE=USD".
			"&DESC=".urlencode($description()).
			"&LOCALECODE=US".
			"&HDRIMG=".urlencode("http://127.0.0.1/vbiketours/img/logo.png");

$ch = curl_init($request);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);

curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

$result_paypal = curl_exec($ch);

if (!$result_paypal)
	{echo "<p>Error: </p><p>".curl_error($ch)."</p>";}

else
{
	$parameters_list = explode("&",$result_paypal);

	foreach($parameters_list as $param_paypal)
	{
		list($name, $value) = explode("=", $param_paypal);

		$list_param_paypal[$name]=urldecode($value);
	}

		echo "<pre>";
		print_r($list_param_paypal);
		echo "</pre>";
}
curl_close($ch);

?>
