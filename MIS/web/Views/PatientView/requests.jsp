<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Profile</title>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<link rel="stylesheet" type="text/css" href="../../CSS/test.css">
<script src="../../JS/test.js"></script>

</head>
<body>

<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

    <div id="menu">
        <div class="pure-menu pure-menu-open">
            <p class="pure-menu-heading" align="center">UWH</p>
            <a href="#"><img src="../../Images/uwhlogo.jpg" alt="Insert Logo Here" width="120" height="90" id="Insert_logo" style="margin-left:17px"/>
    </a>
    	<p align="center"><a style="padding-left:0" href="#">Username</a></p>
            <ul style="margin-top:20%">
            
                <li class="menu-item-divided"><a href="profile.html">Profile</a></li>
                <li><a href="appointments.html">Past Appointments</a></li>
                <li><a href="prescriptions.html">Prescriptions</a> </li>
                <li><a href="diagnosis.html">Diagnosis</a></li>
                <li class="menu-item-divided pure-menu-selected"><a href="requests.html">Request Appointment</a></li>
                <li><a href="#">Logout</a></li>

                
            </ul>
        </div>
    </div>

    <div id="main">
        <div class="header">
            <h1>Request a New Appointment</h1>
        </div>

        <div class="content" style="margin-top:10%">
            <form class="pure-form pure-form-aligned">
    <fieldset>
        <div class="pure-control-group">
            <label for="doctor">Select Doctor :</label>
            <input id="doctor" type="text" placeholder="Doctor">
        </div>

        <div class="pure-control-group">
            <label for="time">Time :</label>
            <input id="time" type="time">
        </div>

        <div class="pure-control-group">
            <label for="date">Date :</label>
            <input id="date" type="date">
        </div>

            <button type="submit" style="margin-left:50%;" class="pure-button pure-button-primary">Submit</button>
    </fieldset>
</form>
        </div>
    </div>
</div>


</body>
</html>