package kpz.gersho.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpz.gersho.beans.Client;

public class CreateClient extends HttpServlet {

	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		Boolean incompleteForm = false;
		if( request.getParameter("nomClient").isEmpty() ||
			request.getParameter("adresseClient").isEmpty() ||
			request.getParameter("telephoneClient").isEmpty()){
				incompleteForm = true;
		}
		
		Client client = new Client();
		client.setNom(request.getParameter("nomClient"));
		client.setPrenom(request.getParameter("prenomClient"));
		client.setAdresse(request.getParameter("adresseClient"));
		client.setEmail(request.getParameter("emailClient"));
		client.setTelephone(request.getParameter("telephoneClient"));
		
		request.setAttribute("client", client);
		request.setAttribute("incompleteForm", incompleteForm);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/confirmClient.jsp" ).forward( request, response );
	}
}
