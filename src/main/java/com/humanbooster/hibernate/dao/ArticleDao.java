package com.humanbooster.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.humanbooster.hibernate.business.Article;

public interface ArticleDao {

	public List<Article> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionWithTransaction();
}
