<%-- 
    Document   : reversal
    Created on : Apr 5, 2018, 11:35:57 AM
    Author     : gaddafi
--%>

<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reverse Airtime Purchase</title>
        <link type="text/css" rel="stylesheet" href="/Reversal/css/style.css">
        <link type="text/css" rel="stylesheet" href="/Reversal/css/notification.css">
        <link rel="stylesheet" href="/Reversal/css/animate.css">
        <!-- Custom Stylesheet -->
        <link rel="stylesheet" href="/Reversal/css/style.css">

	<link href="/Reversal/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/Reversal/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	<link href="/Reversal/css/landing-page.css" rel="stylesheet">

        <script src="/Reversal/js/jquery.min.js"></script>
        <link rel="stylesheet" href="/Reversal/css/jquery-ui.css">
        <link rel="stylesheet" href="/Reversal/css/style2.css">
        <link rel="stylesheet" href="/Reversal/css/base.css">
        <link rel="stylesheet" href="/Reversal/css/style.css">
        <link rel="stylesheet" href="/Reversal/css/style2.css">
        <link rel="stylesheet" href="/Reversal/css/style_1.css">
        <link href="/Reversal/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="../../css/landing-page.css" rel="stylesheet">
        <script src="../../js/jquery-1.12.4.js"></script>
        <script src="../../js/jquery-ui.js"></script>
        <%@include file="../../js/validate/validate_create_ticket.inc" %>
    </head>
    <body>
        
        <%@include file="../../include/operator/menu.inc"%>
        <%!
            List<String> operators;
            int role;
            String name;
        %>
        <%
            if (request.getSession(false) == null) {
                response.sendRedirect("/index.jsp");
            }
            if (!(session.getAttribute("role") == null)) {
                role = Integer.parseInt((String)request.getAttribute("role"));
            } else {
                role = 0;
            }
            if (role != 2) {
                //
                response.sendRedirect("/index.jsp");
            }
            //td = (TicketDetails) request.getAttribute("raised_tickets");
            name = (String) session.getAttribute("given_name");
            
            InitialContext ctx = new InitialContext();
            DataSource datasource = (org.apache.tomcat.jdbc.pool.DataSource) ctx.lookup("java:/comp/env/jdbc/reversal");
            Selects sel = new Selects();
            operators = sel.getAllOperators(datasource);
            
        %>
        <div class="container">
            <div class="login-box animated fadeInUp">
                <div class="box-header">
                    <h2>Create New Ticket</h2>
                    <!--<a href="index.html">Send SMS?</a>-->
                </div>
                <form name="create_ticket" method="GET" action="/Reversal/servlet/OperatorController" onsubmit="return validate()">
                <input type="hidden" name="COMMAND" value="reverse"/><br/>
                <span><b>MPesa receipt number</b></span><br/>
                <input type="text" name="receipt" required="required" id="otid"/><br/><br/>
                <span><b>Safaricom number</b></span><br/>
                <input type="text" name="safno" required="required" id="safno"/><br/><br/>
                <span><b>Telkom number</b></span><br/>
                <input type="text" name="tklno" required="required" id="tklno"/><br/><br/>
                <span><b>Customer names</b></span><br/>
                <input type="text" name="kyc" required="required" id="kyc"/><br/><br/>
                <span><b>Amount (Ksh)</b></span><br/>
                <input type="text" name="amount" required="required" id="amount"/><br/><br/>
                <label><b>Transaction date</b></label><br/>
                <input type="text" name="trans_date" required="required" id="trans_date"/><br/><br/>
                <p>Tick to reverse <input type="checkbox" name="status" id="status" value="complete" required="required"></p><br/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    </body>
</html>
