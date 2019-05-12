package com.young.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.young.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
