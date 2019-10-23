/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author vashigo
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.AirportsFinder"})
public class AirportsFinderAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirportsFinderAPIApplication.class, args);
    }
}
