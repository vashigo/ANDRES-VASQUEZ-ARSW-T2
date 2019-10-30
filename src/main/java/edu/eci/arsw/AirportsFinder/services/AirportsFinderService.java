/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.arsw.AirportsFinder.services;
import org.springframework.stereotype.Service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
/**
 *
 * @author 2101770
 */
public class AirportsFinderService {
    
    //private static final String SITE = "https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=";
    //private static final String ID = "&x-rapidapi-key=429e690e10msh41e3b79539a229cp10c099jsnee88337aa3e2";
    //private static final String HOST = "&x-rapidapi-host=cometari-airportsfinder-v1.p.rapidapi.com";
    //private static final String AGENT = "Mozilla/5.0";
    /**
     * metodo para comunicarse con el appi de airports y sacar los datos.
     * @param city The city to which the airport is going to be consulted.
     * @return The information of the airports.
     * @throws java.io.IOException
     */
    public String getInfo(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                    .url("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text="+city)
                    .get()
                    .addHeader("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "429e690e10msh41e3b79539a229cp10c099jsnee88337aa3e2")
                    .build();
        
        Response res = client.newCall(request).execute();
        if(res.isSuccessful()){
            return res.body().string();
        }else {
            throw new NoSuchElementException("Airport not found");
        }
        //return response;
    }
}
