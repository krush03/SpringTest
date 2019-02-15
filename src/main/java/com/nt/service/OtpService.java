package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Otp;
import com.nt.repo.OtpRepository;

@Service
public class OtpService {
	@Autowired
	private OtpRepository otpRepository;
	//save otp
		public Otp createOtp(Otp otp) {
			return otpRepository.save(otp);
		}
	//find details by id
		public Optional<Otp> searchOtp(Long id) {
			return otpRepository.findById(id);
		}
	//find by name
		public Otp findOtpByName(String name) {
			return otpRepository.findOtpByName(name);
		}
	//out of the concept just for unit testing
		
		public float calcSimpleIntrAmt(float pAmt,float rate,float time) {
			float intrAmt=0.0f;
			/*try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			if (pAmt<=0||rate<=0||time<=0) {
				throw new IllegalArgumentException("Invalid Input");
			}
			intrAmt=(pAmt*time*rate)/100.0f;
			return intrAmt;
		}
}

