package com.sahaj.tiger.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahaj.tiger.db.entity.OffPeakHours;

@Repository
public interface OffPeakHoursRepository extends JpaRepository<OffPeakHours, Integer>{
	
}
