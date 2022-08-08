<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport">
    <title>Question 1</title>
  </head>
  <body>
    <h1>Function: uppercaseFirstandLast </h1>
    <p>A) Capitalizing first and last letter of every word of input string</p>
      <?php
        function uppercaseFirstandLast($str){
          //Make all letters lower case
          //Capitalize first character using ucwords
          //Reverse and do the same thing again
          //strrev again to get back to original string
          echo strrev(ucwords(strrev(ucwords(strtolower($str)))));
        }
        uppercaseFirstandLast("Capitalizing first and last letter of every word of input string");



       ?>
    <h1>Function findAverage_and_Median</h1>
    <form method="post" onsubmit="Q1.php">
      <label for="txtInput">Please enter your integers</label>
      <input type="text" name="txtInput">
      <input type = "submit" name="submit">
    </form>

    <?php
      $integers = $_POST["txtInput"];
      $array = explode("," , $integers);
      if(isset($_POST['submit']))
      {
         findAverage_and_Median($array);
      }

      function findAverage_and_Median($array)
      {
        sort($array);
        $avg = array_sum($array) / count($array);
        $sizeOfArray = sizeof($array);
        $middle = floor($sizeOfArray/2);
        if (!$sizeOfArray) {echo "no values";}
        elseif ($sizeOfArray & 1) {
          $median = $array[$middle];
          echo "Median: $median <br>";
        }
        else {
          $median = (($array[$middle-1] + $array[$middle])/2);
          echo "Median: $median <br>";
        }
        echo "Average: $avg";
      }

     ?>

  </body>
</html>
