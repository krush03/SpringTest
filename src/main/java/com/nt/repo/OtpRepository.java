package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.entity.Otp;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
	@Query("SELECT o FROM com.nt.entity.Otp o WHERE o.name=?1")
	public Otp findOtpByName(String name);
}
