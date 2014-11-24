<%@include file="/WEB-INF/jspf/SideBars/staffSideBar.jspf" %>

<div id="main">
    <div class="header">
        <h1>Assign Patients to Doctors</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form pure-form-stacked">
            <fieldset>
                <div class="pure-g" id="dynamic_content">

                    <div class="pure-u-1 pure-u-md-1-3" style="width:50% !important">
                        <label for="patient">Patient</label>
                        <select id="patient" class="pure-input-1-2">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                        </select>
                    </div>

                    <div class="pure-u-1 pure-u-md-1-3" style="width:50% !important">
                        <label for="doctor">Select Doctor</label>
                        <select id="doctor" class="pure-input-1-2">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                        </select>
                    </div>
                </div>

                <button type="submit" class="pure-button pure-button-primary">Make Assignment</button>

                <button type="buttin" onClick="addRow();
                        return false" class="pure-button pure-button-primary" style="margin-left:44%">+</button>

                <button id="remove" type="button" onClick="deleteRow();
                        return false" class="pure-button pure-button-primary" disabled>-</button>  

            </fieldset>
        </form>
    </div>

</div>




