<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Profile</title>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<link rel="stylesheet" type="text/css" href="../CSS/test.css">
<script src="../JS/test.js"></script>

</head>

<body>

<div>   <a href="#" style="position:absolute; top:0"><img src="../Images/uwhlogo.jpg" alt="Insert Logo Here" width="120" height="90" id="Insert_logo"/></a>
<p style="text-align:right;"><span style="font-family:Verdana;font-size:18px;font-style:italic;font-weight:bold;text-decoration:none;text-transform:uppercase;color:#2F2D2D;"><span style="color:#E5EB13">University</span> of <span style="color:#E5EB13">Waterloo</span> Hospital <br><span style="padding-right:10% ;font-size:22px">(UWH)</span>
</span>
</p>
</div>

<div class="content" style="margin-top:10%">
<form class="pure-form pure-form-stacked" method="post" action="Login">
    <fieldset>
        <legend>Login</legend>

        <label for="email">Email</label>
        <input id="email" name="userId" type="email" placeholder="Email">

        <label for="password">Password</label>
        <input id="password" name="pwd" type="password" placeholder="Password">

        <label for="remember" class="pure-checkbox">
            <input id="remember" type="checkbox"> Remember me
        </label>

        <button type="submit" class="pure-button pure-button-primary">Sign in</button>
    </fieldset>
</form>
    <a href="Views/PatientView/profile.html">Go To Patient View</a>
</div>
</body>

</html>