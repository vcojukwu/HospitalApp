<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Patient Search</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form" method="post" action="Doctor">
            <fieldset>
                <legend>Search for a Patient</legend>

                <div style="margin-bottom:5px">
                    <select name="current" id="current">
                        <option value="1" selected>Active Patients</option>
                        <option value="0">All Patients</option>
                    </select>

                    <input id="email" type="email" name="email" class="pure-input-rounded" placeholder="patient@email.com">
                </div>

                <input  type="hidden" name="firstname" id="firstname" class="pure-input-rounded" placeholder="First Name">
                <input  type="hidden" name="lastname" id="lastname" class="pure-input-rounded" placeholder="Last Name">

                <label id="adv2" for="date" style="display:none">Last Visit :</label>
                <input id="adv3" name="lastvisit" type="hidden">

                <button type="submit" class="pure-button pure-button-primary" name="SearchPatients">Search</button>
                <button type="button" id="advSearch" onClick="showAdv1();
                        return false" class="pure-button pure-button-primary">Advanced Search</button>
            </fieldset>
    </div>
     <form class="pure-form" method="post" action="Doctor">
        <div style="margin-left:15%">
            <table class="pure-table pure-table-bordered" id="appointments">
                <thead>
                    <tr>
                        <th>Patient Email</th>
                        <th>Patient Name</th>
                        <th>Doctor Id</th>
                        <th>Last Visit</th>
                        <th>Active</th>
                        <th><span style="visibility:hidden">EditandDeleteButtons</span></th>
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
                            <td align="center">

                                <button type="submit" class="pure-button" value =${item.getPatient().getPatientId()} name="ViewPatientDetail" onClick="">
                                    View Record
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>
