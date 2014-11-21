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
                    <p class="pure-menu-heading" align="center" style="background-color:#DDF10A">UWH</p>
                    <a href="#"><img src="../../Images/uwhlogo.jpg" alt="Insert Logo Here" width="120" height="90" id="Insert_logo" style="margin-left:17px"/>
                    </a>
                    <p align="center"><a style="padding-left:0" href="#">Username</a></p>
                    <ul style="margin-top:20%">

                        <li class="menu-item-divided"><a href="profile_staff.jsp">Profile</a></li>
                        <li class="pure-menu-selected" style="background-color:#DDF10A"><a href="new_user.jsp">Add New User</a></li>
                        <li><a href="staff_appointments.html">Appointments</a> </li>
                        <li><a href="staffpatient_search.html">Patient Search</a></li>
                        <li><a href="assign.html">Assign Patients</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </div>
            </div>

            <div id="main">
                <div class="header">
                    <h1>Add a New User</h1>
                </div>

                <div class="content" style="padding-top:30px">
                    <form class="pure-form pure-form-aligned">
                        <fieldset class="pure-group">
                            <legend>User Information</legend>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="user">User Type:</label>
                                <input id="user" style="display:inline-block" type="number">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="fname">First Name :</label>
                                <input id="fname" style="display:inline-block" type="text" placeholder="First Name">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="lname">Last Name :</label>
                                <input id="lname" style="display:inline-block" type="text" placeholder="Last Name">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="gender">Gender :</label>
                                <input id="gender" style="display:inline-block" type="text" placeholder="Gender">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="dob">Date of Birth :</label>
                                <input id="dob" style="display:inline-block" type="date">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="phone">Phone Number :</label>
                                <input id="phone" style="display:inline-block" type="tel">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="email">Email :</label>
                                <input id="email" style="display:inline-block" type="email" placeholder="Email">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="password">Password :</label>
                                <input id="password" style="display:inline-block" type="password" placeholder="Enter Password">
                            </div>

                        </fieldset>

                        <fieldset class="pure-group">
                            <legend>Address</legend>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="street_num">Street Number:</label>
                                <input id="street_num" style="display:inline-block" type="number">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="street_name">Street Name :</label>
                                <input id="street_name" style="display:inline-block" type="text" placeholder="Street Name">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="city">City :</label>
                                <input id="city" style="display:inline-block" type="text" placeholder="City">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="province">Province :</label>
                                <input id="province" style="display:inline-block" type="text" placeholder="Province">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="country">Country :</label>
                                <input id="country" style="display:inline-block" type="text" placeholder="Country">
                            </div>
                            <div class="pure-input-1-2 pure-control-group">
                                <label for="zip">Postal Code :</label>
                                <input id="zip" style="display:inline-block" type="text">
                            </div>
                        </fieldset>

                        <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">Create User</button>
                    </form>

                </div>
            </div>
        </div>


    </body>
</html>