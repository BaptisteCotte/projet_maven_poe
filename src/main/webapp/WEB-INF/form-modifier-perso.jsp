<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Character</title>
<link href="./assets/css/styleForm.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="leftbox"></div>

		<div class="rightbox">
			<form method="POST">
				<div class="profile">
					<h1>Edit Character</h1>
					</br> <label>Name</label> </br> <input type="text" name="name"
						value="${ personnage.name }"
						pattern="^[A-Z]+[\-]{0,1}([a-z]{1,}[\-]{0,1}){0,}[a-z]$" required />

					<p>Le nom du personnage doit commencer par une minuscule. Il
						peut contenir des '-' mais ne pas contenir de chiffres, ni
						d'espaces.</p>


					<div>
						</br> </br> <label>Age</label> </br> <input type="text" name="age"
							value="${ personnage.age }" pattern="^[\d]{0,}$" required />
						<p>L'age du personnage ne peut-etre negatif.</p>
					</div>

					<div>

						</br> </br>



						<button class="btn" type="submit" value="Edit">Submit</button>
					</div>




				</div>
			</form>
		</div>
	</div>
</body>
</html>