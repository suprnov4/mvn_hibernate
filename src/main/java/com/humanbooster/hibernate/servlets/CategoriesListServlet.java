package com.humanbooster.hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.service.CategorieService;
import com.humanbooster.hibernate.service.impl.CategorieServiceImpl;

/**
 * Servlet implementation class CategoriesListServlet
 */
@WebServlet("/CategoriesListServlet")
public class CategoriesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategorieService categorieService = new CategorieServiceImpl();
		
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = categorieService.recupererCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("categoriesList.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
