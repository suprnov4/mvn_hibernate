package com.humanbooster.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.dao.CategorieDao;

@SuppressWarnings("unchecked")
public class CategorieDaoImpl implements CategorieDao{

	private Session session;
	private Transaction transaction;
	
	
	public List<Categorie> findAll(){
		return session.createQuery("from Categorie").getResultList();
	}
	
	public Categorie createCategorie(Categorie categorie) {
		return (Categorie) session.save(categorie);
	}
	
	public Categorie findByName (String nom) {
		return (Categorie) session.createQuery("from Categorie where nom = :nom")
				.setParameter("nom",  nom)
				.getSingleResult();
	}
	
	public Categorie findById (int idCategorie) {
		return (Categorie) session.createQuery("from Categorie where idCategorie = :idCategorie")
				.setParameter("idCategorie",  idCategorie)
				.getSingleResult();
	}
	
	public void updateCategorie(Categorie categorie) {
		session.update(categorie);
	}
	
	public void deleteCategorie (int idCategorie) {
		session.createQuery("Delete from Categorie where idCategorie = :idCategorie")
				.setParameter("idCategorie", idCategorie)
				.executeUpdate();
	}
	
	public void deleteAll() {
		session.createQuery("truncate table Categorie")
				.executeUpdate();
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
