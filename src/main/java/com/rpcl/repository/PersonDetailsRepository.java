package com.rpcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpcl.entity.PersonDetailsEntity;
@Repository
public interface PersonDetailsRepository extends JpaRepository<PersonDetailsEntity, Integer> {

}
