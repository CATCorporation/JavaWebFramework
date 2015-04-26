<%@page import="java.nio.file.Path"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apache</title>
</head>
<body>
	<%
		out.println(request.getAttribute("welcomeMessage"));
		ArrayList<Path> listFolder = (ArrayList<Path>) request.getAttribute("listFolder");
		ArrayList<Path> listFile = (ArrayList<Path>) request.getAttribute("listFile");

	%>
	<br><br>
	<h2>Dossier : </h2>
	<br>
	<a href="./explorer?folder=<%= request.getAttribute("parent") %>"><% out.println(request.getAttribute("parent")); %></a>
	<br>
	
	<%
		for(Path p : listFolder){ %> 
			<a href="./explorer?folder=<%= p.toString() %>"><% out.println(p); %></a>
			<br>
			<%
		}
	%>
	
	<br><br>
	<h2>Fichier : </h2>
	<br>
	<%
		for(Path p : listFile){ %> 
			<a href="./file?folder=<%= p.toString() %>" download><% out.println(p); %></a>
			<br>
			<%
		}
	%>
</body>
</html>