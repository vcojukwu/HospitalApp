<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>

<div id="main">
    <div class="header">
        <h1>Assign Patients to Doctors</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form pure-form-stacked" method ="post" action="Views/DoctorView/GrantPermission">
            <fieldset>
                <div class="pure-g" id="dynamic_content">
                    <input name="function" type="hidden" value="GrantDoctorPermission">
                    <div class="pure-u-1 pure-u-md-1-3" style="width:50% !important">
                        <label for="doctor">Select Doctor</label>
                        <select name = "doctorId" id="doctor" class="pure-input-1-2 doctorDropdown">                            
                            <c:forEach items="${doctors}" var="doctor">
                                <option value=${doctor}>${doctor}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="pure-u-1 pure-u-md-1-3" style="width:50% !important">
                        <label for="patient">Patient</label>
                        <select name = "patientId" id="patient" class="pure-input-1-2 patientDropdown">                            
                            <c:forEach items="${patients}" var="patient">
                                <option value=${patient}>${patient}</option>
                            </c:forEach>
                        </select>
                    </div>                    
                </div>
				<input type="text" name="patientIDs" id="patientIDs" style="display:none">
                <button type="submit" name="AddPermission" id="AddPermission" class="pure-button pure-button-primary">Make Assignment</button>
 
            <div style="margin-left:15%; margin-top:5%">
                <table class="pure-table pure-table-bordered" id="appointments">
                    <thead>
                        <tr>
                            <th>Patient Id</th>
                            <th>Doctor Id</th>
                            <th><span style="visibility:hidden">EditandDeleteButtons</span></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${permission}" var="item" >
                            <tr>
                                <td><input id="patID" type="text" value = "${item.getPatientId()}" disabled></td>
                                <td><input id="docId" type="text" value = "${item.getDoctorId()}" disabled></td>              
                                <td align="center">
                                    <button type="submit" class="pure-button" value ="" name="DeleteRecords" onClick="deletePermission(this)">
                                        Delete Permission
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <fieldset>
                    <input type="hidden" id="selectedpatid" name="selectedpatid" type="text">
                    <input type="hidden" id="selecteddocid" name="selecteddocid" type="text">
                </fieldset>
            </div>
            </fieldset>
        </form>
    </div>

</div>
