package com.humanbooster.hibernate.service.impl;

import java.util.List;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.dao.ArticleDao;
import com.humanbooster.hibernate.dao.impl.ArticleDaoImpl;
import com.humanbooster.hibernate.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao = new ArticleDaoImpl();
	
	public List<Article> recupereArticles() {
		articleDao.openCurrentSession();
		List<Article> articles = articleDao.findAll();
		System.out.println("Nombre d'articles en base: " + articles.size());
		articleDao.closeCurrentSession();
		return articles;
	}

}
