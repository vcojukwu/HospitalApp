<%@include file="/WEB-INF/jspf/SideBars/staffSideBar.jspf" %>

<div id="main">
    <div class="header">
        <h1>Add a New User</h1>
    </div>

    <div class="content" style="padding-top:30px">
        <form class="pure-form pure-form-aligned" method="post" action="../../User">
            <fieldset class="pure-group">
                <legend>User Information</legend>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="user">User Type:</label>
                    <select name = "userType" id="user" style="display:inline-block" type="text" onChange="showForm(this);
                                return false">
                        <option value="0">Staff</option>
                        <option value="1">Patient</option>
                        <option value="2">Doctor</option>
                    </select>
                </div>

                <div class="pure-input-1-2 pure-control-group" id="sinDiv" style="display:none">
                    <label for="sin">SIN :</label>
                    <input name = "sin" id="sin" style="display:inline-block" type="number">
                </div>
                <div class="pure-input-1-2 pure-control-group" id="healthDiv" style="display:none">
                    <label for="healthNum">Health Card # :</label>
                    <input name = "healthNum" id="healthNum" style="display:inline-block" type="number">
                </div>
                <div class="pure-input-1-2 pure-control-group" id="docDiv" style="display:none">
                    <label for="docType">Type of Doctor :</label>
                    <input name = "docType" id="docType" style="display:inline-block" type="text" placeholder="Doctor Type">
                </div>

                <div class="pure-input-1-2 pure-control-group">
                    <label for="fname">First Name :</label>
                    <input name = "fname" id="fname" style="display:inline-block" type="text" placeholder="First Name">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="lname">Last Name :</label>
                    <input name = "lname" id="lname" style="display:inline-block" type="text" placeholder="Last Name">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="gender">Gender :</label>                                
                    <select name = "gender" id="gender" style="display:inline-block" type="text" placeholder="Gender">
                        <option value="0">Male</option>
                        <option value="1">Female</option>
                    </select>
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="dob">Date of Birth :</label>
                    <input name = "dob" id="dob" style="display:inline-block" type="date">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="phone">Phone Number :</label>
                    <input name = "phone" id="phone" style="display:inline-block" type="tel">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="email">Email :</label>
                    <input name = "email" id="email" style="display:inline-block" type="email" placeholder="Email">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="password">Password :</label>
                    <input name = "password" id="password" style="display:inline-block" type="password" placeholder="Enter Password">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="emergencyContactName">Emergency Contact Name :</label>
                    <input name = "emergencyContactName" id="emergencyContactName" style="display:inline-block" type="text" placeholder="Emergency Contact Name">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="emergencyContactNumber">Emergency Contact Phone Number :</label>
                    <input name = "emergencyContactNumber" id="emergencyContactNumber" style="display:inline-block" type="tel" placeholder="Emergency Contact Phone Number">
                </div>

            </fieldset>

            <fieldset class="pure-group">
                <legend>Address</legend>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="street_num">Street Number:</label>
                    <input name = "street_num" id="street_num" style="display:inline-block" type="number">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="street_name">Street Name :</label>
                    <input name = "street_name" id="street_name" style="display:inline-block" type="text" placeholder="Street Name">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="city">City :</label>
                    <input name = "city" id="city" style="display:inline-block" type="text" placeholder="City">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="province">Province :</label>
                    <input name = "province" id="province" style="display:inline-block" type="text" placeholder="Province">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="country">Country :</label>
                    <input name = "country" id="country" style="display:inline-block" type="text" placeholder="Country">
                </div>
                <div class="pure-input-1-2 pure-control-group">
                    <label for="zip">Postal Code :</label>
                    <input name = "zip" id="zip" style="display:inline-block" type="text">
                </div>
            </fieldset>

            <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">Create User</button>
        </form>

    </div>
</div>

