<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	List<String> carrello= (List<String>) request.getSession().getAttribute("carrello");
    if(carrello != null && carrello.size() > 0){
    	for(String art : carrello){
        	out.println(art + "<br>");
    	}
    	
    }else{
    	out.println("Non ci sono articoli nel carrello");
    }
%>

</body>
</html>