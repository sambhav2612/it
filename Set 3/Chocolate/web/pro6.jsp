<%-- 
    Document   : pro6
    Created on : Nov 19, 2018, 7:51:21 PM
    Author     : Anjani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="custom" uri="/WEB-INF/tlds/Custom.tld" %>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>JSP Page</title>
 </head>
 <body>
 <custom:hello name="${param.name}"/><br><br>
 <custom1:choco texture="${param.choc}"/>

 </body>
</html> 
 