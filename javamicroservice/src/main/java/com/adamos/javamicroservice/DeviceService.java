package com.adamos.javamicroservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cumulocity.microservice.subscription.service.MicroserviceSubscriptionsService;
import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.cumulocity.sdk.client.inventory.InventoryApi;

@Service
public class DeviceService {

	
	@Autowired
	InventoryApi inventoryApi;
	
	@Autowired
	MicroserviceSubscriptionsService service;
	
	@Value("${C8Y.tenant}")
    private String tenant;
	
	
	public List<String> getDevices() {
		List<String> result = new ArrayList<>();
		
		Iterable<ManagedObjectRepresentation> devices = inventoryApi.getManagedObjects().get().allPages();
		
		
		for (ManagedObjectRepresentation device : devices) {
			result.add(device.getName());
		}
		
		return result;
		
	}

	
	public List<String> getDevicesAsServiceUser() {
		
		
		return service.callForTenant(tenant, new Callable<List<String>>() {

			public List<String> call() {
				List<String> result = new ArrayList<>();
				Iterable<ManagedObjectRepresentation> devices = inventoryApi.getManagedObjects().get().allPages();
				
				
				for (ManagedObjectRepresentation device : devices) {
					result.add(device.getName());
				}
				return result;
			}

			
		});

	}
	
}
