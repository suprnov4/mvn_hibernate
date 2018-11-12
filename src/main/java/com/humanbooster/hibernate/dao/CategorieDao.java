package com.humanbooster.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.humanbooster.hibernate.business.Categorie;

public interface CategorieDao {

	public List<Categorie> findAll();

	public Categorie createCategorie(Categorie categorie);

	public Categorie findByName(String nom);

	public Categorie findById(int idCategorie);

	public void updateCategorie(Categorie categorie);

	public void deleteCategorie(int idCategorie);

	public void deleteAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionWithTransaction();
}
