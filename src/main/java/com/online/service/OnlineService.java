package com.online.service;

import java.util.List;

import com.online.entity.OnlineEntity;

public interface OnlineService {

	OnlineEntity saveOrderDetails(OnlineEntity onlineEntity);

	List<OnlineEntity> fetchAllOrderDetails();

	OnlineEntity updateOrderDetails(Integer orderId, OnlineEntity onlineEntity);

	List<OnlineEntity> getOrderDetailsByName(String name);
	
	OnlineEntity getOrderDetailsById(Integer orderId);

	void deleteOrderById(Integer orderId);
}
