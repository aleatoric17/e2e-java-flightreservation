package com.young.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.young.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
