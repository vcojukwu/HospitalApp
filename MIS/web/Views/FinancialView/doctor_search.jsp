<%@include file="/WEB-INF/jspf/SideBars/financialSideBar.jspf" %>
<script>
    function search(){
       var doctorId = $("#doctor").val();
       var startDate = $("#start").val();
       var endDate = $("#end").val();
        $.get('/MIS/Financial/PatientSearch', {userId: doctorId, startDate : startDate, endDate : endDate }, function(data) {
            //$('#results').html(data).hide().slideDown('slow');
            var test = data;
        } );
    }

</script>
<div id="main">
    <div class="header">
        <h1>Monitor Doctor</h1>
        <h2>Check how many patients a doctor has seen in given time period</h2>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form">
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
                    <input id="start" type="date">

                    <label style="margin-left:5%" for="end">End Date: </label>
                    <input id="end" type="date">

                    <button class="pure-button pure-button-primary" style="margin-left:5%" type="submit" onclick="search()" >Search</button>
                </div>
            </fieldset>
        </form>

    </div>
    <div>
        <table style="margin-left:4%" class="pure-table pure-table-bordered" id="record">
            <caption>Patient Name</caption>
            <thead>
                <tr>
                    <th>Record #</th>
                    <th>Procedure</th>
                    <th>Date</th>
                    <th>Time Started</th>
                    <th>Time Ended</th>
                    <th>Prescription</th>
                    <th>Diagnosis</th>
                    <th>Notes</th>
                    <th>Revenue</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td><input class="procedure" type="text" value = "X-Ray" disabled></td>
                    <td><input class="date" type="date" value = "2014-11-11" disabled></td>
                    <td><input class="started" type="time" value = "1:00" disabled></td>
                    <td><input class="ended" type="time" value = "2:00" disabled></td>
                    <td><input class="prescription" type="text" value="Advil" disabled></td>
                    <td><input class="diagnosis" type="number" value = "60" disabled></td>
                    <td><input class="notes" type="text" value = "Notes" disabled></td>
                    <td><input class="revenue" style="width:80px" type="number" value = "60" disabled></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>