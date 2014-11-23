<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Enter a New Visitation Record</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form pure-form-aligned">
            <fieldset>
                <div class="pure-control-group">
                    <label for="name">Patient Name</label>
                    <input id="name" type="text" placeholder="Name">
                </div>

                <div class="pure-control-group">
                    <label for="diagnosis">Diagnosis</label>
                    <input id="diagnosis" type="text" placeholder="Diagnosis">
                </div>

                <div class="pure-control-group">
                    <label for="prescriptions">Prescription</label>
                    <input id="prescriptions" type="text" placeholder="Prescription">
                </div>

                <div class="pure-control-group">
                    <label for="timestarted">Time-Started</label>
                    <input id="timestarted" type="time">
                </div>

                <div class="pure-control-group">
                    <label for="timeended">Time-Ended</label>
                    <input id="timeended" type="time">
                </div>

                <div class="pure-control-group">
                    <label for="comment">Comments</label>
                    <textarea name="comment" form=""></textarea>
                </div>

                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Submit</button>
                </div>
            </fieldset>
        </form>

    </div>
</div>
