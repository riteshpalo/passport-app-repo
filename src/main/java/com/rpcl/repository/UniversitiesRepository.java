package com.rpcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpcl.entity.UniversitiesEntity;
@Repository
public interface UniversitiesRepository extends JpaRepository<UniversitiesEntity, Integer> {

	@Query(value = "select univName from UniversitiesEntity")
	public List<String> getUniversities();
}
