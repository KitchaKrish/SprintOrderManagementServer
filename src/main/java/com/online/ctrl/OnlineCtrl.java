package com.online.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.entity.OnlineEntity;
import com.online.entity.OutputMessage;
import com.online.service.OnlineService;

@RestController
@RequestMapping(value = "/order")
@CrossOrigin(origins = "*")
public class OnlineCtrl {

	@Autowired
	private OnlineService onlineService;

	@GetMapping(value = "/test")
	public String test() {
		return "Hello";
	}

	@PostMapping(value = "/saveOrder")
	public OutputMessage saveOrderDetatils(@RequestBody OnlineEntity onlineEntity) {
		OutputMessage outputMessage = new OutputMessage();
		try {
			
			OnlineEntity saveEntity = onlineService.saveOrderDetails(onlineEntity);
			outputMessage = new OutputMessage(true, saveEntity.getOrderProduct() + " Saved Successfully");
		} catch (Exception e) {
			System.err.println(e);
			outputMessage = new OutputMessage(false, "Somthing Went to Wrong");
		}

		return outputMessage;
	}

	@PutMapping(value = "/editOrder/{orderId}")
	public OutputMessage updateOrderDetatils(@PathVariable Integer orderId, @RequestBody OnlineEntity onlineEntity) {
		OutputMessage outputMessage = new OutputMessage();
		try {
			OnlineEntity saveEntity = onlineService.updateOrderDetails(orderId, onlineEntity);
			outputMessage = new OutputMessage(true, saveEntity.getOrderProduct() + " updated Successfully");
		} catch (Exception e) {
			System.err.println(e);
			outputMessage = new OutputMessage(false, "OrderId Not Found");
		}
		return outputMessage;
	}

	@GetMapping(value = "/showAllOrderDetails")
	public List<OnlineEntity> showAllOrderDetails() {
		return onlineService.fetchAllOrderDetails();
	}

	@GetMapping(value = "/showAllOrderDetailsByName/{name}")
	public List<OnlineEntity> showOrderDetailByName(@PathVariable String name) {
		return onlineService.getOrderDetailsByName(name);
	}
	
	@DeleteMapping(value = "/deleteOrderById/{orderId}")
	public OutputMessage deleteOrderById(@PathVariable Integer orderId) {
		OutputMessage outputMessage = new OutputMessage();
		try {
		 onlineService.deleteOrderById(orderId);
			outputMessage = new OutputMessage(true, "Order has been  deleted");
		} catch (Exception e) {
			System.err.println(e);
			outputMessage = new OutputMessage(false, "Somthing Went to Wrong");
		}
		return outputMessage;
	}

	
	@GetMapping(value = "/showAllOrderDetailsById/{orderId}")
	public OnlineEntity showAllOrderDetailsById(@PathVariable Integer orderId) {
		return onlineService.getOrderDetailsById(orderId);
	}
	
	
}
