<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/style.css" />
<title>Liste des Catégories</title>
</head>
<body>

	<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	<br/>
	<br/>
	<a href="<c:url value="/categorieCreation"/>">Créer une nouvelle catégorie</a>


	<c:if test="${ empty categories }">
		<p>
			<span style="color: red;">Il n'y a aucune catégorie dans la liste.</span>
		</p>
	</c:if>

	<c:if test="${ !empty categories }">
		<p>Liste des catégories :</p>

		<c:forEach items="${categories}" var="categorie" varStatus="loop">
		
			<b><u>Catégorie n°<c:out value="${loop.count}" /> :</u> <c:out value="${categorie.nom}" /></b> 		
			<form method="post" action="categorieDetail">
				<input type="hidden" name="idCategorie" value="${categorie.idCategorie}" />
				<input type="submit" value="Détail de la catégorie" />
			</form>
			<br />

		</c:forEach>
			<p>Nombre total de catégorie(s): ${categories.size()}</p>
	</c:if>
	<br/>

</body>
</html>