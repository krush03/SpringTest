package com.nt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Otp;
import com.nt.exception.OtpNotFoundException;
import com.nt.service.OtpService;

@RestController
public class OtpController {
	@Autowired
	private OtpService otpService;

	@PostMapping("/add")
	public ResponseEntity<String> AddOtp(@RequestBody Otp otp) {
		otpService.createOtp(otp);
		return new ResponseEntity<String>("OTP Added", HttpStatus.OK);
	}

	// find by id
	@GetMapping("/getOtp/{id}")
	public Otp getOtp(@PathVariable Long id) {
		Optional<Otp> otp = otpService.searchOtp(id);
		if (!otp.isPresent()) {
			throw new OtpNotFoundException("id::" + id);
		}
		return otp.get();
	}

	// update otp
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> udateOtp(@RequestBody Otp otp, @PathVariable Long id) {
		Optional<Otp> otpDetails = otpService.searchOtp(id);
		if (!otpDetails.isPresent()) {
			throw new OtpNotFoundException("ID::" + id);
		}
		otp.setId(id);
		otpService.createOtp(otp);
		return ResponseEntity.noContent().build();
	}

	// find by name
	@GetMapping("/name/{name}")
	public Otp getOtpDetails(@PathVariable String name) {
		System.out.println("name");
		return otpService.findOtpByName(name);
	}
}
