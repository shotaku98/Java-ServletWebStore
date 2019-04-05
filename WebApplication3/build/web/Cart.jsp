<%-- 
    Document   : Cart
    Created on : 5 Apr, 2019, 11:11:45 AM
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
        <td colspan="2" align="right"><a class="btn btn-primary" href="Welcom.jsp" role="button">Shop</a> </td>
        <td colspan="2" align="right"><a class="btn btn-primary" href="dump" role="button">Clear Cart</a> </td>
        <h1>This is your cart ${username} </h1>
        
        <%
           
           Connection obj1=new Connection();
           ResultSet rs=obj1.getrscart(User);
           int i=0;
           while(rs.next())
           {
            
            String st1=rs.getString("IC");
            String st2=rs.getString("name");
            String st3=rs.getString("Price");
            String st4=rs.getString("URL");
            System.out.println(st1);
            
%> <img src=<%= st4 %>  width="200" height="200">
<h1> <%= st2 %></h1>
<h2> <%= st3 %></h2>
 
        <%
    
           }  
            %>
           
            <td colspan="2" align="right"><a class="btn btn-primary" href="Checkout" role="button">Checkout</a> </td>
       
    </body>
</html>
