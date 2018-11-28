<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <title>Pattern</title>
 </head>
 <body>
 <% int n=Integer.parseInt((request.getParameter("name")));
 int i,j;
 for(i=1;i<=n;i++)
 {for(j=1;j<=i;j++)
 out.print(j);
 out.println("<br>");
 }
 %>
 </body>
</html> 