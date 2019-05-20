package com.young.flightreservation.services;

import com.young.flightreservation.dto.ReservationRequest;
import com.young.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request); 

}
