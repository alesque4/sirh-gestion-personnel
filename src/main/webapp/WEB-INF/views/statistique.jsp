<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="dev.sgp.util.Constantes, dev.sgp.service.StatService, dev.sgp.web.StatControlleur"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SGP - Statistiques</title>
	<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>

	<div class="container">
		
		<h1>Statistiques</h1>
	
		<table class="table">
			<tr>
				<th>Chemin</th>	<th>Nombre de visites</th>	<th>Min (ms)</th>	<th>Max (ms)</th>	<th>Moyenne (ms)</th>
			</tr>
			
			<c:forEach items="${Constantes.STAT_SERVICE.getChemins()}" var="chemin">
				<td>${chemin}</td>
				<td>${Constantes.STAT_SERVICE.getNumberOfVisiteByPath(chemin)}</td>
				<td>${Constantes.STAT_SERVICE.getMinVisiteTimeByPath(chemin)}</td>
				<td>${Constantes.STAT_SERVICE.getMaxVisiteTimeByPath(chemin)}</td>
				<td>${Constantes.STAT_SERVICE.getAverageVisiteTimeByPath(chemin)}</td>
			</c:forEach>
			
			<tr>
				<td>/sgp</td>	<td>12</td>	<td>10</td>	<td>300</td>	<td>40</td>
			</tr>
		</table>
	</div>
</body>
</html>