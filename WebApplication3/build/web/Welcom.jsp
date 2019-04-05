<%-- 
    Document   : Welcom
    Created on : 5 Apr, 2019, 10:17:08 AM
    Author     : Shourya
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Login.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
        String User=(String)session.getAttribute("username");
        HttpSession ses=request.getSession();    
        
        %>
        <title>JSP Page</title>
    </head>
    <body bgcolor="#E6E6FA">
        <td colspan="2" align="right"><a class="btn btn-primary" href="Cart.jsp" role="button">My Cart</a> </td>
        <h1>Hey welcome to pet store ${username}</h1>

        <%
           
           Connection obj1=new Connection();
           ResultSet rs=obj1.getrs();
           int i=0;
           while(rs.next())
           {
            
            String st1=rs.getString("IC");
            String st2=rs.getString("name");
            String st3=rs.getString("Price");
            String st4=rs.getString("URL");
            System.out.println(st1);
            
%> <img src=<%= st4 %>  width="200" height="200">
<br><h1> <%= st2 %></h1>
<h2> Price : Rs <%= st3 %></h2>
<a class="btn btn-primary" id="<%=st1 %>" onclick="display()" href="Cart1?IC=<%= st1%>" role="button">Buy</a> 

<br>
<br><br><br>
        <%
    
           }  
            %> 
       
       
    </body>
</html>
