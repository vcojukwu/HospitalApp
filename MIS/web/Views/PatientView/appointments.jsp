<!doctype html>
<html lang="en">
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <c:set var="url">${pageContext.request.requestURL}</c:set>
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Profile</title>

        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
        <link rel="stylesheet" type="text/css" href="CSS/test.css">
        <script src="JS/test.js"></script>

    </head>
    <body>
        <jsp:useBean id="patientProfile" class="ViewModel.UserProfileVM" scope="session"/>
        <div id="layout">
            <!-- Menu toggle -->
            <a href="#menu" id="menuLink" class="menu-link">
                <!-- Hamburger icon -->
                <span></span>
            </a>

            <div id="menu">
                <div class="pure-menu pure-menu-open">
                    <p class="pure-menu-heading" align="center">UWH</p>
                    <a href="#"><img src="Images/uwhlogo.jpg" alt="Insert Logo Here" width="120" height="90" id="Insert_logo" style="margin-left:17px"/>
                    </a>
                    <p align="center"><a style="padding-left:0" href="#">Username</a></p>
                    <ul style="margin-top:20%">

                        <li class="menu-item-divided"><a href="profile.html">Profile</a></li>
                        <li class="menu-item-divided pure-menu-selected"><a href="appointments.html">Past Appointments</a></li>
                        <li><a href="prescriptions.html">Prescriptions</a> </li>
                        <li><a href="diagnosis.html">Diagnosis</a></li>
                        <li><a href="requests.html">Request Appointment</a></li>
                        <li><a href="#">Logout</a></li>   
                    </ul>
                </div>
            </div>

            <div id="main">
                <div class="header">
                    <h1>Past Appointments</h1>
                </div>

                <div class="content">


                </div>
            </div>
        </div>


    </body>
</html>