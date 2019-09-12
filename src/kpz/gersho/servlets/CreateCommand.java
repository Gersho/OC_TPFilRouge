package kpz.gersho.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import kpz.gersho.beans.Client;
import kpz.gersho.beans.Command;

public class CreateCommand extends HttpServlet {

	public static final String PARAM_nomClient = "nomClient";
	public static final String PARAM_prenomClient = "prenomClient";
	public static final String PARAM_adresseClient = "adresseClient";
	public static final String PARAM_emailClient = "emailClient";
	public static final String PARAM_telephoneClient = "telephoneClient";
	public static final String PARAM_modePaiementCommande = "modePaiementCommande";
	public static final String PARAM_modeLivraisonCommande = "modeLivraisonCommande";
	public static final String PARAM_montantCommande = "montantCommande";
	public static final String PARAM_statutPaiementCommande = "statutPaiementCommande";
	public static final String PARAM_statutLivraisonCommande = "statutLivraisonCommande";
	public static final String ATT_commande = "commande";
	public static final String ATT_incompleteForm = "incompleteForm";
	public static final String URL_confirmCommand = "/WEB-INF/confirmCommand.jsp";
	public static final String DATE_format = "dd-MM-yyyy";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Double montant;
		try {
			/* Récupération du montant */
			montant = Double.parseDouble(request.getParameter(PARAM_montantCommande));
		} catch (NumberFormatException e) {

			montant = null;
		}
		Boolean incompleteForm = false;
		if (request.getParameter(PARAM_nomClient).isEmpty() || request.getParameter(PARAM_adresseClient).isEmpty()
				|| request.getParameter(PARAM_telephoneClient).isEmpty() || montant == null
				|| request.getParameter(PARAM_modePaiementCommande).isEmpty()
				|| request.getParameter(PARAM_modeLivraisonCommande).isEmpty()

		) {
			incompleteForm = true;

		}

		Client client = new Client();
		client.setNom(request.getParameter(PARAM_nomClient));
		client.setPrenom(request.getParameter(PARAM_prenomClient));
		client.setAdresse(request.getParameter(PARAM_adresseClient));
		client.setEmail(request.getParameter(PARAM_emailClient));
		client.setTelephone(request.getParameter(PARAM_telephoneClient));

		Command commande = new Command();
		commande.setClient(client);
		DateTime dt = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern(DATE_format);
		String date = fmt.print(dt);
		commande.setDate(date);
		commande.setMontant(montant);
		commande.setModePaiement(request.getParameter(PARAM_modePaiementCommande));
		commande.setStatusPaiement(request.getParameter(PARAM_statutPaiementCommande));
		commande.setModeLivraison(request.getParameter(PARAM_modeLivraisonCommande));
		commande.setStatusLivraison(request.getParameter(PARAM_statutLivraisonCommande));

		request.setAttribute(ATT_commande, commande);
		request.setAttribute(ATT_incompleteForm, incompleteForm);

		this.getServletContext().getRequestDispatcher(URL_confirmCommand).forward(request, response);
	}

}
