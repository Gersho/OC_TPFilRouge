<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p> ${ incompleteForm ? '<p>Vous n\'avez pas remplis tout les champs, <a href ="/TPFilRouge/creerCommande.jsp">Cliquez ici</a> pour recommencer</p>' : '' } </p>

<p>Nom: ${ commande.client.nom  }</p>
<p>Prenom: ${ commande.client.prenom  }</p>
<p>Adresse: ${ commande.client.adresse  }</p>
<p>Telephone: ${ commande.client.telephone  }</p>
<p>Email: ${ commande.client.email  }</p>
<p>Date: ${ commande.date  }</p>
<p>Montant: ${ commande.montant  }</p>
<p>Mode de paiement: ${ commande.modePaiement  }</p>
<p>Status du paiement: ${ commande.statusPaiement  }</p>
<p>Mode de Livraison: ${ commande.modeLivraison  }</p>
<p>Status de la Livraison: ${ commande.statusLivraison  }</p>


</body>
</html>