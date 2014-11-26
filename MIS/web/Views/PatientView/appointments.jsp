<%@include file="/WEB-INF/jspf/SideBars/patientSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Past Appointments</h1>
    </div>

    <div class="content" style="margin-top:5%">
        <table class="pure-table pure-table-bordered" id="appointments">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Time</th>                        
                        <th>Doctor Id</th>
                        <th>Duration</th>
                    </tr>                    
                </thead>
                <tbody>
                <c:forEach items="${PastAppointments}" var="appointment">                        
                    <tr>
                        <td><input name="date" type="date" value = ${appointment.getDate()} disabled></td>
                        <td><input name="time" type="time" value = ${appointment.getTimeScheduledUI()} disabled></td>
                        <td><input name="time" type="text" value = ${appointment.getDoctorId()} disabled></td>
                        <td><input name="duration" type="number" value="${appointment.getDurationScheduled()}"  disabled></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
</div>


