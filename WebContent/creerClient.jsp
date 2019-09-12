<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
    <jsp:include page="/inc/inc_menu.jsp" />  
        <div>
            <form method="get" action="<c:url value="/creationClient"/>">
			<jsp:include page="/inc/inc_client_form.jsp" />
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>