package com.shamsi.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shamsi.flightcheckin.integration.ReservationRestClient;
import com.shamsi.flightcheckin.integration.dto.Reservation;
import com.shamsi.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient restclient ;
	
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
	
		return "startCheckin";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId , ModelMap  modelMap  ) {
		Reservation reservation = restclient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";}
	
	@RequestMapping ("/completeCheckin")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId ,@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restclient.UpdateReservation(reservationUpdateRequest);

		return "checkInConfirmation";}
	
	
	
	
	
	
	
	
}
