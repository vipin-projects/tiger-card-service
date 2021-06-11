package com.sahaj.tiger.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sahaj.tiger.db.entity.CappingLimit;
import com.sahaj.tiger.db.entity.Fare;

@Repository
public interface CapLimitRepository extends JpaRepository<Fare, Integer>{
	@Query("select c from CappingLimit c where c.fromZone=:zone1 and c.toZone=:zone2")
	CappingLimit fetchCappingLimit(String zone1, String zone2);
}
