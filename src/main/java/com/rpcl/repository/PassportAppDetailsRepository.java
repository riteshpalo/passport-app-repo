package com.rpcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcl.entity.PassportAppDtlsEntity;

public interface PassportAppDetailsRepository extends JpaRepository<PassportAppDtlsEntity, Integer> {

}
