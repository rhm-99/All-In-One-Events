<%-- 
    Document   : ticketmasterevents
    Created on : 14 May 2020, 15:57:55
    Author     : rhiya
--%>

<%@page import="org.json.allinoneeventsfinal.TicketMasterInterface"%>
<%@page import="org.json.allinoneeventsfinal.Event"%>
<%@page import="org.json.allinoneeventsfinal.TicketMaster"%>
<%@page import="org.json.allinoneeventsfinal.RedirectServlet"%>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TicketMaster Events</title>
    </head>
    <body>
        <h1 style="text-align:center;"><img src="images/logo.png" alt="logo" height="40" width="40"/>All In One Events</h1>
    <table>
        <tbody>
        <td height = "auto" width = "1000px" bgcolor="#1c9e75" style="text-align:center;"><a href="index.html"> Home</a></td>
        <td height = "auto" width = "1000px" bgcolor="#1c9e75" style="text-align:center;"><a href="ticketmasterevents.jsp">TicketMaster events</a></td>
        <td height = "auto" width ="1000px" bgcolor="#1c9e75" style="text-align:center;"><a href="contactus.html">Contact Us</a></td>
    </tbody>
</table>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <h2>TicketMaster Events</h2>
    <%
        //try{
        TicketMaster ticketMaster = new TicketMaster();
        out.println(ticketMaster);
        
        //for (Event event : ticketMaster.findAllEvents()) {
        //   out.println("<li>" + event + "</>");
        //}
        //List<Event> object = ticketMaster.findAllEvents();
        //for(int i = 0; i < object.size(); i++){
        //    out.println(object);
        
        //}
        //}
        //catch(Exception e){
        //    System.out.println("error");
        //}
    %>
    </body>
    <footer>
        <marquee style=" position: absolute; left: 0; width: 100%; text-align: center;">
        Twitter, Instagram - @allinoneevents. Look for our Facebook by searching All In One Events. 
        For any inquiries, please e-mail us at info@allinoneevents.com</marquee>
    </footer>
</html>