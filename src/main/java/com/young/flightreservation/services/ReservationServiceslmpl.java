package com.young.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.young.flightreservation.dto.ReservationRequest;
import com.young.flightreservation.entities.Flight;
import com.young.flightreservation.entities.Passenger;
import com.young.flightreservation.entities.Reservation;
import com.young.flightreservation.repos.FlightRepository;
import com.young.flightreservation.repos.PassengerRepository;
import com.young.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceslmpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		// Make Payment

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
