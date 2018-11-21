package br.com.webwork.springmobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.webwork.springmobile.response.DeviceTypeResponse;
import br.com.webwork.springmobile.service.DeviceModel;

@Controller
@RequestMapping("/devices")
public class DeviceController {
	
	@Autowired
	private DeviceModel service;
	
	@GetMapping
	public ResponseEntity<DeviceTypeResponse> verify(Device device) {
		 return this.service.verifyTypeDevice(device);
	}
}
