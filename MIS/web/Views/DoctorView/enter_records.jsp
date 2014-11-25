<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Enter a New Visitation Record</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form pure-form-aligned" method="post" action="AddVisitationRecord">
            <fieldset>
                <div class="pure-control-group">
                    <label for="name">Patient Name</label>
                    <input id="name" type="text" placeholder="Name">
                </div>

                <div class="pure-control-group">
                    <label for="diagnosis">Diagnosis</label>
                    <input name="diagnosis" id="diagnosis" type="text" placeholder="Diagnosis">
                </div>

                <div class="pure-control-group">
                    <label for="prescriptions">Prescription</label>
                    <input name="prescriptions" id="prescriptions" type="text" placeholder="Prescription">
                </div>

                <div class="pure-control-group">
                    <label for="timestarted">Time-Started</label>
                    <input name = "timestarted" id="timestarted" type="time">
                </div>

                <div class="pure-control-group">
                    <label for="timeended">Time-Ended</label>
                    <input name = "timeended" id="timeended" type="time">
                </div>

                <div class="pure-control-group">
                    <label for="comment">Comments</label>
                    <textarea id ="comment" name="comment"></textarea>
                </div>
                
                <div class="pure-control-group">
                    <label for="procedures">Procedures</label>
                    <select id="procedureId" name="procedureId">
                        <c:forEach items="${procedures}" var="item" >
                            <option value=${item.getProcedureId()}>${item.getProcedureName()}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary" name="AddVisitationRecord">Submit</button>
                </div>
            </fieldset>
        </form>

    </div>
</div>
