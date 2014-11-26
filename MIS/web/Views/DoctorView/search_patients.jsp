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
                    <select id="current">
                        <option value="0">Active Patients</option>
                        <option value="1">All Patients</option>
                    </select>

                    <input id="email" type="email" class="pure-input-rounded" placeholder="patient@email.com">
                </div>

                <input  type="hidden" name="firstname" id="firstname" class="pure-input-rounded" placeholder="First Name">
                <input  type="hidden" name="lastname" id="lastname" class="pure-input-rounded" placeholder="Last Name">

                <label id="adv2" for="date" style="display:none">Last Visit :</label>
                <input id="adv3" type="hidden">

                <button type="submit" class="pure-button pure-button-primary" name="SearchPatients">Search</button>
                <button type="button" id="advSearch" onClick="showAdv1();
                        return false" class="pure-button pure-button-primary">Advanced Search</button>
            </fieldset>



        </form>
    </div>
    <div style="margin-left:15%">
        <table class="pure-table pure-table-bordered" id="appointments">
            <thead>
                <tr>
                    <th>Patient Email</th>
                    <th>Patient Name</th>
                    <th>Doctor Name</th>
                    <th>Last Visit</th>
                    <th>Active</th>
                    <th><span style="visibility:hidden">EditandDeleteButtons</span></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${patients}" var="item" >
                    <tr>
                        <td><input id="patID" type="text" value = ${item.getPatient().getPatientId()} disabled></td>
                        <td><input id="patName" type="text" value = "${item.getUser().getFirstName()} ${item.getUser().getLastName()}" disabled></td>
                        <td><input id="docName" type="text" value = "John Doe" disabled></td>
                        <td><input id="lastVisit" type="date" value = "" disabled></td>
                        <td align="center"><input id="isActive" type="checkbox" value = "1" disabled></td>
                        <td align="center">
                            
                            <button class="pure-button" value =${item.getPatient().getPatientId()} name="ViewPatientDetail" onClick="">
                                View Record
                            </button>
                            <!--<button onClick="deleteRow2(this);
                                    return false" class="pure-button">
                                <i class="fa fa-times-circle"></i>
                            </button> -->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
