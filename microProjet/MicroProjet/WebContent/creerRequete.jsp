<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'une requete météo</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="creationDemande">
                <fieldset>
                    <legend>Informations Recherche</legend>
    
                    <label for="ville">Ville recherchée<span class="requis">*</span></label>
                    <input type="text" id="ville" name="ville" value="" size="20" maxlength="20" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
            </form>
        </div>
    </body>
</html>