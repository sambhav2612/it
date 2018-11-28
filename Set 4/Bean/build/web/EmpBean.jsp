<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Bean</title>
</head>
<body>
<jsp:useBean id = "employee" class = "prac.EmployeeBean"> 
         <jsp:setProperty name = "employee" property = "id" value = "101"/>
         <jsp:setProperty name = "employee" property = "name" value = "xyz"/>
      </jsp:useBean>

      <p>Employee id: 
         <jsp:getProperty name = "employee" property = "id"/>
      </p>
      
      <p>Employee name:
         <jsp:getProperty name = "employee" property = "name"/>
      </p>
      
</body>
</html>