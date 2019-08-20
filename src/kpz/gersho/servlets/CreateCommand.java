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
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
		Double montant;
		try {
            /* Récupération du montant */
            montant = Double.parseDouble( request.getParameter( "montantCommande" ) );
        } catch ( NumberFormatException e ) {

            montant = null;
        }
		Boolean incompleteForm = false;
		if( request.getParameter("nomClient").isEmpty() ||
			request.getParameter("adresseClient").isEmpty() ||
			request.getParameter("telephoneClient").isEmpty() ||
			montant == null ||
			request.getParameter("modePaiementCommande").isEmpty() || 
			request.getParameter("modeLivraisonCommande").isEmpty()
												
				){
			incompleteForm = true;
			
		}
		
		Client client = new Client();
		client.setNom(request.getParameter("nomClient"));
		client.setPrenom(request.getParameter("prenomClient"));
		client.setAdresse(request.getParameter("adresseClient"));
		client.setEmail(request.getParameter("emailClient"));
		client.setTelephone(request.getParameter("telephoneClient"));
		
		Command commande = new Command();
		commande.setClient(client);
		DateTime dt = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy");
		String date = fmt.print(dt);
		commande.setDate(date);
		commande.setMontant(montant);
		commande.setModePaiement(request.getParameter("modePaiementCommande"));
		commande.setStatusPaiement(request.getParameter("statutPaiementCommande"));
		commande.setModeLivraison(request.getParameter("modeLivraisonCommande"));
		commande.setStatusLivraison(request.getParameter("statutLivraisonCommande"));
		
		request.setAttribute("commande", commande);
		request.setAttribute("incompleteForm", incompleteForm);
		
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/confirmCommand.jsp" ).forward( request, response );
	}

}
