<%@ attribute name="title" fragment="true" %>

<!DOCTYPE html>
<html>
	<head>
		<title><jsp:invoke fragment="title" /></title>
		
		<meta charset="UTF-8" />
		<base href="/projet_maven_poe/" />
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<link rel="stylesheet" href="assets/css/style.css" />
	
	</head>
	
	<body>
		<div class="container">
			<h1>
				<jsp:invoke fragment="title" />
			</h1>
			
			<jsp:doBody />
		</div>
	</body>
</html>