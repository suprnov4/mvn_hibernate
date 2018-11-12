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
 * Servlet implementation class ArticleCreationServlet
 */
@WebServlet("/ArticleCreationServlet")
public class ArticleCreationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CategorieService categorieService = new CategorieServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleCreationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categorie> categories = categorieService.recupererCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("articleCreation.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String designation = request.getParameter("designation");
		Categorie categorie = null;
		if (!request.getParameter("idCategorie").isEmpty()) {
			categorie = categorieService.trouverCategorieParId(Integer.valueOf(request.getParameter("idCategorie")));}
		int nbPoints = Integer.valueOf(request.getParameter("nbPoints"));
		int stock = Integer.valueOf(request.getParameter("stock"));
		Article article = new Article(designation, categorie, nbPoints, stock);
		articleService.creerArticle(article);
		
		response.sendRedirect(request.getContextPath()+"/articlesList");
	}

}
