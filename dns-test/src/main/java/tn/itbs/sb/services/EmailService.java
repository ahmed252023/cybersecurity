package tn.itbs.sb.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EmailService {


    public static List<String> getEmailAddresses(String domain) {
        List<String> emailAddresses = new ArrayList<String>();
        String url = String.format("https://api.hunter.io/v2/domain-search?domain=%s&api_key=ADD YOUR API FROM HUNTER.IO", domain);
        
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject data = new JSONObject(response.body());
            // Vérifiez si la requête a réussi
            if (response.statusCode() == 200) {
                JSONArray emails = data.getJSONObject("data").getJSONArray("emails");
                for (int i = 0; i < emails.length(); i++) {
                    emailAddresses.add(emails.getJSONObject(i).getString("value"));
                }
            }
        } catch (IOException | InterruptedException | JSONException e) {
            System.err.println("Une erreur s'est produite lors de la requête : " + e.getMessage());
        }

        return emailAddresses;
    } 

}



