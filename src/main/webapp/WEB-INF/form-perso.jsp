<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personnage</title>
</head>

<body>


	<!-- Tab content -->
	<div id="ajouter" class="tabcontent">
		<h3>Add</h3>
		
		<form action="post">
		
			<div>
				<label>Name</label> <input type="text" name="name" />
			</div>
			
			<div>
				<label>Age</label> <input type="number" name="age" />
			</div>
			
			<div>
				<label>Race</label>
				<div>
					<input type="radio" id="HUMAN" name="race" value="HUMAN" checked>
					<label for="HUMAN">Human</label>
				</div>
				<div>
					<input type="radio" id="DWARF" name="race" value="DWARF"> <label
						for="DWARF">Dwarf</label>
				</div>
				<div>
					<input type="radio" id="ELF" name="race" value="ELF"> <label
						for="ELF">Elf</label>
				</div>
				<div>
					<input type="radio" id="ORC" name="race" value="ORC"> <label
						for="ORC">Orc</label>
				</div>

			</div>
			
			<div>
				<label>Class</label>
				<div>
					<input type="radio" id="knight" name="classe" value="knight"
						checked> <label for="knight">Knight</label>
				</div>
				<div>
					<input type="radio" id="sorcerer" name="classe" value="sorcerer">
					<label for="sorcerer">Sorcerer</label>
				</div>
				<div>
					<input type="radio" id="priest" name="classe" value="priest">
					<label for="priest">Priest</label>
				</div>

			</div>
			<div>
				<button type="submit">submit</button>
			</div>
		</form>
	</div>

</body>
</html>