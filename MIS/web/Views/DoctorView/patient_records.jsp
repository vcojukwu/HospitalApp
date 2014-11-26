<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>
<script>function addRowPatientRecord(r){
    
        var dt = new Date();
        var newdate =dt.getFullYear() + "-" + (dt.getMonth() + 1) + "-" + dt.getDate();
        var timenow = dt.getHours() + ":" + dt.getMinutes();
	var i = r.parentNode.parentNode.rowIndex;
	var table = document.getElementById("records");
	var row = table.insertRow(i);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);
	
	cell1.innerHTML = '<select id="procedureId" name="procedureId">\
                                    <c:forEach items="${procedures}" var="procedures" >\
                                        <option value="${procedures.getProcedureId()}">${procedures.getProcedureName()}</option>\
                                    </c:forEach>\
                                </select>';
	cell2.innerHTML = '<input id="date" type="date" value ="' + newdate + '">';
        cell3.innerHTML = '<input id="timestarted" type="time" value="' + timenow + '" >';
	cell4.innerHTML = '<input id="timeended" type="time" value="' + timenow + '" >';
	cell5.innerHTML = '<input id="precriptions" type="text" value ="" >';
	cell6.innerHTML = '<input id="Diagnosis" type="text" value ="" >';
	cell7.innerHTML = '<input id="notes" type="text" value = "" >';
	cell8.innerHTML = '<button title="Save" value="PatientRecord" name="PatientRecord" onclick="enableRowPatientRecord(this); \
                                    return false" style="margin-right:15%; margin-left:15%" class="pure-button">\
                                    <i class="fa fa-floppy-o"></i>\
                           </button>';
                                        
        var input1 = document.createElement('input');
        var input2 = document.createElement('input');
        var input3 = document.createElement('input');
        
        input1.id = "originalrecordid";
        input2.id = "recordId";
        input3.id = "recordType";
        input1.type = "hidden";
        input2.type = "hidden";
        input3.type = "hidden";
        input1.value = "${item.getVisitationRecord().getOriginalRecordId()}";
        input2.value = "${item.getVisitationRecord().getRecordId()}";
        input3.value = "0";
   
        row.appendChild(input1);       
        row.appendChild(input2);  
        row.appendChild(input3);  
                                        
    return false;
}

    
</script>
<div id="main">
    <div class="header">
        <h1>Patient Record</h1>
    </div>

    <div class="content" style="padding-top:30px; margin:5% !important">
        <form class="pure-form">
            <fieldset>
                <legend>Search for a Patient</legend>

                <input name ="patientId" id="patientId" type="text" class="pure-input-rounded" value="${patientInfo.getUserId()}" disabled>
                <input name ="firstname" id="firstname" type="text" class="pure-input-rounded" value="${patientInfo.getFirstName()}" disabled>
                <input name ="lastname" id="lastname" type="text" class="pure-input-rounded" value="${patientInfo.getLastName()}" disabled>
            </fieldset>
        

            <table class="pure-table pure-table-bordered" id="records">
                <thead>
                    <tr>
                        <th>Procedure</th>
                        <th>Date</th>
                        <th>Time Started</th>
                        <th>Time Ended</th>
                        <th>Prescriptions</th>
                        <th>Diagnosis</th>
                        <th>Notes</th>
                        <th style="width:20%"></th>
                    </tr>
                </thead>
                <tbody>
                      <c:forEach items="${records}" var="item" >
                        <tr>
                            <td>                    
                                <select id="procedureId" name="procedureId" disabled>
                                    <c:forEach items="${procedures}" var="procedures" >
                                        <c:choose>
                                            <c:when test="${item.getVisitationRecord().getProcedureId() == procedures.getProcedureId()}" >
                                                <option value="${procedures.getProcedureId()}" selected>${procedures.getProcedureName()}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value=${procedures.getProcedureId()}>${procedures.getProcedureName()}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><input id="date" type="date" value ="${item.getVisitationRecord().getDate()}" disabled></td> 
                            <td><input id="timestarted" type="time" value = "${item.getVisitationRecord().getTimeStartedUI()}" disabled></td>
                            <td><input id="timeended" type="time" value = "${item.getVisitationRecord().getTimeEndedUI()}" disabled></td>
                            <td><input id="precriptions" type="text" value = "${item.getVisitationRecord().getPrescriptions()}" disabled></td>
                            <td><input id="Diagnosis" type="text" value = "${item.getVisitationRecord().getDiagnosis()}" disabled></td>
                            <td><input id="notes" type="text" value = "${item.getVisitationRecord().getNotes()}" disabled></td>
                            <input id="originalrecordid" type="hidden" value = "${item.getVisitationRecord().getOriginalRecordId()}" disabled >
                            <input id="recordId" type="hidden" type="number" value = "${item.getVisitationRecord().getRecordId()}" disabled >
                            <input id="recordType" type="hidden" type="number" value="0" disabled >
                            <td>
                                <button title="Edit" value="EditRecord" name="EditRecord" onclick="enableRowPatientRecord(this); 
                                    return false;" style="margin-right:15%; margin-left:15%" class="pure-button">
                                    <i class="fa fa-pencil"></i>
                                </button>
                            </td>
                        </tr>
                        </c:forEach>
                </tbody>
            </table>
                <button type="button" title="AddRecord" value="AddRecord" name="AddRecord" onClick="addRowPatientRecord(this); return false;" 
                    class="button-success pure-button" style="float:right">
            <i class="fa fa-plus"></i>
            </button>
        </form>
        <form class="pure-form" name ="patientRecordForm" action="Doctor" method="post">
            <fieldset>
                <input type="hidden" id="selectedProcedureId" name="selectedProcedureId" type="number">
                <input type="hidden" id="selectedDate" name="selectedDate" type="date">
                <input type="hidden" id="selectedTimeStarted" name="selectedTimeStarted" type="time">
                <input type="hidden" id="selectedTimeEnded" name="selectedTimeEnded" type="time">
                <input type="hidden" id="selectedPrecriptions" name="selectedPrecriptions" type="text">
                <input type="hidden" id="selectedDiagnosis" name="selectedDiagnosis" type="text">
                <input type="hidden" id="selectedNotes" name="selectedNotes" type="text">
                <input type="hidden" id="selectedOriginalRecordId" name="selectedOriginalRecordId" type="number">
                <input type="hidden" id="selectedRecordId" name="selectedRecordId" type="number">
                <input type="hidden" id="selectedRecordType" name="selectedRecordType" type="number">
                
            </fieldset>
            <button type="hidden" id="submitRecords" name="PatientRecord" class="pure-button pure-button-primary" hidden>Submit</button>
        </form>
    </div>
</div>
