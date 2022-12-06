<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css"> </link>
</head>
<body>
	<center>
		<h1>Etudiant Management</h1>
		<h2>
			<a href="/GestionEtudiantWeb?action=new">Add New Etudiant</a>
			&nbsp;&nbsp;&nbsp; <a href="/GestionEtudiantWeb">List of
				Etudiants</a>

		</h2>
	</center>
	<div align="center">
		<table class="table table-dark" border="1" cellpadding="5">
			<caption>
				<h2>List of Etudiants</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>CNE</th>
				<th>Adresse</th>
				<th>Niveau</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="etudiant" items="${listEtudiant}">
				<tr>
					<td><c:out value="${etudiant.id_etudiant}" /></td>
					<td><c:out value="${etudiant.nom}" /></td>
					<td><c:out value="${etudiant.prenom}" /></td>
					<td><c:out value="${etudiant.cne}" /></td>
					<td><c:out value="${etudiant.adresse}" /></td>
					<td><c:out value="${etudiant.niveau}" /></td>
					<td><a
						href="/GestionEtudiantWeb?action=edit&id=<c:out value='${etudiant.id_etudiant}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/GestionEtudiantWeb?action=delete&id=<c:out value='${etudiant.id_etudiant}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>