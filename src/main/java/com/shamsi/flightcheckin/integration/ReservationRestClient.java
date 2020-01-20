package com.shamsi.flightcheckin.integration;

import com.shamsi.flightcheckin.integration.dto.Reservation;
import com.shamsi.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation UpdateReservation(ReservationUpdateRequest request );
	

}
