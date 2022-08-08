<?php
$counter_name = "counter.txt";
$time = time() + 60*60*24;
$format = date("H:i:s - m/d/y");
setcookie("lastVisit",$format, $time );

// Check if a text file exists. If not create one and initialize it to zero.
if (!file_exists($counter_name)) {
  $f = fopen($counter_name, "w");
  fwrite($f,"0");
  fclose($f);
}
// Read the current value of our counter file
$f = fopen($counter_name,"r");
$counterVal = fread($f, filesize($counter_name));
fclose($f);
// Has visitor been counted in this session?
// If not, increase counter value by one
if(!isset($_SESSION['hasVisited'])){
  $_SESSION['hasVisited']="yes";
  $counterVal++;
  $f = fopen($counter_name, "w");
  fwrite($f, $counterVal);
  fclose($f);
}
echo "You are visitor number $counterVal to this site <br>";

if (isset($_COOKIE["lastVisit"])) {
  echo "Your last vist was: ";
  echo $_COOKIE["lastVisit"];
}else{
echo "Welcome this is the first time you are here";}
?>
