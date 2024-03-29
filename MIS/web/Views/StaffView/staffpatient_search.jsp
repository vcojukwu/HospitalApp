<%@include file="/WEB-INF/jspf/SideBars/staffSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Patient Search</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form" method="post" action="Views/StaffView/SearchPatients">
            <fieldset>
                <legend>Search for a Patient</legend>

                <div style="margin-bottom:5px">
                    <input id="email" type="email" name="email" class="pure-input-rounded" placeholder="patient@email.com">
                    <input id="doctoremail" type="email" name="doctoremail" class="pure-input-rounded" placeholder="doctor@email.com">
                    <input name="firstname" id="firstname" class="pure-input-rounded" placeholder="First Name">
                    <input name="lastname" id="lastname" class="pure-input-rounded" placeholder="Last Name">
                    <label id="adv2" for="date" style="display:none">Last Visit :</label>
                    <input id="adv3" name="lastvisit" type="date">
                </div>
                
                <button type="submit" class="pure-button pure-button-primary" name="SearchPatients">Search</button>
            </fieldset>
    </div>
     <form class="pure-form" method="post" action="Views/StaffViewSearchPatients">
        <div style="margin-left:15%">
            <input type="hidden" name="function" value="SearchPatients"/>
            <table class="pure-table pure-table-bordered" id="appointments">
                <thead>
                    <tr>
                        <th>Patient Email</th>
                        <th>Patient Name</th>
                        <th>Doctor Id</th>
                        <th>Last Visit</th>
                        <th>Active</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${patients}" var="item" >
                        <tr>
                            <td><input id="patID" type="text" value = "${item.getPatient().getPatientId()}" disabled></td>
                            <td><input id="patName" type="text" value = "${item.getUser().getFirstName()} ${item.getUser().getLastName()}" disabled></td>
                            <td><input id="docName" type="text" value = "${item.getPatient().getDoctorId()}" disabled></td>
                            <td><input id="lastVisit" type="date" value = "${item.getPatient().getLastVisitDateUI()}" disabled></td>                
                            <td align="center">
                                <c:choose>
                                    <c:when test="${item.getPatient().isIsActive()==true}">
                                         <input id="isActive" type="checkbox" checked disabled>
                                    </c:when>
                                    <c:otherwise>
                                        <input id="isActive" type="checkbox"  disabled>
                                    </c:otherwise>
                                </c:choose>
                            
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>
