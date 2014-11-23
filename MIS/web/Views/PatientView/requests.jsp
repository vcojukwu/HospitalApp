<%@include file="/WEB-INF/jspf/SideBars/patientSideBar.jspf" %>
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

