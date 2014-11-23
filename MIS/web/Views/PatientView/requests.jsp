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
            <%@include file="/WEB-INF/jspf/SideBars/patientSideBar.jspf" %>
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
