<%@include file="/WEB-INF/jspf/SideBars/financialSideBar.jspf" %>

<div id="main">
    <div class="header">
        <h1>Monitor Doctor</h1>
        <h2>Check how many patients a doctor has seen in given time period</h2>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form" >
            <fieldset>
                <legend>Select Doctor</legend>

                <!--<input id="docID" type="email" placeholder="doc@gmail.com" >-->
                <select name = "doctorId" id="doctor" class="pure-input-1-2 doctorDropdown">                            
                    <c:forEach items="${doctors}" var="doctor">
                        <option value=${doctor.getDoctorId()}>${doctor.getFirstName()} ${doctor.getLastName()} (${doctor.getDoctorId()})</option>
                    </c:forEach>
                </select>

                <div style="margin-top:5% !important">
                    <label for="start">Start Date: </label>
                    <input id="start" name ="startDate" type="date">

                    <label style="margin-left:5%" for="end">End Date: </label>
                    <input id="end" name="endDate" type="date">

                    <input class="pure-button pure-button-primary" style="margin-left:5%" type="submit" name="SearchRecords" value="Search"></input>
                </div>
            </fieldset>
        </form>
    </div>

    <div>
        <c:set var="inputDisplay" value='<%= request.getAttribute("invalid")%>' />
        <c:set var="count" value='<%= request.getAttribute("patientCount")%>' />
        <c:choose>
            <c:when test="${count != 0}">
               <div id="startend" align="center" style="margin:0 auto;width:50%; margin-top:5%"> 
                   <%= request.getAttribute("patientCount")%> patient(s) was seen by <%= request.getAttribute("doctorUserId")%>   between <%= request.getAttribute("startDate")%> and <%= request.getAttribute("endDate")%>
                </div>
            </c:when>
            <c:when test="${inputDisplay == 1}">
                <div id="startend" align="center" style="margin:0 auto;width:50%; margin-top:5%">
                    Invalid date selection
                </div>
            </c:when>     
        </c:choose>
        
        

        <c:forEach items="${requestScope.searchRecords}" var="entry" >
            <table style="margin-left:4%" class="pure-table pure-table-bordered" id="record">
                <caption>Patient Id: ${entry.key} (Seen by doctor ${entry.value.size()} times)</caption>
                <thead>
                    <tr>                       
                        <th>Procedure Name</th>
                        <th>Procedure Cost</th>                   
                        <th>Time Started</th>
                        <th>Time Ended</th>
                        <th>Prescriptions Prescribed</th>
                        <th>Diagnosis</th>
                        <th>Treatment Schedule</th>
                        <th>Notes</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${entry.value}" varStatus="loop">
                        <tr>
                            <td>${item.getProcedureName()}</td>
                            <td>$${item.getProcedureCost()}.00</td>
                            <td>${item.getTimeStarted()}</td>
                            <td>${item.getTimeEnded()}</td>
                            <td>${item.getPrescriptions()}</td>
                            <td>${item.getDiagnosis()}</td>
                            <td>${item.getTreatmentSchedule()}</td>
                            <td>${item.getNotes()}</td>        
                        </tr>
                </c:forEach><br>
                </tbody>
            </table>
        </c:forEach>



    </div>
</div>