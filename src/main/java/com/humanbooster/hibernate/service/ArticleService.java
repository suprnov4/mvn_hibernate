package com.humanbooster.hibernate.service;

import java.util.List;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;

public interface ArticleService {

	public List<Article> recupererArticles();
	
	public Article creerArticle(Article article);
	
	public Article trouverArticleParDesignation(String designation);
	
	public Article trouverArticleParId(int idArticle);
	
	public void majArticle(Article article);
	
	public void suppressionArticle(int idArticle);
	
	public void suppressionTousLesArticles();
	
	public List<Article> rechercherArticlesParDesignation(String designation);
	
	public List<Article> trouverArticlesParCategorie(Categorie categorie);
	
	public List<Article> recupererArticlesOrdonnerParNom();
	
	public void trouverPage();
	
	
}
