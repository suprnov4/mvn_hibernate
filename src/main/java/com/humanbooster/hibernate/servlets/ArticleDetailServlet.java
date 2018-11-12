package com.humanbooster.hibernate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.service.ArticleService;
import com.humanbooster.hibernate.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class articleDetailServlet
 */
@WebServlet("/articleDetailServlet")
public class ArticleDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService as = new ArticleServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idArticle = Integer.valueOf(request.getParameter("idArticle"));
		Article article = as.trouverArticleParId(idArticle);
				
		request.setAttribute("article", article);
		request.getRequestDispatcher("articleDetail.jsp").include(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
