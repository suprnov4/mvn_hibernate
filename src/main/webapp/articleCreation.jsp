<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/style.css" />
<title>Détail d'un article</title>
</head>
<body>

	<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	<br/>
	<br/>
	<a href="<c:url value="/articlesList"/>">Retour à la liste d'articles</a>

	
		<p>Création du nouvel article :</p>
		
		<form method="post" action="articleCreation">
		
		<label for="designation">Nom de l'article :</label>
		<input type="text" name="designation" /><br>
		
		Catégorie :
		<select name="idCategorie">
		<option value="">Aucune</option>
		<c:forEach items="${categories}" var="categorie">
		<option value="${categorie.idCategorie}"><c:out value="${categorie.nom}" /></option>
		</c:forEach></select><br/>
			
		<label for="nbPoints">Nombre de points :</label> 
		<input type="number" name="nbPoints" /><br>
		
		<label for="stock">Quantité en stock :</label> 
		<input type="number" name="stock" /><br>
		
		<br /> <input type="submit" value="Créer !" />
	</form>

	<br />

</body>
</html>
