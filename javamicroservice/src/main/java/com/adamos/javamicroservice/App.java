package com.adamos.javamicroservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adamos.javamicroservice.logging.Log;
import com.adamos.javamicroservice.logging.Logger;
import com.cumulocity.microservice.autoconfigure.MicroserviceApplication;

@MicroserviceApplication
@RestController
public class App {

	
	
	@Autowired
	Logger logger;
	
	@Autowired
	DeviceService deviceService;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	
	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public List<String> getDevices() {
		return deviceService.getDevices();
	}
	
	@RequestMapping(value = "/devices2", method = RequestMethod.GET)
	public List<String> getDevices2() {
		return deviceService.getDevicesAsServiceUser();
	}
	
	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	public List<Log> logs() {
		return logger.getLogs();
	}


}
