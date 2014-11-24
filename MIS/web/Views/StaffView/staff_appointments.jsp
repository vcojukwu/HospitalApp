<%@include file="/WEB-INF/jspf/SideBars/staffSideBar.jspf" %>


<div id="main">
    <div class="header">
        <h1>View Appointements</h1>
    </div>

    <div class="content" style="padding-top:30px; margin:5% !important">
        <table class="pure-table pure-table-bordered" id="appointments">
            <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Patient Name</th>
                    <th>Doctor ID</th>
                    <th>Doctor Name</th>
                    <th>Start Time</th>
                    <th>Duration</th>
                    <th style="width:20%"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input id="patID" type="number" value = "1" disabled></td>
                    <td><input id="patName" type="text" value = "Victor Ojukwu" disabled></td>
                    <td><input id="docID" type="number" value = "1" disabled></td>
                    <td><input id="docName" type="text" value = "John Doe" disabled></td>
                    <td><input id="time" type="datetime" value = "1:00" disabled></td>
                    <td><input id="duration" type="number" value = "60" disabled></td>
                    <td>
                        <button onClick="enableRow();
                                return false" style="margin-right:15px" class="pure-button">
                            <i class="fa fa-pencil"></i>
                        </button>
                        <button onClick="deleteRow2(this);
                                return false" class="pure-button">
                            <i class="fa fa-times-circle"></i>
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
        <button class="button-success pure-button" onClick="addRow2(this);
                return false"><i class="fa fa-plus"></i></button>
    </div>
</div>

