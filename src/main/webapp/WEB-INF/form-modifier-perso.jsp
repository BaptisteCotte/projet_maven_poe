<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Character</title>
</head>
<body>
	<form method="POST">

		<div class="md-form">
			<label>Name</label> <input type="text" name="name"
				value="${ personnage.name }" pattern="[A-Z]+[\-]{0,1}([a-z]{1,}[\-]{0,1}){0,}[a-z]$" required/>
				<p>Le nom du personnage doit commencer par une minuscule. Il peut contenir des '-' mais ne pas contenir de chiffres, ni d'espaces.</p>
		</div>

		<div>
			<label>Age</label> <input type="text" name="age"
				value="${ personnage.age }" pattern="^[\d]{0,}$" required/>
				<p>L'age du personnage ne peut-etre negatif.</p>
		</div>
		<div>
			<input type="submit" value="Edit" />
		</div>
	</form>
</body>
</html>