package com.humanbooster.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.dao.ArticleDao;

@SuppressWarnings("unchecked")
public class ArticleDaoImpl implements ArticleDao {

	private Session session;
	private Transaction transaction;

	public List<Article> findAll() {
		return session.createQuery("from Article").getResultList();
	}
	
	public Article createArticle (Article article) {
		session.save(article);
		return article;
	}
	
	
	public Article findByDesignation (String designation) {
		return (Article) session.createQuery("from Article where designation = :designation")
				.setParameter("designation",  designation)
				.getSingleResult();
	}
	
	public Article findById (int idArticle) {
		return (Article) session.createQuery("from Article where idArticle = :idArticle")
				.setParameter("idArticle",  idArticle)
				.getSingleResult();
	}
	
	public void updateArticle (Article article) {
		session.update(article);
	}
	
	public void deleteArticle (int idArticle) {
		session.createQuery("Delete from Article where idArticle = :idArticle")
				.setParameter("idArticle", idArticle)
				.executeUpdate();
	}
	
	public void deleteAll() {
		session.createQuery("truncate table Article").executeUpdate();
	}
	
	public List<Article> searchByDesignation (String designation) {
		return session.createQuery("from Article where designation = :designation")
				.setParameter("designation", designation.toLowerCase())
				.getResultList();
	}
	
	public List<Article> findByCategorie (Categorie categorie) {
		return session.createQuery("from Article where categorie = :categorie")
				.setParameter("categorie", categorie)
				.getResultList();
	}
	
	
	public List<Article> findAllOrderedByName() {
		return session.createQuery("from Article order by article.designation").getResultList();
	}
	
	public void findPage() {
		//TODO
	}
	
	
	
	public Session openCurrentSession() {
		session = getSessionFactory().openSession();
		return session;

	}

	public Session openCurrentSessionWithTransaction() {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionWithTransaction() {
		transaction.commit();
		session.close();

	}

	private SessionFactory getSessionFactory() {

		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

		return sessionFactory;

	}

}
