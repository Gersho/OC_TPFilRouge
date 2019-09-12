package kpz.gersho.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpz.gersho.beans.Client;

public class CreateClient extends HttpServlet {

	public static final String PARAM_nomClient = "nomClient";
	public static final String PARAM_prenomClient = "prenomClient";
	public static final String PARAM_adresseClient = "adresseClient";
	public static final String PARAM_emailClient = "emailClient";
	public static final String PARAM_telephoneClient = "telephoneClient";
	public static final String ATT_client = "client";
	public static final String ATT_incompleteForm = "incompleteForm";
	public static final String URL_confirmClient = "/WEB-INF/confirmClient.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean incompleteForm = false;
		if (request.getParameter(PARAM_nomClient).isEmpty() || request.getParameter(PARAM_adresseClient).isEmpty()
				|| request.getParameter(PARAM_telephoneClient).isEmpty()) {
			incompleteForm = true;
		}

		Client client = new Client();
		client.setNom(request.getParameter(PARAM_nomClient));
		client.setPrenom(request.getParameter(PARAM_prenomClient));
		client.setAdresse(request.getParameter(PARAM_adresseClient));
		client.setEmail(request.getParameter(PARAM_emailClient));
		client.setTelephone(request.getParameter(PARAM_telephoneClient));

		request.setAttribute(ATT_client, client);
		request.setAttribute(ATT_incompleteForm, incompleteForm);

		this.getServletContext().getRequestDispatcher(URL_confirmClient).forward(request, response);
	}
}
