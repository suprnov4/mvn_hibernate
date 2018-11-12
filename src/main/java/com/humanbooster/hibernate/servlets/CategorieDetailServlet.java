package com.humanbooster.hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.service.ArticleService;
import com.humanbooster.hibernate.service.CategorieService;
import com.humanbooster.hibernate.service.impl.ArticleServiceImpl;
import com.humanbooster.hibernate.service.impl.CategorieServiceImpl;

/**
 * Servlet implementation class CategorieDetailServlet
 */
@WebServlet("/CategorieDetailServlet")
public class CategorieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleService articleService = new ArticleServiceImpl();
	private CategorieService categorieService = new CategorieServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategorieDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCategorie = Integer.valueOf(request.getParameter("idCategorie"));
		Categorie categorie = categorieService.trouverCategorieParId(idCategorie);
		List<Article> articles = articleService.trouverArticlesParCategorie(categorie);
		request.setAttribute("categorie", categorie);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("categorieDetail.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
