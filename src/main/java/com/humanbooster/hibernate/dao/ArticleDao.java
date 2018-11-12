package com.humanbooster.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;

public interface ArticleDao {

	public List<Article> findAll();

	public Article createArticle (Article article);
	
	public Article findByDesignation (String designation);
	
	public Article findById (int idArticle);
	
	public void updateArticle (Article article);
	
	public void deleteArticle (int idArticle);
	
	public void deleteAll ();
	
	public List<Article> searchByDesignation (String designation);
	
	public List<Article> findByCategorie (Categorie categorie);
	
	public List<Article> findAllOrderedByName();
	
	public void findPage();
	
	

	
	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionWithTransaction();
}
