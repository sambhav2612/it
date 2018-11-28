<%-- 
    Document   : index
    Created on : 25 Nov, 2018, 8:54:49 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="test" uri="/WEB-INF/tlds/newtag_library.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="cartoon"
class="com.abc.NewSessionBean" />
        
        <jsp:useBean id="clock"
class="java.util.Date" />
        
        <jsp:setProperty name="cartoon" property="fileName"
value="New File name" />
        <h1><test:hello name="anmol" /></h1>
        <h1><jsp:getProperty name="cartoon"
                         property="fileName" /></h1>
        
        
<c:choose>
<c:when test="${clock.hours < 12}">
<h1>Good morning!</h1>
</c:when>
<c:when test="${clock.hours < 18}">
<h1>Good day!</h1>
</c:when>
<c:otherwise>
<h1>Good evening!</h1>
</c:otherwise>
</c:choose>
    </body>
</html>
