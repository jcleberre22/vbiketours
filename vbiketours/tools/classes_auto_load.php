<?php
function loadClass($class)
{
  require $_SERVER['DOCUMENT_ROOT'].'VBIKETOURS/Model/Classes/'.$class .'.php'; // include the class
}

spl_autoload_register('loadClass'); // Record function loadClass into the autoload register
?>