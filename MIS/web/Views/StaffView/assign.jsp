<%@include file="/WEB-INF/jspf/SideBars/staffSideBar.jspf" %>
<script>
function addRow() {
    var div = document.createElement('div');
    var string = "";
    <c:forEach items="${patients}" var="patient">
        string += "<option value = ${patient.getPatientId()}>${patient.getFirstName()} ${patient.getLastName()}</option>";
    </c:forEach>
    div.innerHTML = "<select id=\"doctor\" class=\"pure-input-1-2 patientDropdown\">" + string + "</select>";
    div.style.width = "50%";
    div.style.marginLeft = "50%";
    document.getElementById('dynamic_content').appendChild(div);
    document.getElementById("remove").disabled = false;
}

function myFunction() {
    var x = document.getElementsByClassName("patientDropdown");
    var i = 0;
    var patientIds = "";
    for(i = 0; i < x.length - 1; i++){
        patientIds += x[i].options[x[i].selectedIndex].value + ",";
    }
    patientIds += x[x.length - 1].options[x[x.length - 1].selectedIndex].value;
    console.log(patientIds);
    var ids = document.getElementById("patientIDs");
    ids.value = patientIds;
}
</script>

<div id="main">
    <div class="header">
        <h1>Assign Patients to Doctors</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form pure-form-stacked" method = "post" action = "Staff">
            <fieldset>
                <div class="pure-g" id="dynamic_content">

                    <div class="pure-u-1 pure-u-md-1-3" style="width:50% !important">
                        <label for="doctor">Select Doctor</label>
                        <select name = "doctorId" id="doctor" class="pure-input-1-2 doctorDropdown">                            
                            <c:forEach items="${doctors}" var="doctor">
                                <option value=${doctor.getDoctorId()}>${doctor.getFirstName()} ${doctor.getLastName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="pure-u-1 pure-u-md-1-3" style="width:50% !important">
                        <label for="patient">Patient</label>
                        <select name = "patientId" id="patient" class="pure-input-1-2 patientDropdown">                            
                            <c:forEach items="${patients}" var="patient">
                                <option value=${patient.getPatientId()}>${patient.getFirstName()} ${patient.getLastName()}</option>
                            </c:forEach>
                        </select>
                    </div>                    
                </div>
				<input type="text" name="patientIDs" id="patientIDs" style="display:none">
                <button type="submit" class="pure-button pure-button-primary" onClick="myFunction();">Make Assignment</button>

                <button type="buttin" onClick="addRow();
                        return false" class="pure-button pure-button-primary" style="margin-left:44%">+</button>

                <button id="remove" type="button" onClick="deleteRow();
                        return false" class="pure-button pure-button-primary" disabled>-</button>  

            </fieldset>
        </form>
    </div>

</div>




