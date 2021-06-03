<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/css/table.css" />
<title>Liste des personnages</title>

</head>
<body>

<div class="teamTitle">
<h1>TEAM</h1>
</div>

<hr class="mainHr">

<div class="addChar">
<c:if test="${ fn:length(personnages) < 3 }"><a href="form-perso" class="pricing-button is-featured">New character</a></c:if> 

</div>
	<div class="background">
		<div class="container">
			<div class="panel pricing-table">

				<c:forEach var="personnage" items="${ personnages }">

					<div class="pricing-plan">
						<img src="https://www.pngkey.com/png/detail/6-61715_knight-drawing-helmet-iron-man-armour-knight-drawing.png" alt=""
							class="pricing-img">
						<h2 class="pricing-header">${ personnage.name }</h2>
						<ul class="pricing-features">
						<li class="pricing-features-item">ID : ${ personnage.id }</li>
							<li class="pricing-features-item">Age : ${ personnage.age }</li>
							<li class="pricing-features-item">Race : ${ personnage.race }</li>
							<li class="pricing-features-item">Level : ${ personnage.lvl }</li>
							<li class="pricing-features-item">XP : ${ personnage.xp }</li>
							<li class="pricing-features-item">Current HP : ${ personnage.hp }</li>
							<li class="pricing-features-item">Max HP : ${ personnage.maxHp }</li>
							<li class="pricing-features-item">Base Damage : ${ personnage.baseDmg }</li>
							<li class="pricing-features-item">State : ${ personnage.state }</li>
						</ul>
						<span class="pricing-price"></span> 
	<a href="modifier-perso?id=<c:out value="${ personnage.id }" />" class="pricing-button is-featured">Edit</a>
		<a href="supprimer-perso?id=${ personnage.id }" class="pricing-button is-featured">Delete</a>
					</div>

				</c:forEach>



			</div>
		</div>
	</div>

				


<!-- 	<div class="tbl-header"> -->
		<%-- <table cellpadding="0" cellspacing="0" border="0">

			<caption>
				<c:if test="${param.persoAjout == true }">
					<div class="alertAjout">
						<span class="closebtn"
							onclick="this.parentElement.style.display='none';">&times;</span>
						Le personnage a été ajouté !
					</div>
				</c:if>

				<c:if test="${param.persoModifie == true }">
					<div class="alertModifie">
						<span class="closebtn"
							onclick="this.parentElement.style.display='none';">&times;</span>
						Le personnage a été modifié !
					</div>
				</c:if>
			</caption>

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
						<td><a
							href="modifier-perso?id=<c:out value="${ personnage.id }" />"
							class="btn btn-warning">Modifier</a> <a
							href="supprimer-perso?id=${ personnage.id }"
							class="btn btn-danger">Supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table> --%>

		<!-- <a href="form-perso">Ajouter</a> -->

<!-- 	</div> -->





</body>
</html>