<%@page import="java.util.List, dev.sgp.entite.Collaborateur, dev.sgp.util.Constantes, dev.sgp.entite.Departement"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	<form action="" method="POST" id="filterCollab">
		<p>Rechercher un nom ou un prenom qui commence par : <input type="text" name="filterName"/></p>
		<p>Filter par département : 
			<select name="filterDepartement">
				<option value="all">Tous</option>
				<%
					List<Departement> listDepartement = Constantes.DEPARTEMENT_SERVICE.getListDepartement();
					for(Departement dep : listDepartement){
				%>
						<option value="<%=dep.getNom()%>"><%=dep.getNom()%></option>
				<%
					}
				%>
			</select>
		</p>
		<p> Afficher les collaborateurs désactivés <input type="checkbox" name="afficheCollabDesactive"/></p>
		<input type="submit" value="Rechercher"/>
	
	</form>
		<div style="display:flex; flex-direction:row; line-wrap:wrap;" class="container">
		<%
			List<Collaborateur> listeCollab = Constantes.COLLAB_SERVICE.listerCollaborateurs();
			for (Collaborateur collab : listeCollab) {
		%>
			<div style="border:1px solid black; width:300px;">
				<div style="display:block; padding:5px; border-bottom: 1px solid grey">
					<p><%=collab.getNom()+" "+collab.getPrenom() %></p>
				</div>
				<div style="padding:10px;">
					<img src="<%=collab.getPhoto() %>" alt="photo" style="float:left; width:50px; margin:5px;"/>
					<p>Fonction : <%=collab.getIntitulePoste() %></p>
					<p>Département : <%=collab.getDepartement() %></p>
					<p>Email : <%=collab.getEmailPro() %></p>
					<p>Téléphone : 06 xx xx xx xx</p>
				</div>
			</div>
			
		<%
			}
		%>
		</div>
		
		
</body>
</html>