<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation création client</title>
</head>
<body>

<p> ${ incompleteForm ? '<p>Vous n\'avez pas remplis tout les champs, <a href ="/TPFilRouge/creerClient.jsp">Cliquez ici</a> pour recommencer</p>' : '' } </p>

<p>Nom: ${ client.nom  }</p>
<p>Prenom: ${ client.prenom  }</p>
<p>Adresse: ${ client.adresse  }</p>
<p>Telephone: ${ client.telephone  }</p>
<p>Email: ${ client.email  }</p>


</body>
</html>