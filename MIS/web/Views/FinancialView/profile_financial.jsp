<jsp:useBean id="financialProfile" class="ViewModel.UserProfileVM" scope="session"/>
<div id="layout">
    <a href="#menu" id="menuLink" class="menu-link"></a>

    <div id="menu">
        <div class="pure-menu pure-menu-open">
            <p class="pure-menu-heading" align="center" style="background-color:#54F707">UWH</p>
            <a href="#"><img src="Images/uwhlogo.jpg" alt="Insert Logo Here" width="120" height="90" id="Insert_logo" style="margin-left:17px"/></a>
            <p align="center"><a style="padding-left:0" href="#"><%= financialProfile.getUser().getFirstName()%>  <%= financialProfile.getUser().getLastName()%></a></p>
            <ul style="margin-top:20%">            
                <li class="menu-item-divided pure-menu-selected" style="background-color:#54F707"><a href="profile_financial.jsp">Profile</a></li>
                <li><a href="doctor_search.html">Doctor Search</a></li>
                <li><a href="financialpatient_search.html">Patient Search</a></li>
                <li><a href="revenue.html">Monthly Revenue</a></li>
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
                <p>Schedule</p>
                <ul>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                </ul>
            </div>            
            <div style="float:left; width:50%">
                <form class="pure-form pure-form-aligned">
                    <fieldset>
                        <legend>Contact Information</legend>
                        <div class="pure-control-group">
                            <label for="address">Address :</label>
                            <input id="address" type="text" value='<%= financialProfile.getAddress().getStreetNumber()%>  <%= financialProfile.getAddress().getStreetName()%>' disabled>
                        </div>
                        <div class="pure-control-group">
                            <label for="city">City :</label>
                            <input id="city" type="text" value=<%= financialProfile.getAddress().getCity()%> disabled>
                        </div>        
                        <div class="pure-control-group">
                            <label for="state">Province :</label>
                            <input id="state" type="text" value=<%= financialProfile.getAddress().getProvince()%> disabled>
                        </div>		
                        <div class="pure-control-group">
                            <label for="zip">Postal Code :</label>
                            <input id="zip" type="text" value=<%=financialProfile.getAddress().getPostalCode()%> disabled>
                        </div>        
                        <div class="pure-control-group">
                            <label for="phone">Phone Number :</label>
                            <input id="phone" type="tel" value=<%= financialProfile.getUser().getPhoneNumber()%> disabled>
                        </div>        
                        <div class="pure-control-group">
                            <label for="email">Email Address :</label>
                            <input id="email" type="email" value=<%= financialProfile.getUser().getUserId()%> disabled>
                        </div> 
                        <div class="pure-controls">
                             <button style="margin-left:5%" type="submit" class="pure-button pure-button-primary">Save</button>
                             <button onClick="enable();return false" style="margin-left:5%" type="button" class="pure-button pure-button-primary">Edit</button>
                        </div>        
                    </fieldset>
                </form>            
            </div>
        </div>
    </div>
</div>