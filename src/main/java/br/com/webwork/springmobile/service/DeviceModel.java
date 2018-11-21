package br.com.webwork.springmobile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;

import br.com.webwork.springmobile.controller.DeviceController;
import br.com.webwork.springmobile.response.DeviceTypeResponse;

@Configuration
public class DeviceModel {

	private static final Logger logger =  LoggerFactory.getLogger(DeviceController.class);
	
	public ResponseEntity<DeviceTypeResponse> verifyTypeDevice(Device device) {
	
		if(device.isMobile()) {
			logger.info("This request was made by a device.");
			
			DeviceTypeResponse type = DeviceTypeResponse.builder()
					.isMobile(device.isMobile())
					.platform(device.getDevicePlatform().name()).build();
			
			return new ResponseEntity<>(type, HttpStatus.OK);
			
		
		}else if(device.isTablet()) {
			logger.info("This request was made by a tablet.");
			
			DeviceTypeResponse type = DeviceTypeResponse.builder()
					.isTablet(device.isTablet())
					.platform(device.getDevicePlatform().name()).build();
			
			return new ResponseEntity<>(type, HttpStatus.OK);
		}
		else {
            logger.info("This request was made by a desktop.");
            
            DeviceTypeResponse type =  DeviceTypeResponse.builder()
					.isNormal(device.isNormal())
					.platform(device.getDevicePlatform().name()).build();
            
            return new ResponseEntity<>(type, HttpStatus.OK);
        }
	}
}
