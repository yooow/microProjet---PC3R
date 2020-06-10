
package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import beans.Demande;



public class CreationDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        //récupération des données
		String temps;
		float temperature;
        String ville = request.getParameter( "ville" );
        
        //clé d'api dans le code (peut être dangereux)
        String key = "ed1e6b36d8a1ce15e47ea72cc4791b2c";
        String chemin = "http://api.openweathermap.org/data/2.5/weather?q="+ville+"&appid="+key+"&lang=fr";
        String message = chemin;
        
        //conversion de la string en objet URL
        URL url = new URL(chemin);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        //définition d'une limite de temps de connexion (optionnel)
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        
        // vérification que la requete à l'api est valable (ville existante, clé existante)
        int status = connection.getResponseCode();
		if(status != 200)
			message = "ville non trouvée, reformulez votre demande en cliquant <a href=\"creerRequete.jsp\"> ici</a>";
		else{
			message = "requete valide, voici la météo : ";
		}
		
		// utilisation d'un bufferReader pour lire le fichier JSON renvoyé par l'API
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		in.close();
		
		// utilisation d'objets JSONObject pour la récupération des données
		JSONObject parse = new JSONObject(content.toString());
		JSONArray tabTemps = parse.getJSONArray("weather");
		JSONObject tabTemperature = parse.getJSONObject("main");
		
		// on récupère ici les données qui nous intéressent, la description du temps qu'il fait et la température ressentie
		temps = tabTemps.getJSONObject(0).getString("description");
		temperature = (float)tabTemperature.getDouble("feels_like");
		//conversion du kelvin au celsius
		temperature = (float) (temperature - 273.15);
        
		//ajout des données au bean
        Demande demande = new Demande();
        demande.setTemps( temps );
        demande.setTemperature( temperature );
        demande.setVille( ville );

        // ajout du bean et du message à la requete sortante
        request.setAttribute("demande", demande);
        request.setAttribute("message", message);

        // renvoi de la requete et du message au fichier resultatRequete.jsp qui s'occupera de l'affichage
        this.getServletContext().getRequestDispatcher("/resultatRequete.jsp").forward(request, response);
    }
    
    
}