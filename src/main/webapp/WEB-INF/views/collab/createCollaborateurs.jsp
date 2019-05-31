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
	
	<form action="" method="get" id="formNouveauCollab">
		<table>
			<tr>
				<td>Nom</td>	<td><input type="text" id="nom" required/></td>
			</tr>
			<tr>
				<td>Prenom</td>	<td><input type="text" id="prenom" required/></td>
			</tr>
			<tr>
				<td>Date de naissance</td>	<td><input type="date" id="dateNaissance" required/></td>
			</tr>
			<tr>
				<td>Adresse</td>	<td><input type="text" id="adresse" required/></td>
			</tr>
			<tr>
				<td>N° de sécurité sociale</td>	<td><input type="text" id="numSecu" required/></td>
			</tr>
		</table>
		<input type="submit" value="Enregistrer"/>
	</form>
</body>
</html>