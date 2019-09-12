<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation création client</title>
</head>
<body>
<jsp:include page="/inc/inc_menu.jsp" />  

	<p>
		<c:choose>
			<c:when test="${ incompleteForm }">
		 Vous n'avez pas remplis tout les champs, <a
					href="<c:url value="/creerClient.jsp" />">Cliquez ici</a> pour recommencer.
		</c:when>
			<c:otherwise>
		Création réussie.<br />
				<p>
					Nom:
					<c:out value="${ client.nom  }"></c:out>
				</p>
				<p>
					Prenom:
					<c:out value="${ client.prenom  }"></c:out>
				</p>
				<p>
					Adresse:
					<c:out value="${ client.adresse  }"></c:out>
				</p>
				<p>
					Telephone:
					<c:out value="${ client.telephone  }"></c:out>
				</p>
				<p>
					Email:
					<c:out value="${ client.email  }"></c:out>
				</p>


			</c:otherwise>
		</c:choose>
	</p>

</body>
</html>