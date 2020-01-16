package com.rpcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpcl.entity.DegreesEntity;
import com.rpcl.entity.YearsEntity;
@Repository
public interface DegreesRepository extends JpaRepository<DegreesEntity, Integer> {

	@Query(value = "select degreeName from DegreesEntity")
	public List<String> getDegrees();
}
