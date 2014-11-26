<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Patient Search</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form" method="post" action="Doctor">
            <fieldset>
                <legend>Search for a Record</legend>

                <div style="margin-bottom:5px">
                    <select id="procedureId" name="procedureId">
                        <option value="0" selected>Search All Procedures</option> 
                        <c:forEach items="${procedures}" var="item" >
                            <option value=${item.getProcedureId()}>${item.getProcedureName()}</option>
                        </c:forEach>
                    </select>

                    <input id="email" type="email" name="email" class="pure-input-rounded" placeholder="patient@email.com">
                    <input id="prescriptions" type="text" name="prescriptions" class="pure-input-rounded" placeholder="Prescriptions">
                    <input id="diagnosis" type="text" name="diagnosis" class="pure-input-rounded" placeholder="Diagnosis">
                    <input id="notes" type="text" name="notes" class="pure-input-rounded" placeholder="Notes">
                    <input id="firstname" type="text" name="firstname" class="pure-input-rounded" placeholder="Patient First Name">
                    <input id="lastname" type="text" name="lastname" class="pure-input-rounded" placeholder="lastname">
                     <input id="recorddate" type="date" name="recorddate" class="pure-input-rounded" placeholder="Recard Date">
                </div>

                <input  type="hidden" name="firstname" id="firstname" class="pure-input-rounded" placeholder="First Name">
                <input  type="hidden" name="lastname" id="lastname" class="pure-input-rounded" placeholder="Last Name">

                <label id="adv2" for="date" style="display:none">Last Visit :</label>
                <input id="adv3" name="lastvisit" type="hidden">

                <button type="submit" class="pure-button pure-button-primary" name="SearchRecords">Search</button>
                <button type="button" id="advSearch" onClick="showAdv1();
                        return false" class="pure-button pure-button-primary">Advanced Search</button>
            </fieldset>
    </div>
     <form class="pure-form" method="post" action="Doctor">
        <div style="margin-left:15%">
            <table class="pure-table pure-table-bordered" id="appointments">
                <thead>
                    <tr>
                <thead>
                    <tr>
                        <th>Procedure</th>
                        <th>Date</th>
                        <th>Time Started</th>
                        <th>Time Ended</th>
                        <th>Prescriptions</th>
                        <th>Diagnosis</th>
                        <th>Notes</th>
                    </tr>
                </thead>
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
                            <td><input id="tdate" type="date" value ="${item.getVisitationRecord().getDate()}" disabled></td> 
                            <td><input id="ttimestarted" type="time" value = "${item.getVisitationRecord().getTimeStartedUI()}" disabled></td>
                            <td><input id="ttimeended" type="time" value = "${item.getVisitationRecord().getTimeEndedUI()}" disabled></td>
                            <td><input id="tprecriptions" type="text" value = "${item.getVisitationRecord().getPrescriptions()}" disabled></td>
                            <td><input id="tDiagnosis" type="text" value = "${item.getVisitationRecord().getDiagnosis()}" disabled></td>
                            <td><input id="tnotes" type="text" value = "${item.getVisitationRecord().getNotes()}" disabled></td>
                        </tr>
                        </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>
