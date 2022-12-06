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
		<h1>Students crud</h1>
		<h2>
			<a href="/GestionEtudiantWeb?action=new">Add student</a>
			&nbsp;&nbsp;&nbsp; <a href="/GestionEtudiantWeb">List of
				students</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${etudiant != null}">
			<form action="/GestionEtudiantWeb?action=update" method="post">
		</c:if>
		<c:if test="${etudiant == null}">
			<form action="/GestionEtudiantWeb?action=add" method="post">
		</c:if>
		<table class="form-group " border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${etudiant != null}">
					Edit student
				</c:if>
					<c:if test="${etudiant == null}">
					Add student
				</c:if>
				</h2>
			</caption>
			<c:if test="${etudiant != null}">
				<input type="hidden" name="id_etudiant"
					value="<c:out value='${etudiant.id_etudiant}' />" />
			</c:if>
			<tr>
				<th scope="col">Nom:</th>
				<td><input class="form-control"  type="text" name="nom" size="45"
					value="<c:out value='${etudiant.nom}' />" /></td>
			</tr>
			<tr>
				<th scope="col">Prenom:</th>
				<td><input class="form-control" type="text" name="prenom" size="45"
					value="<c:out value='${etudiant.prenom}' />" /></td>
			</tr>
			<tr>
				<th scope="col">CNE:</th>
				<td><input class="form-control" type="text" step="0.01" name="cne" size="45"
					value="<c:out value='${etudiant.cne}' />" /></td>
			</tr>
			<tr>
				<th scope="col">Adresse:</th>
				<td><input class="form-control" type="text" name="adresse" size="45"
					value="<c:out value='${etudiant.adresse}' />" /></td>
			</tr>
			<tr>
				<th scope="col">Niveau:</th>
				<td><input class="form-control" type="text" name="niveau" size="45"
					value="<c:out value='${etudiant.niveau}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input class="btn btn-primary" type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>