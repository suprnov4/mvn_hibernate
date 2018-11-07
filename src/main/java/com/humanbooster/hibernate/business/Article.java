package com.humanbooster.hibernate.business;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArticle;
	
	@Size(min=5)
	private String designation;
	
	private int nbPoints;
	
	private int stock;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Categorie categorie;
	
	public Article() {
		super();
	}

	public Article(String designation, Categorie categorie, int nbPoints, int stock) {
		setDesignation(designation);
		setCategorie(categorie);
		setNbPoints(nbPoints);
		setStock(stock);
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", designation=" + designation + ", nbPoints=" + nbPoints
				+ ", stock=" + stock + ", categorie=" + categorie + "]";
	}	
	
}
