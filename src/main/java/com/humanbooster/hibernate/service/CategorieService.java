package com.humanbooster.hibernate.service;

import java.util.List;

import com.humanbooster.hibernate.business.Categorie;

public interface CategorieService {
	
	public List<Categorie> recupererCategories();
	
	public Categorie creerCategorie(Categorie categorie);
	
	public Categorie trouverCategorieParNom(String nom);
	
	public Categorie trouverCategorieParId(int idCategorie);
	
	public void majCategorie(Categorie categorie);
	
	public void suppressionCategorie(int idCategorie);
	
	public void suppressionToutesLesCategories();

}
