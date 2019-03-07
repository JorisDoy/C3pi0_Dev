<%-- 
    Document   : home
    Created on : Mar 14, 2018, 4:00:58 PM
    Author     : gaddafi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Data Record</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="css/animate.css">
        <!-- Custom Stylesheet -->
        <link rel="stylesheet" href="css/style.css">

        <script src="js/jquery.min.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/style2.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script>
            $(document).ready(function () {
                $('#logo').addClass('animated fadeInDown');
                //$("#datepicker").datepicker();
                //$( "#datepicker" ).datepicker({  maxDate: new Date() });
                //$("#datepicker").datepicker({ maxDate: new Date, minDate: new Date(2007, 6, 12) });
                $( "#datepicker" ).datepicker({  maxDate: 0 });
            });

            $('#fileUp').focus(function () {
                $('label[for="fileUp"]').addClass('selected');
            });
            $('#fileUp').blur(function () {
                $('label[for="fileUp"]').removeClass('selected');
            });
            $('#mess').focus(function () {
                $('label[for="mess"]').addClass('selected');
            });
            $('#mess').blur(function () {
                $('label[for="mess"]').removeClass('selected');
            });
            
            var input_selected = "";

            function validate() {
                var a = document.forms["paybill_form"]["receipt"].value;
                var b = document.forms["paybill_form"]["safno"].value;
                var c = document.forms["paybill_form"]["tklno"].value;
                var d = document.forms["paybill_form"]["tdate"].value;
                // is correct date Entered?
                if(a !== null || a !== ""){
                    //alert("Please select a date");
                    //document.getElementById("idvice").innerHTML = "Please insert a valid date";
                    //return false;
                    input_selected = input_selected + "A";
                }
                
                if(b !== null || b !== ""){
                    if(b.length === 10){
                        input_selected = input_selected + "B";
                    } else{
                        alert("Safaricom number should be atleast 10 digits long");
                        $('#saf_no').focus();
                        return false;
                    }
                    
                }
                
                if(c !== null || c !== ""){
                    if(c.length === 10){
                        input_selected = input_selected + "C";
                    } else{
                        alert("Telkom number should be atleast 10 digits long");
                        $('#tkl_no').focus();
                        return false;
                    }
                    
                }
                
                if(d !== null || d !== ""){
                    // validatedate
                    if(isValidDate(d)){
                        input_selected = input_selected + "D";
                    } else{
                        alert("Invalid date format!");
                        $('#t_date').focus();
                        return false;
                    }
                    
                }
                
                if(input_selected !== ""){
                    // insert value into hidden 
                    document.getElementById("input_params").value = input_selected;
                } else{
                    alert("Insert atleast one search parameter");
                    $('#reciept').focus();
                    return false;
                }
                
                return true;
            };

            // Validates that the input string is a valid date formatted as "mm/dd/yyyy"
            function isValidDate(dateString)
            {
                // First check for the pattern
                if (!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
                    return false;

                // Parse the date parts to integers
                var parts = dateString.split("/");
                var day = parseInt(parts[1], 10);
                var month = parseInt(parts[0], 10);
                var year = parseInt(parts[2], 10);

                // Check the ranges of month and year
                if (year < 1000 || year > 3000 || month == 0 || month > 12)
                    return false;

                var monthLength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

                // Adjust for leap years
                if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
                    monthLength[1] = 29;

                // Check the range of the day
                return day > 0 && day <= monthLength[month - 1];
            }
            ;
        </script>
    </head>
    <body>
        <div class="container">

            <div class="login-box animated fadeInUp">
                <div class="box-header">
                    <h2>Search Paybill Records</h2>
                    <!--<a href="index.html">Send SMS?</a>-->
                </div>
                <form name="paybill_form" action="/LipaNaMPesa/servlet/OperatorController" method="POST" onsubmit="return validate()">
                    <!-- <label id="idvice">Insert Safaricom Receipt number</label><br/> -->
                    <input type="hidden" id="input_params" name="COMMAND" /><br/>
                    <input type="text" id="reciept" name="receipt" placeholder="MPesa Receipt Number"/>
                    <input type="text" id="saf_no" name="safno" placeholder="Safaricom Number" maxlength="10"/>
                    <input type="text" id="tkl_no" name="tklno" placeholder="Telkom Number" maxlength="10"/>
                    <input type="text" id="t_date" name="tdate" placeholder="Date"/><br/>
                    <span id="returned_message"></span><br/>
                    <input type="submit" value="Search" id="getRecords">
                </form>
            </div>
        </div>
    </body>
</html>
