package com.humanbooster.hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.service.ArticleService;
import com.humanbooster.hibernate.service.impl.ArticleServiceImpl;


/**
 * Servlet implementation class ArticlesServlet
 */
public class ArticlesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleService articleService = new ArticleServiceImpl();
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticlesListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recupere toutes les enquetes et les envoies a la JSP
		List<Article> articles = articleService.recupererArticles();
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("articlesList.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
