<%@include file="/WEB-INF/jspf/SideBars/staffSideBar.jspf" %>


<div id="main">
    <div class="header">
        <h1>Appointments</h1>
        <h2>View, Add, Delete and Reschedule Appointments</h2>
    </div>

    <div class="content" style="padding-top:30px; margin:5% !important; max-width:none !important">
        <table class="pure-table pure-table-bordered" id="appointments">
            <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Patient Name</th>
                    <th>Doctor ID</th>
                    <th>Doctor Name</th>
                    <th>Start Time</th>
                    <th>Duration</th>
                    <th><span style="visibility:hidden">EditandDeleteButtons</span></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input class="patID" type="number" value = "1" disabled></td>
                    <td><input class="patName" type="text" value = "Victor Ojukwu" disabled></td>
                    <td><input class="docID" type="number" value = "1" disabled></td>
                    <td><input class="docName" type="text" value = "John Doe" disabled></td>
                    <td><input class="time" type="datetime" value = "1:00" disabled></td>
                    <td><input class="duration" type="number" style="width:100%" value = "60" disabled></td>
                    <td>
                        <button title="Edit" onClick="enableRow(this);
                                return false" style="margin-right:15%; margin-left:15%" class="pure-button">
                            <i class="fa fa-pencil"></i>
                        </button>
                        <button title="Delete Appointment" onClick="deleteRow2(this);
                                return false" class="pure-button">
                            <i class="fa fa-times-circle"></i>
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
        <button title="Add New Appointment" class="button-success pure-button" style="float:right" onClick="addRow2(this);
                return false">
            <i class="fa fa-plus"></i>
        </button>
    </div>
</div>

