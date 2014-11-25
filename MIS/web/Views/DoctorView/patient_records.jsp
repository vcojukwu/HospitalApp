<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Patient Record</h1>
    </div>

    <div class="content" style="padding-top:30px; margin:5% !important">
        <form class="pure-form" name ="patientRecordForm" action="Doctor" method="post">
            <fieldset>
                <legend>Search for a Patient</legend>

                <input name ="patientId" id="patientId" type="text" class="pure-input-rounded" value="${patientId}" disabled>
                <input name ="lastname" id="lastname" type="text" class="pure-input-rounded" placeholder="Patient Last Name" disabled>
            </fieldset>
        

            <table class="pure-table pure-table-bordered" id="appointments">
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
                                            <c:when test="${item.getProcedureId() == procedures.getProcedureId()}" >
                                                <option value=${procedures.getProcedureId()} selected>${procedures.getProcedureName()}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value=${procedures.getProcedureId()}>${procedures.getProcedureName()}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><input id="date" type="date" value ="${item.getDate()}" disabled></td> 
                            <td><input id="timestarted" type="time" value = ${item.getTimeStartedUI()} disabled></td>
                            <td><input id="timeended" type="time" value = ${item.getTimeEndedUI()} disabled></td>
                            <td><input id="precriptions" type="text" value = ${item.getPrescriptions()} disabled></td>
                            <td><input id="Diagnosis" type="text" value = ${item.getDiagnosis()} disabled></td>
                            <td><input id="notes" type="text" value = ${item.getNotes()} disabled></td>
                            <input id="originalrecordid" type="hidden" value = "${item.getOriginalRecordId()}" disabled >
                            <input id="recordId" type="hidden" type="number" value = "${item.getRecordId()}" disabled >
                            <input id="recordType" type="hidden" type="number" value="0" disabled >
                            <td>
                                <button title="Edit" value="PatientRecord" name="PatientRecord" onclick="enableRowPatientRecord(this); 
                                    return false" style="margin-right:15%; margin-left:15%" class="pure-button">
                                    <i class="fa fa-pencil"></i>
                                </button>
                            </td>
                        </tr>
                        </c:forEach>
                </tbody>
            </table>
        
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
            <button type="hidden" id="submitRecords" name="PatientRecord" class="pure-button pure-button-primary">Submit</button>
        </form>
    </div>
</div>
