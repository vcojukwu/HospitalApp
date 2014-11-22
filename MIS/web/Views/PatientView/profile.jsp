<!doctype html>
<html lang="en">
<%-- The following 4 lines are needed in every page from now on --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Profile</title>
    
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
        <%-- Whenever you write out the path do not put a front slash--%>
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
    <p align="center"><a style="padding-left:0" href="#"><%= patientProfile.getUser().getFirstName()%>  <%= patientProfile.getUser().getLastName()%></a></p>
            <ul style="margin-top:20%">
            
                <li class="menu-item-divided pure-menu-selected"><a href="profile.html">Profile</a></li>
                <li><a href="appointments.html">Past Appointments</a></li>
                <li><a href="prescriptions.html">Prescriptions</a> </li>
                <li><a href="diagnosis.html">Diagnosis</a></li>
                <li><a href="requests.html">Request Appointment</a></li>
                <li><a href="#">Logout</a></li>

                
            </ul>
        </div>
    </div>

    <div id="main">
        <div class="header">
            <h1>Profile</h1>
        </div>

        <div class="content" style="padding-top:30px">
            <img style="margin-left:40%" src="Images/profilepic.jpg"/>
            
            <div style="float:right; width:45%; height:80%; margin-left:5%">
            <p>Upcoming Appointments</p>
            <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            </ul>
            </div>
            
            <div style="float:left; width:50%"><form class="pure-form pure-form-aligned">
    <fieldset>
    	<legend>Contact Information</legend>
        <div class="pure-control-group">
            <label for="address">Address :</label>
            <input id="address" type="text" value='<%= patientProfile.getAddress().getStreetNumber() %>  <%= patientProfile.getAddress().getStreetName() %>' disabled>
        </div>

        <div class="pure-control-group">
            <label for="city">City :</label>
            <input id="city" type="text" value=<%= patientProfile.getAddress().getCity() %> disabled>
        </div>
        
        <div class="pure-control-group">
            <label for="state">Province :</label>
            <input id="state" type="text" value=<%= patientProfile.getAddress().getProvince() %> disabled>
        </div>
		
        <div class="pure-control-group">
            <label for="zip">Postal Code :</label>
            <input id="zip" type="text" value=<%=patientProfile.getAddress().getPostalCode() %> disabled>
        </div>
        
        <div class="pure-control-group">
            <label for="phone">Phone Number :</label>
            <input id="phone" type="tel" value=<%= patientProfile.getUser().getPhoneNumber() %> disabled>
        </div>
        
        <div class="pure-control-group">
            <label for="email">Email Address :</label>
            <input id="email" type="email" value=<%= patientProfile.getUser().getUserId()%> disabled>
        </div>

 
       <div class="pure-controls">
            <button style="margin-left:5%" type="submit" class="pure-button pure-button-primary">Submit</button>
            <button onClick="enable();return false" style="margin-left:5%" type="button" class="pure-button pure-button-primary">Edit</button>
        </div>
        
    </fieldset>
</form>
            
            </div>
        </div>
    </div>
</div>


</body>
</html>