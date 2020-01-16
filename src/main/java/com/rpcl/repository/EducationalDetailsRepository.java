package com.rpcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpcl.entity.EducationalDetailsEntity;
@Repository
public interface EducationalDetailsRepository extends JpaRepository<EducationalDetailsEntity, Integer> {

}
