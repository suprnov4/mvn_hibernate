package com.humanbooster.hibernate.service.impl;

import java.util.List;

import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.dao.CategorieDao;
import com.humanbooster.hibernate.dao.impl.CategorieDaoImpl;
import com.humanbooster.hibernate.service.CategorieService;

public class CategorieServiceImpl implements CategorieService {

	private CategorieDao categorieDao = new CategorieDaoImpl();
	
	public List<Categorie> recupererCategories() {
		categorieDao.openCurrentSession();
		List<Categorie> categories = categorieDao.findAll();
		System.out.println("Nombre de catégories en base : " + categories.size());
		categorieDao.closeCurrentSession();
		return categories;
	}
	
	public Categorie creerCategorie(Categorie categorie) {
		categorieDao.openCurrentSessionWithTransaction();
		Categorie categorieCreated = categorieDao.createCategorie(categorie);
		System.out.println("Création de la catégorie : " + categorie);
		categorieDao.closeCurrentSessionWithTransaction();
		return categorieCreated;
	}
	
	public Categorie trouverCategorieParNom(String nom) {
		categorieDao.openCurrentSession();
		Categorie categorie = categorieDao.findByName(nom);
		System.out.println("Recherche par nom : " + nom);
		categorieDao.closeCurrentSession();
		return categorie;
	}
	
	public Categorie trouverCategorieParId(int idCategorie) {
		categorieDao.openCurrentSession();
		Categorie categorie = categorieDao.findById(idCategorie);
		System.out.println("Recherche par idCategorie : " + idCategorie);
		categorieDao.closeCurrentSession();
		return categorie;
	}
	
	public void majCategorie(Categorie categorie) {
		categorieDao.openCurrentSessionWithTransaction();
		categorieDao.updateCategorie(categorie);
		System.out.println("Mise à jour de la catégorie : " + categorie);
		categorieDao.closeCurrentSessionWithTransaction();
	}
	
	public void suppressionCategorie(int idCategorie) {
		categorieDao.openCurrentSessionWithTransaction();
		categorieDao.deleteCategorie(idCategorie);
		System.out.println("Suppression de l'article : " + idCategorie);
		categorieDao.closeCurrentSessionWithTransaction();
	}
	
	public void suppressionToutesLesCategories() {
		categorieDao.openCurrentSessionWithTransaction();
		categorieDao.deleteAll();
		System.out.println("Suppression de toutes les catégories");
		categorieDao.closeCurrentSessionWithTransaction();
	}
}
