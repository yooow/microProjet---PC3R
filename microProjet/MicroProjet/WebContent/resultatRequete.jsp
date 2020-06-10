<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'une requete météo</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<div>
    		<fieldset>
    		<legend> Résultat de la recherche</legend>
	        <p class="info">${ message }</p>
	        <p>Résultat de la requête</p>
	        <p>Ville : ${ demande.ville }</p>
	        <br>
	        <p>Temps : ${ demande.temps }</p>
	        <p>Température (en celsius): ${ demande.temperature }</p>
	        
	        </fieldset>
        </div>
    </body>
</html>