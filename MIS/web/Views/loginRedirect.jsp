<%-- 
    Document   : loginRedirect
    Created on : 23-Nov-2014, 2:50:49 PM
    Author     : TheKey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=profile.getUser().getUserType() %>
        <h1>Hello World!</h1>
        
        <c:choose>
            <c:when test = "${profile.getUser().getUserType() == 1}" >
                <jsp:forward page="/Views/PatientView/profile.jsp" />
            </c:when>
        </c:choose>
    </body>
</html>
