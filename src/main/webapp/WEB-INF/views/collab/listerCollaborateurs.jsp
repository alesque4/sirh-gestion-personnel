<%@page import="java.util.List, dev.sgp.entite.Collaborateur, dev.sgp.util.Constantes"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	<ul>
		<%
			List<Collaborateur> listeCollab = Constantes.COLLAB_SERVICE.listerCollaborateurs();
			for (Collaborateur collab : listeCollab) {
		%>
		<li><%=collab.toString()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>