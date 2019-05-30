package com.young.flightreservation.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.young.flightreservation.entities.Flight;
import com.young.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	FlightRepository flightRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyyy") Date departureDate,
			ModelMap modelMap) {
		
		LOGGER.info("Inside findFlights() From: " + from + "TO: " + to + "Depature Date: " + departureDate);
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		String strDate = dateFormat.format(departureDate);

		List<Flight> flights = flightRepository.findFlights(from, to, strDate);
		modelMap.addAttribute("flights", flights);

		LOGGER.info("Flights Found are: " + flights);
		return "displayFlights";

	}
}
