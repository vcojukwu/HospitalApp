<%@include file="/WEB-INF/jspf/SideBars/financialSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Monitor Doctor</h1>
        <h2>Check how many patients a doctor has seen in given time period</h2>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form">
            <fieldset>
                <legend>Select Doctor</legend>

                <select name="doc" id="doc" type="text">
                    <option value="0">John</option>
                    <option value="1">Doe</option>
                </select>

                <input style="display:none" id="docID" type="number" placeholder="Doctor ID" >

                <label for="docbyID" style="margin-left:5%">
                    <input id="docbyID" onClick="isChecked()" type="checkbox"> Select Doctor By ID
                </label><br>
                
                <div style="margin-top:5% !important">
                    <label for="start">Start Date: </label>
                    <input id="start" type="date">

                    <label style="margin-left:5%" for="end">End Date: </label>
                    <input id="end" type="date">

                    <button style="margin-left:5%" type="submit" class="pure-button pure-button-primary">Search</button>
                </div>
            </fieldset>
        </form>
    </div>
</div>
