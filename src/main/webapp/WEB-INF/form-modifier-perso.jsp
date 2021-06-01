<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Character</title>
</head>
<body>
	<form method="POST">

		<div>
			<label>Name</label> <input type="text" name="name"
				value="${ personnage.name }" />
		</div>

		<div>
			<label>Age</label> <input type="number" name="age"
				value="${ personnage.age }" />
		</div>
		<div>
			<input type="submit" value="Edit" />
		</div>
	</form>
</body>
</html>