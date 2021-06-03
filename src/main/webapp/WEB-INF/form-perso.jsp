<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personnage</title>
<link href="./assets/css/styleForm.css" rel="stylesheet" type="text/css">
</head>


	<!-- Tab content -->
	<div id="ajouter" class="container">
		<div class="leftbox"></div>

		<div class="rightbox">
			<form method="POST">
				<div class="profile">
					<h1>Add Character</h1>
					<div>
						<label>Name</label> <input type="text" name="name"
							pattern="^[A-Z]+[\-]{0,1}([a-z]{1,}[\-]{0,1}){0,}[a-z]$" required />
						<p>Doit commencer par une majuscule, finir par une minuscule
							et peut contenir <br>des "-".</p>
					</div>

					<div>
						<label>Age</label> <input type="text" name="age"
							pattern="^[\d]{0,}$" required />
						<p>Nombres positifs uniquement.</p>
					</div>

					<div>
						<br>
						<label>Race</label>
						<div>
							<label for="HUMAN" class="l-radio"> <input type="radio"
								id="HUMAN" name="race" value="HUMAN" checked> <span>Human</span>
							</label> <label for="DWARF" class="l-radio"> <input type="radio"
								id="DWARF" class="l-radio" name="race" value="DWARF"> <span>Dwarf</span>
							</label> <label for="ELF" class="l-radio"> <input type="radio"
								id="ELF" class="l-radio" name="race" value="ELF"> <span>Elf</span>
							</label> <label for="ORC" class="l-radio"> <input type="radio"
								id="ORC" class="l-radio" name="race" value="ORC"> <span>Orc</span>
							</label>
						</div>

					</div>

					<div>
						<br>
						<label>Class</label>
						<div>
							<label for="knight" class="l-radio"> <input type="radio"
								id="knight" name="classe" value="knight" checked><span>
									Knight</span></label> <label for="sorcerer" class="l-radio"> <input
								type="radio" id="sorcerer" name="classe" value="sorcerer">
								<span>Sorcerer</span></label> <label for="priest" class="l-radio">
								<input type="radio" id="priest" name="classe" value="priest">
								<span>Priest</span>
							</label>
						</div>

					</div>
					<div>
						<br><br> <button class="btn" type="submit" value="Edit">Submit</button>
					</div>
			</form>
		</div>
</body>
</html>