package com.shamsi.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shamsi.flightcheckin.integration.dto.Reservation;
import com.shamsi.flightcheckin.integration.dto.ReservationUpdateRequest;
@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Override
	public Reservation findReservation(Long id) {
      RestTemplate restTemplate = new RestTemplate();
      Reservation reservation = restTemplate.getForObject("http://localhost:8080/flightresarvation/reservation/"+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation UpdateReservation(ReservationUpdateRequest request) {
		 RestTemplate restTemplate = new RestTemplate();
		 Reservation reservation = restTemplate.postForObject("http://localhost:8080/flightresarvation/reservations/", request,  Reservation.class);
		return reservation;
	}

}
