<?php
$msg="";
if (isset($_POST['submit_contact'])){
$email_vbiketours="vbiketourstest@gmail.com";

foreach ($_POST as $key => $value){
	$$key = $value;
}


/**
 * This example shows settings to use when sending via Google's Gmail servers.
*/

//SMTP needs accurate times, and the PHP time zone MUST be set
//This should be done in your php.ini, but this is how to do it if you don't have access to that
date_default_timezone_set('Etc/UTC');

require 'tools/PHPMailer/PHPMailerAutoload.php';

//Create a new PHPMailer instance
$mail = new PHPMailer;

//Tell PHPMailer to use SMTP
$mail->isSMTP();

//Enable SMTP debugging
// 0 = off (for production use)
// 1 = client messages
// 2 = client and server messages
$mail->SMTPDebug = 0;

//Ask for HTML-friendly debug output
$mail->Debugoutput = 'html';

//Set the hostname of the mail server
$mail->Host = 'smtp.live.com';//'smtp-mail.outlook.com';

//Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
$mail->Port = 587;

//Set the encryption system to use - ssl (deprecated) or tls
$mail->SMTPSecure = 'tls';

//Whether to use SMTP authentication
$mail->SMTPAuth = true;

//Username to use for SMTP authentication - use full email address for gmail
$mail->Username = 'tompouce_82@hotmail.com';

//Password to use for SMTP authentication
$mail->Password = "Di@blo22";

//Set who the message is to be sent from
$mail->setFrom($email, $name);

//Set an alternative reply-to address
$mail->addReplyTo($email, $name);

//Set who the message is to be sent to
$mail->addAddress($email_vbiketours, 'vbiketours');

//Set the subject line
$mail->Subject = $subject;

//Read an HTML message body from an external file, convert referenced images to embedded,
//convert HTML into a basic plain-text alternative body

//.....$mail->msgHTML(file_get_contents('contents.html'), dirname(__FILE__));

//Replace the plain text body with one created manually
$mail->Body = $message;

//Attach an image file
//$mail->addAttachment('images/phpmailer_mini.png');

//send the message, check for errors
if (!$mail->send()) {
	$msg = $_SESSION ['msg'] = "Mailer Error: " . $mail->ErrorInfo;
} else {
	$msg = $_SESSION ['msg'] = "Your email was successfully sent!";
}


$mail->SmtpClose();
unset($mail);
}
include "controller/welcome_ctl.php";
include "tools/alert_message.php";
?>