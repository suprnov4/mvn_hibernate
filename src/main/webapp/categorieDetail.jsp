<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/style.css" />
<title>Détail d'une catégorie</title>
</head>
<body>

	<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	<br/>
	<br/>
	<a href="<c:url value="/categoriesList"/>">Retour à la liste des catégories</a>

	
		<p>Détail de la catégorie <c:out value="${categorie.nom}" /> :</p>
		
		<c:forEach items="${articles}" var="article" varStatus="loop">
			<b><u>Article n°<c:out value="${loop.count}" /> :</u> <c:out value="${article.designation}" /></b><br/>
			<br />
		</c:forEach>



	<br />

</body>
</html>