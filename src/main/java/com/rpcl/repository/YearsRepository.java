package com.rpcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpcl.entity.YearsEntity;
@Repository
public interface YearsRepository extends JpaRepository<YearsEntity, Integer> {

	@Query(value = "select year from YearsEntity")
	public List<Integer> getYears();
}
