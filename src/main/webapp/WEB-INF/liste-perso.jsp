<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des personnages</title>
<link rel="stylesheet" href="/css/form-modifier.css" />
</head>
<body>
	<a href="form-perso">Ajouter</a>
<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Age</th>
					<th>Race</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="personnage" items="${ personnages }">
					<tr>
						<td>${ personnage.id }</td>
						<td>${ personnage.name }</td>
						<td>${ personnage.age }</td>
						<td>${ personnage.race }</td>
						<td>
							<a href="modifier-perso?id=<c:out value="${ personnage.id }" />" class="btn btn-warning">Modifier</a>
							<a href="supprimer-perso?id=${ personnage.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


</div>


</body>
</html>