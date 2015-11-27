<?php
include_once("tools/api_function_paypal.php");

$token = $_GET['token'];
$payer = $_GET['PayerID'];
$request = build_url_paypal();
$request = $request."&METHOD=DoExpressCheckoutPayment".
			"&TOKEN=".htmlentities($token, ENT_QUOTES).
			"&AMT=".$_SESSION['cart']->get_price().
			"&CURRENCYCODE=USD".
			"&PayerID=".htmlentities($payer, ENT_QUOTES).
			"&PAYMENTACTION=sale";

$ch = curl_init($request);

curl_setopt($ch, CURLOPT_VERBOSE,1);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

$result_paypal = curl_exec($ch);

if (!$result_paypal)
	$msg=$_SESSION['msg'] = "error: ".curl_error($ch);

else{

	$list_param_paypal = get_paypal_parameters($result_paypal);
	if (isset($list_param_paypal['ACK'])){
		if ($list_param_paypal['ACK'] == 'Success'){
			curl_close($ch);
			$tour_dao= new TourDAO($db);
			$cart=$_SESSION['cart'];
			$order=$_SESSION['order'];
			$description=$_SESSION['description'];
			include 'View/paypal_success.php';
			die();
		
		}else {
			if (isset($list_param_paypal['L_SHORTMESSAGE0']) && isset($list_param_paypal['L_LONGMESSAGE0']))
				$msg=$_SESSION['msg']= "Communication error with PayPal Server. ".$list_param_paypal['L_SHORTMESSAGE0']." ".$list_param_paypal['L_LONGMESSAGE0'];			
		}
	}else{
		header('location: index.php?page=paypal_cancel');
	}
	curl_close($ch);

}


?>
