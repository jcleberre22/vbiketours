<?php
include_once("tools/api_function_paypal.php");

$request = build_url_paypal();
$request = $request."&METHOD=SetExpressCheckout".
			"&CANCELURL=".urlencode("http://127.0.0.1/vbiketours/index.php?page=paypal_cancel").
			"&RETURNURL=".urlencode("http://127.0.0.1/vbiketours/index.php?page=paypal_success").
			"&AMT=".$cart->get_price().
			"&CURRENCYCODE=USD".
			"&DESC=".urlencode($description).
			"&LOCALECODE=US".
			"&HDRIMG=".urlencode("http://127.0.0.1/vbiketours/img/logo.png");

$ch = curl_init($request);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);

curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

$result_paypal = curl_exec($ch);

if (!$result_paypal)
	echo $msg = $_SESSION['msg'] = "error: ".curl_error($ch);

else{

	$list_param_paypal = get_paypal_parameters($result_paypal);
	
	if ($list_param_paypal['ACK'] == 'Success')
	{
		header("Location: https://www.sandbox.paypal.com/webscr&cmd=_express-checkout&token=".$list_param_paypal['TOKEN']);
		exit();
	}
	else {
		echo $msg = $_SESSION['msg'] = "Communication error with PayPal Server. ".$list_param_paypal['L_SHORTMESSAGE0']." ".$list_param_paypal['L_LONGMESSAGE0'];
	}
}
curl_close($ch);

?>
