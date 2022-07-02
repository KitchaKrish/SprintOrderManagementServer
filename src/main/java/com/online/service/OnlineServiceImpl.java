package com.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.entity.OnlineEntity;

@Service
public class OnlineServiceImpl implements OnlineService {
	
	@Autowired
	private IOnlineRepository ionlineRepository;

	@Override
	public OnlineEntity saveOrderDetails(OnlineEntity onlineEntity) {
		try {
			return ionlineRepository.save(onlineEntity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OnlineEntity> fetchAllOrderDetails() {
		return ionlineRepository.findAll();
	}

	@Override
	public OnlineEntity updateOrderDetails(Integer orderId, OnlineEntity onlineEntity) {
		OnlineEntity  existOnlineEntity = ionlineRepository.findById(orderId).orElseThrow();
		if(existOnlineEntity!=null) {
			existOnlineEntity.setFromAddress(onlineEntity.getFromAddress());
			existOnlineEntity.setToAddress(onlineEntity.getToAddress());
			existOnlineEntity.setOrderPrice(onlineEntity.getOrderPrice());
			existOnlineEntity.setOrderUserName(onlineEntity.getOrderUserName());
			existOnlineEntity.setOrderProduct(onlineEntity.getOrderProduct());
			existOnlineEntity.setOrderBrand(onlineEntity.getOrderBrand());
			ionlineRepository.save(existOnlineEntity);
		}
		
		return existOnlineEntity;
	}

	@Override
	public List<OnlineEntity> getOrderDetailsByName(String name) {
		return ionlineRepository.findByOrderUserName(name);
	}

	@Override
	public OnlineEntity getOrderDetailsById(Integer orderId) {
		return ionlineRepository.findById(orderId).orElseThrow();
	}

	@Override
	public void deleteOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		ionlineRepository.deleteById(orderId);
	}

}
