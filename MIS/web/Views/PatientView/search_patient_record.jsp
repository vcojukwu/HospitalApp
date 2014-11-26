<%@include file="/WEB-INF/jspf/SideBars/patientSideBar.jspf" %>

<div id="main">
    <div class="header">
        <h1>Search Record</h1>
    </div>

    <div class="content" style="padding-top:30px">
            <form class="pure-form" method="post" action="Views/PatientView/SearchRecords">
                <fieldset>
                    <legend>Search for a Record</legend>

                    <div style="margin-bottom:5px">
                        <select id="procedureId" name="procedureId">
                            <option value="0" selected>Search All Procedures</option> 
                            <c:forEach items="${procedures}" var="item" >
                                <option value=${item.getProcedureId()}>${item.getProcedureName()}</option>
                            </c:forEach>
                        </select>

                        <input id="prescriptions" type="text" name="prescriptions" class="pure-input-rounded" placeholder="Prescriptions">
                        <input id="diagnosis" type="text" name="diagnosis" class="pure-input-rounded" placeholder="Diagnosis">
                        <input id="treatmentschedule" type="text" name="treatmentschedule" class="pure-input-rounded" placeholder="Treatment Schedule">
                         <input id="recorddate" type="date" name="recorddate" class="pure-input-rounded" placeholder="Recard Date">
                    </div>


                    <button type="submit" class="pure-button pure-button-primary" name="SearchRecords">Search</button>
                </fieldset>
        </div>
         <form class="pure-form" method="post" action="Views/PatientView/SearchRecords">
            <div style="margin-left:5%">
                <table class="pure-table pure-table-bordered" id="appointments">
                    <thead>
                        <tr>
                    <thead>
                        <tr>
                            <th>Doctor Id</th>
                            <th>Procedure</th>
                            <th>Date</th>
                            <th>Time Started</th>
                            <th>Time Ended</th>
                            <th>Prescriptions</th>
                            <th>Diagnosis</th>
                            <th>Treatment Schedule</th>
                        </tr>
                    </thead>
                        </tr>
                    </thead>
                    <tbody>
                          <c:forEach items="${records}" var="item" >
                            <tr>
                                <td><input id="tpatientid" type="text" value = "${item.getVisitationRecord().getDoctorId()}" disabled></td>
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
                                <td><input id="tdate" type="date" value ="${item.getVisitationRecord().getDate()}" disabled></td> 
                                <td><input id="ttimestarted" type="time" value = "${item.getVisitationRecord().getTimeStartedUI()}" disabled></td>
                                <td><input id="ttimeended" type="time" value = "${item.getVisitationRecord().getTimeEndedUI()}" disabled></td>
                                <td><input id="tprecriptions" type="text" value = "${item.getVisitationRecord().getPrescriptions()}" disabled></td>
                                <td><input id="tDiagnosis" type="text" value = "${item.getVisitationRecord().getDiagnosis()}" disabled></td>
                                <td><input id="ttreatmentschedule" type="text" value = "${item.getVisitationRecord().getTreatmentSchedule()}" disabled></td>
                            </tr>
                            </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
