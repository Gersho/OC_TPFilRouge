<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/inc/inc_menu.jsp" />  
	<p>
		<c:choose>
			<c:when test="${ incompleteForm }">
		 Vous n'avez pas remplis tout les champs, <a
					href="<c:url value="/creerCommande.jsp" />">Cliquez ici</a> pour recommencer.
		</c:when>
			<c:otherwise>
		Création réussie.<br />

				<p>
					Nom:
					<c:out value="${ commande.client.nom  }"></c:out>
				</p>
				<p>
					Prenom:
					<c:out value="${ commande.client.prenom  }"></c:out>
				</p>
				<p>
					Adresse:
					<c:out value="${ commande.client.adresse  }"></c:out>
				</p>
				<p>
					Telephone:
					<c:out value="${ commande.client.telephone  }"></c:out>
				</p>
				<p>
					Email:
					<c:out value="${ commande.client.email  }"></c:out>
				</p>
				<p>
					Date:
					<c:out value="${ commande.date  }"></c:out>
				</p>
				<p>
					Montant:
					<c:out value="${ commande.montant  }"></c:out>
				</p>
				<p>
					Mode de paiement:
					<c:out value="${ commande.modePaiement  }"></c:out>
				</p>
				<p>
					Status du paiement:
					<c:out value="${ commande.statusPaiement  }"></c:out>
				</p>
				<p>
					Mode de Livraison:
					<c:out value="${ commande.modeLivraison  }"></c:out>
				</p>
				<p>
					Status de la Livraison:
					<c:out value="${ commande.statusLivraison  }"></c:out>
				</p>

			</c:otherwise>
		</c:choose>
	</p>

</body>
</html>