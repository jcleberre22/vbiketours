<?php
include("fonction_api.php");

$request = build_url_paypal();
$request = $request."&METHOD=SetExpressCheckout".
			"&CANCELURL=".urlencode("http://127.0.0.1/cancel.php").
			"&RETURNURL=".urlencode("http://127.0.0.1/return.php").
			"&AMT=10.0".
			"&CURRENCYCODE=VND".
			"&DESC=".urlencode("description").
			"&LOCALECODE=VI".
			"&HDRIMG=".urlencode("image");

$ch = curl_init($request);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);

// Retourne directement le transfert sous forme de chaîne de la valeur retournée par curl_exec() au lieu de l'afficher directement. 
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

// On lance l'exécution de la requête URL et on récupère le résultat dans une variable
$result_paypal = curl_exec($ch);

// S'il y a une erreur, on affiche "Erreur", suivi du détail de l'erreur.
if (!$result_paypal)
	{echo "<p>Erreur</p><p>".curl_error($ch)."</p>";}

else // S'il s'est exécuté correctement, on effectue les traitements...
{
	// On récupère la liste de paramètres, séparés par un 'et' commercial (&)
	$parameters_list = explode("&",$result_paypal);
	// Pour chacun de ces paramètres, on exécute le bloc suivant, en intégrant le paramètre dans la variable $param_paypal
	foreach($parameters_list as $param_paypal)
	{
		// On récupère le nom du paramètre et sa valeur dans 2 variables différentes. Elles sont séparées par le signe égal (=)
		list($name, $value) = explode("=", $param_paypal);
		// On crée un tableau contenant le nom du paramètre comme identifiant et la valeur comme valeur.
		$list_param_paypal[$name]=urldecode($value); // Décode toutes les séquences %##  et les remplace par leur valeur. 
	}
		// On affiche le tout pour voir que tout est OK.
		echo "<pre>";
		print_r($list_param_paypal);
		echo "</pre>";
}

// On ferme notre session cURL.
curl_close($ch);

?>
