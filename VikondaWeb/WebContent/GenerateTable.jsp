<%@page import="vikonda.DeserializeClass"%>
<%@page import="vikonda.OrderList"%>
<%@page import="vikonda.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=cp1251"
    pageEncoding="cp1251"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
OrderList list = DeserializeClass.loadOrders();
ArrayList<Order> arrayOrders = list.getOrdersArrayList();

%>
 <table style="width:15cm; border-color:#254117;" align="center" border="0">
        <tr style="background-color:#38ACEC;font-size:large; font-family:Andalus;">
            <td width="2" align="center"> Çàêàç #</td>
            <td width="4cm" align="center"> Ïðîôèëü</td>
            <td width="2cm" align="center"> Ñóììà</td>
            <td width="4cm" align="center"> Ñîñòîÿíèå çàêàçà</td>
            <td width="4cm" align="center"> Äàòà îòãðóçêè</td>
        </tr>
       <% for(int i = 0; i < arrayOrders.size(); i+=1) { %>
        <tr >
            <td align="center"> <%=arrayOrders.get(i).getNumber() %></td>
            <td align="center"> <%=arrayOrders.get(i).getProfile() %></td>
            <td align="right"> <%=arrayOrders.get(i).getSum() %></td>
            <td align="center"> <%=arrayOrders.get(i).getStatus() %></td>
            <td align="right"> <%=arrayOrders.get(i).getDate() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>