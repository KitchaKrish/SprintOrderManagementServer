package com.online.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.entity.OnlineEntity;

public interface IOnlineRepository extends JpaRepository<OnlineEntity, Integer>{

	List<OnlineEntity> findByOrderUserName(String name);

	OnlineEntity findByOrderId(Integer orderId);

}
