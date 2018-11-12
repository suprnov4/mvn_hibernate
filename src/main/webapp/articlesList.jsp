<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/style.css" />
<title>Liste des articles</title>
</head>
<body>

	<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	<br/>
	<br/>
	<a href="<c:url value="/articleCreation"/>">Créer un nouvel article</a>


	<c:if test="${ empty articles }">
		<p>
			<span style="color: red;">Il n'y a aucun article dans la liste.</span>
		</p>
	</c:if>

	<c:if test="${ !empty articles }">
		<p>Liste des Articles :</p>

		<c:forEach items="${articles}" var="article" varStatus="loop">
		
			<b><u>Article n°<c:out value="${loop.count}" /> :</u> <c:out value="${article.designation}" /></b> (<c:out value="${article.categorie.nom}" />)
		
			<form method="post" action="articleDetail">
				<input type="hidden" name="idArticle" value="${article.idArticle}" />
				<input type="submit" value="Détail de l'article" />
			</form>
			<br />

		</c:forEach>
			<p>Nombre total d'article(s): ${articles.size()}</p>
	</c:if>
	<br />

	<br />



</body>
</html>
