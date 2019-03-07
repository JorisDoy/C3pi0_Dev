<%-- 
    Document   : index
    Created on : Feb 21, 2018, 6:09:30 AM
    Author     : gaddafi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer care login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/loginScript.js"></script>
        <link rel="stylesheet" href="css/loginStyle.css">
        <style>
            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                padding-top: 100px; /* Location of the box */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            }

            /* Modal Content */
            .modal-content {
                background-color: #fefefe;
                margin: auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
            }

            /* The Close Button */
            .close {
                color: #aaaaaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: #000;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
        <script>
//            var modal = document.getElementById('myModal');
//            var span = document.getElementsByClassName("close")[0];
//            span.onclick = function () {
//                modal.style.display = "none";
//            }
//
//// When the user clicks anywhere outside of the modal, close it
//            window.onclick = function (event) {
//                if (event.target == modal) {
//                    modal.style.display = "none";
//                }
//            }
            function validate() {
                var a = document.forms["login"]["username"].value;
                var b = document.forms["login"]["passwd"].value;
                //var modal = document.getElementById('myModal');
                var modal = document.getElementById('myModal');
                var span = document.getElementsByClassName("close")[0];
                span.onclick = function () {
                    modal.style.display = "none";
                }

// When the user clicks anywhere outside of the modal, close it
                window.onclick = function (event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }

// Get the button that opens the modal
                //var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal


                // is correct date Entered?
                if (a == null || a == "") {
                    document.getElementById("idvice").innerHTML = "Please insert domain name";
                    modal.style.display = "block";
                    //var popup = document.getElementById("u_pop");
                    //popup.classList.toggle("show");
//                    alert("Please select a date");
//                    document.getElementById("idvice").innerHTML = "Please insert a valid date";
                    return false;
                } else if (b == null || b == "") {
                    document.getElementById("idvice").innerHTML = "Please insert domain password";
                    modal.style.display = "block";
//                    var popup = document.getElementById("p_pop");
//                    popup.classList.toggle("show");
                    return false;
                }

                return true;
            }
            ;


        </script>
    </head>
    <body>
        <%!
            String MESSAGE;
        %>
        <%
            MESSAGE = request.getParameter("message");
            if (MESSAGE == null) {
                MESSAGE = "";
            }
        %>
        <div class="login-page">
            <div class="form">
                <!--    <form class="register-form">
                      <input type="text" placeholder="name"/>
                      <input type="password" placeholder="password"/>
                      <input type="text" placeholder="email address"/>
                      <button>create</button>
                      <p class="message">Already registered? <a href="#">Sign In</a></p>
                    </form>-->
                <form class="login-form" method="POST" action="/Reversal/servlet/Login">
                    <p><%=MESSAGE%></p><br/>
                    <input type="hidden" name="COMMAND" value="Login"/><br/>
                    <input type="text" name="username" placeholder="username" required="required"/>
                    <input type="password" name="password" placeholder="password" required="required"/>
                    <!--      <input type="submit" value="Stats" id="statistics"/>-->
                    <button type="submit" value="submit" name="submit"> Login </button>
                </form>
            </div>
        </div>
    </body>
</html>