<%@include file="/WEB-INF/jspf/SideBars/financialSideBar.jspf" %>

<div id="main">
    <div class="header">
        <h1>Monthly Revenue</h1>
        <h2>Generate Bill For The Provincial Health Insurance</h2>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form">
            <fieldset>
                <legend>Time Period</legend>

                <label for="start">Start Date: </label>
                <input id="start" type="date">

                <label style="margin-left:5%" for="end">End Date: </label>
                <input id="end" type="date">

                <button style="margin-left:5%" type="submit" class="pure-button pure-button-primary">Search</button>
            </fieldset>
        </form>

        <table style="margin-top:10%" id="bill">
            <tr>
                <td align="right">Cost Per Visit :</td>
                <td align="right">Value 1</td>
            </tr>
            <tr>
                <td align="right">Number Of Visits :</td>
                <td align="right">Value 2</td>
            </tr>
            <tr>
                <td align="right">Revenue From Procedures :</td>
                <td align="right" width="70%">Value 3</td>
            </tr>
            <tr s>
                <td align="right" style="border-top:thin solid black">Total Revenue :</td>
                <td align="right" style="border-top:thin solid black">Value 4</td>
            </tr>
        </table>
    </div>
</div>
