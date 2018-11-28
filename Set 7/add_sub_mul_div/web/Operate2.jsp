<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>JSP Page</title>
 </head>
 <body>
 <c:set value="${param.n1}" var="num1"/>
 <c:set value="${param.n2}" var="num2"/>
 <c:set value="${param.op}" var="x"/>
 <c:choose>
 <c:when test="${x==1}">
 <c:out value="${num1+num2}"/> 
 </c:when>
 <c:when test="${x==2}">
 <c:out value="${num1-num2}"/>
 </c:when>
 <c:when test="${x==3}">
 <c:out value="${num1*num2}"/>
 </c:when>
 <c:when test="${x==4}">


 <c:out value="${num1/num2}"/>
 </c:when>

 <c:otherwise>
 <c:out value="Wrong choice"/>
 </c:otherwise>

 </c:choose>
 </body>
</html>
 
 