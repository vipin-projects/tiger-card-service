package com.sahaj.tiger.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sahaj.tiger.db.entity.Fare;

@Repository
public interface FareRepository extends JpaRepository<Fare, Integer>{
	@Query("select f from Fare f where f.fromZone=:zone1 and f.toZone=:zone2")
	Fare fetchFare(String zone1, String zone2);
}
