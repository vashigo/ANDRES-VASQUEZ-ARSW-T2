/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.arsw.AirportsFinder.services;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.NoSuchElementException;

@Service
/**
 *
 * @author 2101770
 */
public class AirportsFinderService {
    
    private static final String SITE = "https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=";
    private static final String ID = "&x-rapidapi-key=429e690e10msh41e3b79539a229cp10c099jsnee88337aa3e2";
    private static final String HOST = "&x-rapidapi-host=cometari-airportsfinder-v1.p.rapidapi.com";
    private static final String AGENT = "Mozilla/5.0";
    /**
     * metodo para comunicarse con el appi de airports y sacar los datos.
     * @param city The city to which the climate is going to be consulted.
     * @return The information of the airports.
     */
    public String getInfo(String city) throws IOException {

        URL obj = new URL(SITE+city+HOST+ID);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { 
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
            throw new NoSuchElementException("City not found");
        }

    }
    
}
