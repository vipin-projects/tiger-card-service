package com.sahaj.tiger.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahaj.tiger.db.entity.PeakHours;

@Repository
public interface PeakHoursRepository extends JpaRepository<PeakHours, Integer>{
	
}
