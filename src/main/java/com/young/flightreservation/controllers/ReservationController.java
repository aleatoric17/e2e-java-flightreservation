package com.young.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.young.flightreservation.entities.Flight;
import com.young.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		//instructor used
		//Flight flight = flightRepository.findById(flightId);
		//instead
		Optional<Flight> flight = flightRepository.findById(flightId);
		modelMap.addAttribute("flight", flight);
		return "compelteReservation";
	}
}
