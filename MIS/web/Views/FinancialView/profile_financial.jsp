<%@include file="/WEB-INF/jspf/SideBars/financialSideBar.jspf" %>

<div id="main">
    <div class="header">
        <h1>Profile</h1>
    </div>
    <div class="content" style="padding-top:30px">
        <img style="margin-left:40%" src="Images/profilepic.jpg"/>            
                   
        <div style="width:50%; margin: 0 auto; margin-top: 10%">
            <form class="pure-form pure-form-aligned" method="post" action="User">
                <fieldset>
                    <legend>Contact Information</legend>
                    <div class="pure-control-group">
                        <label for="streetNumber">Street Number :</label>
                        <input name = "streetNumber" id="streetNumber" type="text" value=<%= profile.getAddress().getStreetNumber()%> disabled>
                    </div>
                    <div class="pure-control-group">
                        <label for="streetName">Street Name :</label>
                        <input name = "streetName" id="streetName" type="text" value=<%= profile.getAddress().getStreetName()%> disabled>
                    </div>
                    <div class="pure-control-group">
                        <label for="city">City :</label>
                        <input name = "city" id="city" type="text" value=<%= profile.getAddress().getCity()%> disabled>
                    </div>        
                    <div class="pure-control-group">
                        <label for="state">Province :</label>
                        <input name = "state" id="state" type="text" value=<%= profile.getAddress().getProvince()%> disabled>
                    </div>		
                    <div class="pure-control-group">
                        <label for="zip">Postal Code :</label>
                        <input name = "zip" id="zip" type="text" value=<%=profile.getAddress().getPostalCode()%> disabled>
                    </div>        
                    <div class="pure-control-group">
                        <label for="phone">Phone Number :</label>
                        <input name = "phone" id="phone" type="tel" value=<%= profile.getUser().getPhoneNumber()%> disabled>
                    </div>        
                    <div class="pure-control-group">
                        <label for="email">Email Address :</label>
                        <input name = "email" id="email" type="email" value=<%= profile.getUser().getUserId()%> disabled>
                    </div> 
                    <div class="pure-controls">
                        <!--                             <button style="margin-left:5%" type="submit" class="pure-button pure-button-primary">Save</button>-->
                        <input style="margin-left:5%" class="pure-button pure-button-primary" type="submit" name="Edit" value="Save" />
                        <button onClick="enable();
                                     return false" style="margin-left:5%" type="button" class="pure-button pure-button-primary">Edit</button>
                    </div>        
                </fieldset>
            </form>
        </div>
    </div>
</div>
