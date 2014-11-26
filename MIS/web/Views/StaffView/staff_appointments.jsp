<%@include file="/WEB-INF/jspf/SideBars/staffSideBar.jspf" %>
<script>
function addRow2(r){
	var i = r.parentNode.parentNode.rowIndex;
	var table = document.getElementById("appointments");
	var row = table.insertRow(i);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
	var patientList = "";
        var doctorList = "";
        <c:forEach items="${patients}" var="patient">
            patientList += "<option value = ${patient.getPatientId()}>${patient.getPatientId()}</option>";
        </c:forEach>
        <c:forEach items="${doctors}" var="doctor">
            doctorList += "<option value = ${doctor.getDoctorId()}>${doctor.getDoctorId()}</option>";
        </c:forEach>
	cell1.innerHTML = "<select id=\"patient\" class=\"pure-input-1-2 patientDropdown rowData\">" + patientList + "</select>";
	cell2.innerHTML = "<select id=\"doctor\" class=\"pure-input-1-2 doctorDropdown rowData\">" + doctorList + "</select>";	
        cell3.innerHTML = '<input name="date" class="rowData" type="date">';
        cell4.innerHTML = '<input name="time" class="rowData" type="time">';
	cell5.innerHTML = '<input name="duration" class="rowData" style="width:100%" type="number">';
        cell6.innerHTML = '<input onClick="enableRow(this);" class="pure-button pure-input-1-2 pure-button-primary" type="submit" name="Add" value="Add" /> ';
        cell6.innerHTML += '<input onClick="deleteRow3(this);" class="pure-button pure-input-1-2 pure-button-primary" type="button" name="Remove" value="Remove" />';                 
}
</script>

<div id="main">
    <div class="header">
        <h1>Appointments</h1>
        <h2>View, Add, Delete and Reschedule Appointments</h2>
    </div>

    <div class="content" style="padding-top:30px; margin:5% !important; max-width:none !important">
        <input name="scheduleConflict" value=${scheduleConflict}>
        <form method="post" action="AddAppointments">            
            <table class="pure-table pure-table-bordered" id="appointments">
                <input type="hidden" name="patIdFinal" id="patIdFinal">
                <input type="hidden" name="docIdFinal" id="docIdFinal">      
                <input type="hidden" name="timeFinal" id="timeFinal">
                <input type="hidden" name="dateFinal" id="dateFinal">
                <input type="hidden" name="durationFinal" id="durationFinal">
                <input type="hidden" name="appointmentIdFinal" id="appointmentIdFinal">
                <input type="hidden" name="function" id="function">
                <thead>
                    <tr>
                        <th>Patient ID</th>
                        <th>Doctor ID</th>
                        <th>Start Date</th>
                        <th>Start Time</th>
                        <th>Duration</th>
                        <th><span style="visibility:hidden">EditandDeleteButtons</span></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${appointments}" var="appointment">                        
                    <tr>
                        <td>
                            <input type="hidden" class="rowData" name="appointmentId" class="appointmentId" value = ${appointment.getAppointmentId()} disabled>
                            <select id="patient" class="pure-input-1-2 patientDropdown rowData" disabled>
                                <c:forEach items="${patients}" var="patient">
                                    <c:choose>
                                        <c:when test="${appointment.getPatientId() == patient.getPatientId()}">
                                            <option selecvalue = ${patient.getPatientId()} selected>${patient.getPatientId() }</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value = ${patient.getPatientId()}>${patient.getPatientId()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>                            
                        </td>
                        <td>
                            <select id="doctor" class="pure-input-1-2 patientDropdown rowData" disabled>
                                <c:forEach items="${doctors}" var="doctor">
                                    <c:choose>
                                        <c:when test="${appointment.getDoctorId() == doctor.getDoctorId()}">
                                            <option value = ${doctor.getDoctorId()} selected>${doctor.getDoctorId()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value = ${doctor.getDoctorId()}>${doctor.getDoctorId()}</option>
                                        </c:otherwise>
                                    </c:choose>                                        
                                </c:forEach>
                            </select>
                        </td>                        
                        <td><input name="date" class="rowData" type="date" value = ${appointment.getDate()} disabled></td>
                        <td><input name="time" class="rowData" type="time" value = ${appointment.getTimeScheduledUI()} disabled></td>
                        <td><input name="duration" class="rowData" type="number" style="width:100%" value="${appointment.getDurationScheduled()}"  disabled></td>
                        <td>
                            <input onClick="enableRow(this);return false" class="pure-button pure-input-1-2 pure-button-primary" type="button" name="Edit" value="Edit" />
                            <input onClick="deleteRow2(this);" class="pure-button pure-input-1-2 pure-button-primary" type="button" name="Delete" value="Delete" />
                        </td>
                    </c:forEach>
                    </tr>
                </tbody>
            </table>
        </form>
        <button title="Add New Appointment" class="button-success pure-button" style="float:right" onClick="addRow2(this);
                return false">
            <i class="fa fa-plus"></i>
        </button>
        <form style="display:none" class="pure-form pure-form-stacked">
            <fieldset>
                <button type="submit" class="pure-button pure-button-primary">Submit</button>
            </fieldset>
        </form>
    </div>
</div>

