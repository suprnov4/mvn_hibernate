package com.humanbooster.hibernate.service.impl;

import java.util.List;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.dao.ArticleDao;
import com.humanbooster.hibernate.dao.impl.ArticleDaoImpl;
import com.humanbooster.hibernate.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao = new ArticleDaoImpl();
	
	public List<Article> recupererArticles() {
		articleDao.openCurrentSession();
		List<Article> articles = articleDao.findAll();
		System.out.println("Nombre d'articles en base : " + articles.size());
		articleDao.closeCurrentSession();
		return articles;
	}
	
	public Article creerArticle(Article article) {
		articleDao.openCurrentSessionWithTransaction();
		Article articleCreated = articleDao.createArticle(article);
		System.out.println("Création de l'article : " + article);
		articleDao.closeCurrentSessionWithTransaction();
		return articleCreated;
	}

	
	public Article trouverArticleParDesignation(String designation) {
		articleDao.openCurrentSession();
		Article article = articleDao.findByDesignation(designation);
		System.out.println("Recherche par désignation : " + designation);
		articleDao.closeCurrentSession();
		return article;
	}


	public Article trouverArticleParId(int idArticle) {
		articleDao.openCurrentSession();
		Article article = articleDao.findById(idArticle);
		System.out.println("Recherche par id d'article : " + idArticle);
		articleDao.closeCurrentSession();
		return article;
	}
	
	
	public void majArticle(Article article) {
		articleDao.openCurrentSessionWithTransaction();
		articleDao.updateArticle(article);
		System.out.println("Mise à jour de l'article : " + article);
		articleDao.closeCurrentSessionWithTransaction();
	}
	
	public void suppressionArticle(int idArticle) {
		articleDao.openCurrentSessionWithTransaction();
		articleDao.deleteArticle(idArticle);
		System.out.println("Suppression de l'article : " + idArticle);
		articleDao.closeCurrentSessionWithTransaction();
	}
	
	public void suppressionTousLesArticles() {
		articleDao.openCurrentSessionWithTransaction();
		articleDao.deleteAll();
		System.out.println("Suppression de tous les articles");
		articleDao.closeCurrentSessionWithTransaction();
	}
	
	public List<Article> rechercherArticlesParDesignation(String designation) {
		articleDao.openCurrentSession();
		List<Article> articles = articleDao.searchByDesignation(designation);
		System.out.println("Recherche par désignation : " + designation);
		articleDao.closeCurrentSession();
		return articles;
	}
	
	public List<Article> trouverArticlesParCategorie(Categorie categorie) {
		articleDao.openCurrentSession();
		List<Article> articles = articleDao.findByCategorie(categorie);
		System.out.println("Recherche par catégorie : " + categorie);
		articleDao.closeCurrentSession();
		return articles;
	}
	
	public List<Article> recupererArticlesOrdonnerParNom() {
		articleDao.openCurrentSession();
		List<Article> articles = articleDao.findAllOrderedByName();
		System.out.println("Nombre d'articles en base : " + articles.size());
		articleDao.closeCurrentSession();
		return articles;
	}
	
	public void trouverPage() {
		//TODO
		articleDao.openCurrentSession();
		articleDao.findPage();
		articleDao.closeCurrentSession();
	}
}
