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

	
		<p>Détail de l'article :</p>
		
			<b><u>Article :</u> <c:out value="${article.designation}" /></b><br/>
			Catégorie : <c:out value="${article.categorie.nom}" /><br/>
			Nombre de points : <c:out value="${article.nbPoints}" /><br/>
			Nombre en stock : <c:out value="${article.stock}" /><br/>

	<br />

</body>
</html>
