<%@include file="/WEB-INF/jspf/SideBars/doctorSideBar.jspf" %>
<div id="main">
    <div class="header">
        <h1>Patient Search</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form">
            <fieldset>
                <legend>Search for a Patient</legend>

                <input type="search" class="pure-input-rounded" placeholder="Patient Name">
                <input id="adv1" type="hidden" placeholder="Patient ID">
                <label id="adv2" for="date" style="display:none">Last Visit :</label>
                <input id="adv3" type="hidden">

                <button type="submit" class="pure-button pure-button-primary">Search</button>
                <button type="button" onClick="showAdv1();
                   return false" class="pure-button pure-button-primary">Advanced Search</button>
            </fieldset>
        </form>

        <table class="pure-table" style="margin-top:10%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Last Visit</th>
                    <th>Current Patient</th>
                </tr>
            </thead>
            <tbody>
                <tr class="pure-table-odd">
                    <td>1</td>
                    <td>Test</td>
                    <td>2013</td>
                    <td>Yes</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>Test</td>
                    <td>2014</td>
                    <td>Yes</td>
                </tr>
            </tbody>
        </table>

    </div>
</div>
