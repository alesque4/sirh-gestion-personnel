<%@page import="java.util.List"%>
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
	<h1>Nouveau Collaborateur</h1>
	
	<form action="" method="POST" id="formNouveauCollab">
		<table>
			<tr>
				<td>Nom</td>	<td><input type="text" name="nom"/></td>
			</tr>
			<tr>
				<td>Prenom</td>	<td><input type="text" name="prenom"/></td>
			</tr>
			<tr>
				<td>Date de naissance</td>	<td><input type="date" name="dateNaissance"/></td>
			</tr>
			<tr>
				<td>Adresse</td>	<td><input type="text" name="adresse" /></td>
			</tr>
			<tr>
				<td>N° de sécurité sociale (15 chiffres)</td>	<td><input type="text" name="numSecu" pattern="[0-9]{15}"/></td>
			</tr>
		</table>
		<input type="submit" value="Enregistrer"/>
	</form>
	<%
		if(request.getAttribute("erreur") != null){
	%>
		<p style="color:red;"><%=request.getAttribute("erreur") %></p>
	<%
		}
	%>
</body>
</html>