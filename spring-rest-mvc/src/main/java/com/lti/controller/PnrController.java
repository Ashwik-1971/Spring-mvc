package com.lti.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Passenger;
import com.lti.model.Passenger.Gender;
import com.lti.model.Passenger.Status;
import com.lti.model.Pnr;

//Assumption: We are working for Irctc
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PnrController {

	@GetMapping("/pnr")
	public Pnr getPnrStatus(@RequestParam("q") int pnrNo){
		Pnr pnr=new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2021, 01, 8));
		
		List<Passenger> passengers =new ArrayList<Passenger>();
		
		Passenger pas1=new Passenger();
		pas1.setName("Rahul");
		pas1.setGender(Gender.MALE);
		pas1.setStatus(Status.WAITING);
		
		Passenger pas2=new Passenger();
		pas2.setName("Modi");
		pas2.setGender(Gender.MALE);
		pas2.setStatus(Status.CONFIRMED);
		
		Passenger pas3=new Passenger();
		pas3.setName("Amit");
		pas3.setGender(Gender.MALE);
		pas3.setStatus(Status.CONFIRMED);
		
		passengers.add(pas1);
		passengers.add(pas2);
		passengers.add(pas3);
		
		pnr.setPassenger(passengers);

		return pnr;
		
	}
}
